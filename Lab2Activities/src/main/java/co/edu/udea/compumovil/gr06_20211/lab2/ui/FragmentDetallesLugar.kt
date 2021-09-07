package co.edu.udea.compumovil.gr06_20211.lab2.ui

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import co.edu.udea.compumovil.gr06_20211.lab2.R
import co.edu.udea.compumovil.gr06_20211.lab2.model.Lugares
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.fragment_detalles_lugar.*
import kotlinx.android.synthetic.main.lugares_fila.*

class FragmentDetallesLugar : Fragment() {

    private lateinit var lugares: Lugares

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        requireArguments().let {
            lugares = it.getParcelable("lugares")!!
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_detalles_lugar, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Glide.with(requireContext()).load(lugares.imagen).into(img_detalle)
        txt_titulo_detalle.text = lugares.nombre
        txt_informacion_detalle.text = lugares.informacion
        txt_temperatura_detalle.text = lugares.temperatura

        btn_ubicacion_detalle.setOnClickListener {
            val gmmIntentUri = Uri.parse("geo:0,0?q=city+"+lugares.nombre)
            val mapIntent = Intent(Intent.ACTION_VIEW, gmmIntentUri)
            mapIntent.setPackage("com.google.android.apps.maps")
            startActivity(mapIntent)
        }
        val url="https://www.google.com/search?ei=6IOLX8D8HIOG5wKfoYXwDA&q=Atracciones+destacadas+en "+lugares.nombre
        btn_sitios_recomendados.setOnClickListener {

            val gmmIntentUri = Uri.parse(url);
            val intent = Intent(Intent.ACTION_VIEW, gmmIntentUri);
            startActivity(intent);
        }



    }

}