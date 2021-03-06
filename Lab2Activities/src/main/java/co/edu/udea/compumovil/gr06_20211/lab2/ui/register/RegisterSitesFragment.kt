package co.edu.udea.compumovil.gr06_20211.lab2.ui.register

import android.content.Intent
import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import co.edu.udea.compumovil.gr06_20211.lab2.R
import co.edu.udea.compumovil.gr06_20211.lab2.settings.SettingsActivity
import co.edu.udea.compumovil.gr06_20211.lab2.data.DataBase
import co.edu.udea.compumovil.gr06_20211.lab2.model.Lugares
import kotlinx.android.synthetic.main.fragment_register_sites.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class RegisterSitesFragment : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        setHasOptionsMenu(true)
        return inflater.inflate(R.layout.fragment_register_sites, container, false)
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.main_menu, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (R.id.settings == item.itemId) {
            toSettings()
            return true
        }
        return super.onOptionsItemSelected(item)
    }

    private fun toSettings() {
        val intent = Intent(activity, SettingsActivity::class.java)
        startActivity(intent)
    }
/*
    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.options_menu, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return NavigationUI.
        onNavDestinationSelected(item,requireView().findNavController())
                || super.onOptionsItemSelected(item)
    }

 */

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val database = this.context?.let {
            DataBase.getDatabase(it) }

        btn_save_register_site.setOnClickListener {
            val nombre= txt_title_register_site.text.toString()
            val imagen= txt_url_img_site.text.toString()
            val informacion= txt_information_register_site.text.toString()
            val temperatura= txt_temperature_register_site.text.toString()

            if (nombre.isEmpty()||informacion.isEmpty()||temperatura.isEmpty()) {
                Toast.makeText(requireContext(), "Por favor diligencie todos los campos", Toast.LENGTH_SHORT).show()
            }else {
                val lugares = Lugares(nombre, imagen, informacion,"",temperatura)
                Toast.makeText(requireContext(), "Nuevo registro de sitio guardado", Toast.LENGTH_SHORT).show()

                CoroutineScope(Dispatchers.IO).launch {
                    if (database != null) {
                        database.lugares().insert(lugares)
                    }
                }

                findNavController().navigate(R.id.lugaresFragment)
            }

        }

    }

}