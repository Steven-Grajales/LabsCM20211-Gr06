package co.edu.udea.compumovil.gr06_20211.lab2.ui.register

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.core.content.ContentProviderCompat.requireContext
import androidx.lifecycle.Observer
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import co.edu.udea.compumovil.gr06_20211.lab2.R
import co.edu.udea.compumovil.gr06_20211.lab2.data.DataBase
import co.edu.udea.compumovil.gr06_20211.lab2.model.User_Entity_Activity
import kotlinx.android.synthetic.main.activity_register_user.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ActivityRegisterUser : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register_user)

        val dataBaseUser = DataBase.getDatabase(this)

        btn_registrar.setOnClickListener {
            val user = txt_username_register.text.toString()
            val pass = txt_password_register.text.toString()
            val email = txt_email_register.text.toString()

            val objuser = User_Entity_Activity(user, pass, email)

            if (user.isEmpty() || pass.isEmpty() || email.isEmpty()) {
                Toast.makeText(applicationContext,"Todos los campos son obligatorios",Toast.LENGTH_LONG).show()
            } else {
                CoroutineScope(Dispatchers.IO).launch {
                    dataBaseUser.UserDao().insert(objuser)
                    this@ActivityRegisterUser.finish()

                }
                Toast.makeText(applicationContext,"Usuario registrado",Toast.LENGTH_LONG).show()
                /*
                dataBaseUser.UserDao().getUserAndEmail(user, email).observe(this,
                    Observer { result ->
                        println(result)
                        if (result != null) {
                            Toast.makeText(applicationContext,"El Usuario/Email ya existe",Toast.LENGTH_LONG).show()
                        } else {

                            CoroutineScope(Dispatchers.IO).launch {
                                Toast.makeText(applicationContext,"Usuario registrado",Toast.LENGTH_LONG).show()
                                dataBaseUser.UserDao().insert(objuser)
                                this@ActivityRegisterUser.finish()

                            }
                            }
                        })*/
            }
        }
    }
}