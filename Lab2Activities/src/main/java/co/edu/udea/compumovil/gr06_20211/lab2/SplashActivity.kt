package co.edu.udea.compumovil.gr06_20211.lab2

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import androidx.core.content.ContentProviderCompat.requireContext
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import co.edu.udea.compumovil.gr06_20211.lab2.settings.SettingsFragment
import co.edu.udea.compumovil.gr06_20211.lab2.utils.Util
import java.security.AccessController.getContext

class SplashActivity : AppCompatActivity() {
    private lateinit var sharedPreferences: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        sharedPreferences = getSharedPreferences("Preferences", Context.MODE_PRIVATE)!!

        val intentMain =  Intent(this, MainActivity::class.java)
        //val intentLugares =  Intent(requireContext(), LugaresFragment::class.java)

        /*
        val navController = findNavController(R.id.NavHostFragment)
        navController.navigate(R.id.lugaresFragment)

        if(!TextUtils.isEmpty(Util.getUserPrefs(sharedPreferences)) && !TextUtils.isEmpty(Util.getPassPrefs(sharedPreferences))){
           // Navigation.findNavController(this,  R.id.NavHostFragment).navigate(R.id.lugaresFragment)
           // startActivity(intentLugares)
            startActivity(intentMain)
        }else {
            startActivity(intentMain)

        }
        finish()

         */
    }
}