package co.edu.udea.compumovil.gr06_20211.lab1

import android.app.DatePickerDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.*

import kotlinx.android.synthetic.main.activity_personal_data.*
import java.util.*

class PersonalDataActivity : AppCompatActivity() {

    lateinit var SpinnerSeleccionado:String
    var fechaLog = "vacio"
    var inputSexo = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_personal_data)
        listSpinner()

        radioGroup.setOnCheckedChangeListener{group, checkedID ->

            if(checkedID == R.id.radioButtonHombre)
                inputSexo = "Masculino"
            if(checkedID == R.id.radioButtonMujer)
                inputSexo = "Femenino"
        }
    }

    /**
     * Función usada para obtener el grado de escolaridad
     * y listarlo en el spinner
     */

    fun listSpinner(){
        val spinner = findViewById<Spinner>(R.id.spinner)

        var items = listOf("Primaria", "Secundaria", "Universitaria", "otro")

        spinner.adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, items)

        spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{
            override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
                SpinnerSeleccionado = items.get(p2)
            }
            override fun onNothingSelected(p0: AdapterView<*>?) {
            }
        }
    }

    /**
     * Función para obtener de un DataPicker su información
     * y luego mostrarlo en un campo texto
     */
    @Suppress("UNUSED_PARAMETER")
    fun getDate(view: View){
        val calendario = Calendar.getInstance()
        val dia = calendario.get(Calendar.DAY_OF_MONTH)
        val mes = calendario.get(Calendar.MONTH)
        val anio_actual = calendario.get(Calendar.YEAR)
        val picker = DatePickerDialog(this, android.R.style.Theme_DeviceDefault_Dialog, DatePickerDialog.OnDateSetListener { _ , anio, mesAnio, diaMes ->
            var fecha = String.format("%d/%d/%d",diaMes,(mesAnio+1),anio)
            textViewDate.text = fecha
            fechaLog = fecha
        }, anio_actual, mes, dia)
        picker.show()
    }

    /**
     * Funciones para guardar y restaurar el estado de la fecha en un cambio de Orientación
     * más info: https://medium.com/android-news/handling-orientation-changes-in-android-7072958c442a
     */
    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putCharSequence("savedDate", textViewDate.text)
    }
    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        textViewDate.text = savedInstanceState.getCharSequence("savedDate")
    }

    fun addInfo(view: View){
        val inputNombres = findViewById<EditText>(R.id.EditTextNombres)
        val inputApellidos = findViewById<EditText>(R.id.editTextApellidos)
        var inputSexo = inputSexo
        Log.i("nombres", inputNombres.toString())
        Log.i("sexo", inputSexo)
        if(fechaLog != "vacio" && inputNombres.text.toString().isNotEmpty() && inputApellidos.text.toString().isNotEmpty()){
            Log.i("Nombres",   inputNombres.text.toString())
            Log.i("Apellidos", inputApellidos.text.toString())
            Log.i("Sexo", inputSexo)
            Log.i("Nació el", fechaLog)
            Log.i("Escolaridad", SpinnerSeleccionado)

        }else{
            Toast.makeText(this, "Ingresar campos obligatorios", Toast.LENGTH_SHORT).show()
        return}
        Toast.makeText(this, "Guardado!", Toast.LENGTH_SHORT).show()
    }


}