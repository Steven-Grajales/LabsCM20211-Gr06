package co.edu.udea.compumovil.gr06_20211.lab1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnPersonalData.setOnClickListener{
            val intent:Intent = Intent(this, PersonalDataActivity::class.java)
            startActivity(intent)
        }
    }
}