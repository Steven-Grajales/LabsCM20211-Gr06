package co.edu.udea.compumovil.gr06_20211.lab2

import android.content.Intent
import android.os.Bundle
import androidx.navigation.fragment.findNavController
import androidx.preference.Preference
import androidx.preference.PreferenceFragmentCompat
import co.edu.udea.compumovil.gr06_20211.lab2.ui.login.LoginFragment

class SettingsFragment : PreferenceFragmentCompat() {

    override fun onCreatePreferences(savedInstanceState: Bundle?, rootKey: String?) {
        setPreferencesFromResource(R.xml.root_preferences, rootKey)

        /*
        val myPref = findPreference("pref_key_category_signed_out") as Preference?
        myPref!!.setOnPreferenceClickListener(object : Preference.OnPreferenceClickListener {
            override fun onPreferenceClick(preference: Preference?): Boolean {
                //findNavController().navigate(R.id.loginFragment)
                val signOutIntent = Intent(context    , LoginFragment::class.java)
                startActivity(signOutIntent)
               println("Holaaaaaa")

                return true
            }
        })

         */

    }



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
}