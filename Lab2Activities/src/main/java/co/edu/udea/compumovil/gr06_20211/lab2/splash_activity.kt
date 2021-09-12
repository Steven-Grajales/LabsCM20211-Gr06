package co.edu.udea.compumovil.gr06_20211.lab2

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import androidx.core.content.ContentProviderCompat
import co.edu.udea.compumovil.gr06_20211.lab2.settings.SettingsFragment
import co.edu.udea.compumovil.gr06_20211.lab2.utils.Util

class splash_activity : AppCompatActivity() {

    private lateinit var sharedPreferences: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_activity)

        sharedPreferences = getSharedPreferences("Preferences", Context.MODE_PRIVATE)!!

        val intentMain =  Intent(this, MainActivity::class.java)
        startActivity(intentMain)
        /*
        if(!TextUtils.isEmpty(Util.getUserPrefs(sharedPreferences)) && !TextUtils.isEmpty(Util.getPassPrefs(sharedPreferences))){
            startActivity(intentMain)
        }else {
            supportFragmentManager
                .beginTransaction()
                .replace(R.id.splash, LugaresFragment())
                .commit()
        }
        finish()

         */
    }
}