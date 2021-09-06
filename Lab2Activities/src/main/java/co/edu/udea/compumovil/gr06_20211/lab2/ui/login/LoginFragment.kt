package co.edu.udea.compumovil.gr06_20211.lab2.ui.login


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
import kotlinx.android.synthetic.main.fragment_login.*

class LoginFragment : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_login, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val database = this.context?.let {
            DataBase.getDatabase(it)}

            btn_ingresar.findViewById<Button>(R.id.btn_ingresar)
            btn_ingresar.setOnClickListener{
                val user = txt_username.text.toString()
                val pass = txt_password.text.toString()

                if(user.isEmpty() || pass.isEmpty() ){
                    Toast.makeText(requireContext(), "Todos los campos son obligatorios", Toast.LENGTH_LONG).show()
                }else{
                    if(database!= null){
                        database.UserDao().getUser(user).observe(
                            viewLifecycleOwner,
                            Observer { result ->
                                Toast.makeText(requireContext(), "Bienvenido $user", Toast.LENGTH_LONG).show()
                                findNavController().navigate(R.id.lugaresFragment)
                                /*
                                if(result != null && result.pass.equals(pass)){
                                    Toast.makeText(requireContext(), "Bienvenido $user", Toast.LENGTH_SHORT).show()
                                    findNavController().navigate(R.id.lugaresFragment)
                                }
                                 */
                            })
                    }
                }


            }




        }



}