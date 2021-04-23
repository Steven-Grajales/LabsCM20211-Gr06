package co.edu.udea.compumovil.gr06_20211.lab1

import android.annotation.SuppressLint
import android.os.Build
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.AutoCompleteTextView
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import androidx.core.graphics.toColor
import co.edu.udea.compumovil.gr06_20211.lab1.api.CityRequest
import co.edu.udea.compumovil.gr06_20211.lab1.databinding.ActivityContactDataBinding
import co.edu.udea.compumovil.gr06_20211.lab1.models.Country
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.*

class ContactDataActivity : AppCompatActivity(){

    private lateinit var binding : ActivityContactDataBinding
    private lateinit var cityAdapter: ArrayAdapter<String>
    private val displayCities = mutableListOf<String>()

    @SuppressLint("ResourceAsColor")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityContactDataBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val actionBar = supportActionBar
        actionBar!!.title = getString(R.string.contact_data_title)
        actionBar.setDisplayHomeAsUpEnabled(true)

        cityAdapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, displayCities)
        binding.autocompleteCity.setAdapter(cityAdapter)

        val countries = resources.getStringArray(R.array.countries)
        val countryAdapter = ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, countries)
        binding.autocompleteCountry.setAdapter(countryAdapter)

        binding.autocompleteCountry.setOnItemClickListener { _, _, _, _ ->
            val country = Country(binding.autocompleteCountry.text.toString().toLowerCase(Locale.getDefault()))
            getCitiesByCountry(country)
        }

        binding.btnDone?.setOnClickListener {
            if (requiredFields()) {
                prinInfo()
                Toast.makeText(this, "Información registrada correctamente", Toast.LENGTH_SHORT).show()
            } else {
                binding.txtEmail.setHintTextColor(R.color.red)
                binding.txtPhone.setHintTextColor(R.color.red)
                binding.autocompleteCountry.setHintTextColor(R.color.red)
                Toast.makeText(this, "Por favor diligencie todos los campos requeridos", Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun getAPI():Retrofit{
        return Retrofit.Builder()
            .baseUrl("https://countriesnow.space/api/v0.1/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    private fun getCitiesByCountry(country:Country){
        CoroutineScope(Dispatchers.IO).launch {
            val call = getAPI().create(CityRequest::class.java).getCities(country)
            val citiesResponse = call.body()
            runOnUiThread{
                if (call.isSuccessful) {
                    val citiesList = citiesResponse?.citiesList ?: emptyList()
                    displayCities.clear()
                    displayCities.addAll(citiesList)
                    cityAdapter.notifyDataSetChanged()
                } else {
                    Toast.makeText(this@ContactDataActivity,
                        "Ocurrió un error al consultar las ciudades", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }

    private fun requiredFields(): Boolean {
        if (binding.txtPhone.text.toString() == "" || binding.txtEmail.text.toString() == ""
                || binding.autocompleteCountry.text.toString() == "") {
            return false
        }
        return true
    }

    private fun prinInfo() {
        Log.i("Encabezado", "Información de contacto")
        Log.i("Teléfono", binding.txtPhone.text.toString())
        Log.i("Email", binding.txtEmail.text.toString())
        Log.i("País", binding.autocompleteCountry.text.toString())
        Log.i("Ciudad", binding.autocompleteCity.text.toString())
        Log.i("Dirección", binding.txtAddress.text.toString())
    }
}
