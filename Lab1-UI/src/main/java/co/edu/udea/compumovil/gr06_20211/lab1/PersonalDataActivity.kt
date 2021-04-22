package co.edu.udea.compumovil.gr06_20211.lab1

import android.annotation.SuppressLint
import android.app.AlertDialog
import android.app.DatePickerDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.DatePicker
import android.widget.Spinner

import kotlinx.android.synthetic.main.activity_personal_data.*
import java.util.*

class PersonalDataActivity : AppCompatActivity() {

    lateinit var resultado:String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_personal_data)
        listSpinner()
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
                resultado = items.get(p2)
            }
            override fun onNothingSelected(p0: AdapterView<*>?) {
            }
        }
    }

    /**
     * Función para obtener de un DataPicker su información
     * y luego mostrarlo en un campo texto
     */
    fun getDate(view: View){
        val calendario = Calendar.getInstance()
        val dia = calendario.get(Calendar.DAY_OF_MONTH)
        val mes = calendario.get(Calendar.MONTH)
        val anio = calendario.get(Calendar.YEAR)
        val picker = DatePickerDialog(this, android.R.style.Theme_DeviceDefault_Dialog, DatePickerDialog.OnDateSetListener { _ , anio:Int, mesAnio:Int, diaMes:Int ->
            var fecha = String.format("%d/%d/%d",diaMes,(mesAnio+1),anio)
            textViewDate.text = fecha
        }, anio, mes, dia)
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
}