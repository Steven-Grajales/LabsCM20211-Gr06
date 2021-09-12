package co.edu.udea.compumovil.gr06_20211.lab2.utils

import android.content.SharedPreferences

class Util {

    companion object {
         fun getPassPrefs(preferences: SharedPreferences): String? {
            return preferences.getString("user", "")
        }

         fun getUserPrefs(preferences: SharedPreferences): String? {
            return preferences.getString("pass", "")
        }
    }




}