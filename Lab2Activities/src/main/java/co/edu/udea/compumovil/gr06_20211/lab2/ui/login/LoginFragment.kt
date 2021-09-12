package co.edu.udea.compumovil.gr06_20211.lab2.ui.login


import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.fragment.app.Fragment
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import co.edu.udea.compumovil.gr06_20211.lab2.R
import co.edu.udea.compumovil.gr06_20211.lab2.data.DataBase
import co.edu.udea.compumovil.gr06_20211.lab2.model.User_Entity_Activity
import co.edu.udea.compumovil.gr06_20211.lab2.ui.register.ActivityRegisterUser
import kotlinx.android.synthetic.main.fragment_login.*

class LoginFragment : Fragment() {

     lateinit var sharedPreferences: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        sharedPreferences = activity?.getSharedPreferences("Preferences", Context.MODE_PRIVATE)!!
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_login, container, false)
    }

    fun saveOnPreferences( user: String, password: String){
        val editor = sharedPreferences.edit()
        editor.putString("user", user)
        editor.putString("pass", password)
        editor.apply()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val database = this.context?.let {
            DataBase.getDatabase(it)}

            btn_ingresar.findViewById<Button>(R.id.btn_ingresar)
            btn_ingresar.setOnClickListener{
                val user = txt_username_register.text.toString()
                val pass = txt_password.text.toString()

                if(user.isEmpty() || pass.isEmpty() ){
                    Toast.makeText(requireContext(), "Todos los campos son obligatorios", Toast.LENGTH_LONG).show()
                }else{

                    if(database!= null){
                        database.UserDao().getUser(user).observe(
                            viewLifecycleOwner,
                            Observer { result ->
                                if(result != null && result.pass.equals(pass)){
                                    Toast.makeText(requireContext(), "Bienvenido $user", Toast.LENGTH_SHORT).show()
                                    saveOnPreferences(user, pass)
                                    findNavController().navigate(R.id.lugaresFragment)
                                }else{
                                    Toast.makeText(requireContext(), "Usuario o contraseña incorrecto", Toast.LENGTH_LONG).show()
                                }
                            })
                    }
                }
            }

        btn_register_login.setOnClickListener{
            val intent = Intent(activity, ActivityRegisterUser::class.java)
            startActivity(intent)
        }

    }
}