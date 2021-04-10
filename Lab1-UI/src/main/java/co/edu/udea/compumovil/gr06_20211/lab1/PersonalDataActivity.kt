package co.edu.udea.compumovil.gr06_20211.lab1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Spinner

class PersonalDataActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_personal_data)
        val spinner = findViewById<Spinner>(R.id.spinner)

        var lista = listOf("Primaria", "Secundaria", "Universitaria", "otro")

        var adaptador = ArrayAdapter(this, android.R.layout.simple_spinner_item, lista)
        spinner.adapter = adaptador
    }
}