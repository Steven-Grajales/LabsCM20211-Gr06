package co.edu.udea.compumovil.gr06_20211.lab2.settings

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.util.Log
import androidx.navigation.fragment.findNavController
import androidx.preference.Preference
import androidx.preference.PreferenceFragmentCompat
import co.edu.udea.compumovil.gr06_20211.lab2.MainActivity
import co.edu.udea.compumovil.gr06_20211.lab2.R
import co.edu.udea.compumovil.gr06_20211.lab2.ui.register.ActivityRegisterUser

class SettingsFragment : PreferenceFragmentCompat() {

    private lateinit var sharedPreferences: SharedPreferences

    override fun onCreatePreferences(savedInstanceState: Bundle?, rootKey: String?) {
        setPreferencesFromResource(R.xml.preferences, rootKey)

        sharedPreferences = activity?.getSharedPreferences("Preferences", Context.MODE_PRIVATE)!!


        val logout: Preference? = findPreference("logout")

        // Asignar escucha de click de logout
        logout?.setOnPreferenceClickListener {
            Log.d("SettingsFragment", "\"${it.title}\" fue clickeada")
            removeSharedPreferences()
            logOut()
            false
        }

    }

    fun logOut(){

        val intent = Intent(activity, MainActivity::class.java)
        intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TASK or Intent.FLAG_ACTIVITY_NEW_TASK
        startActivity(intent)

        //findNavController().navigate(R.id.loginFragment)
    }

    fun removeSharedPreferences(){
        sharedPreferences.edit().clear().apply()
    }
    /*
    override fun onPreferenceTreeClick(preference: Preference): Boolean {
        return when (preference.key) {
            "pref_key_category_signed_out" -> {
                // so something
                println("Holaaaaaa")
                true
            }
            else -> {
                super.onPreferenceTreeClick(preferenceScreen)
            }
        }
    }

     */
}