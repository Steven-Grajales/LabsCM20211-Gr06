package co.edu.udea.compumovil.gr06_20211.lab2.ui

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import co.edu.udea.compumovil.gr06_20211.lab2.R
import co.edu.udea.compumovil.gr06_20211.lab2.data.BaseViewHolder
import co.edu.udea.compumovil.gr06_20211.lab2.model.Lugares
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.fragment_lugares.*
import kotlinx.android.synthetic.main.lugares_fila.view.*

class Adapter(private val context: Context, private val lugaresList:List<Lugares>,
              private val itemClickLister: Adapter.OnSitioClickListener) :
    RecyclerView.Adapter<BaseViewHolder<*>>(){

    interface OnSitioClickListener{
        fun OnSitioClick(lugares: Lugares)
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder<*> {
        return MainViewHolder(LayoutInflater.from(context).inflate(R.layout.lugares_fila,parent,false))
    }

    override fun onBindViewHolder(holder: BaseViewHolder<*>, position: Int) {
        when(holder){
            is MainViewHolder -> holder.bind(lugaresList[position],position)
        }
    }

    override fun getItemCount(): Int {
        return lugaresList.size
    }

    inner class MainViewHolder(itemView: View): BaseViewHolder<Lugares>(itemView){
        override fun bind(item: Lugares, position: Int) {
            Glide.with(context).load(item.imagen).centerCrop().into(itemView.img_sitio)
            itemView.txt_titulo.text = item.nombre
            itemView.txt_informacion.text = item.informacion
            itemView.setOnClickListener { itemClickLister.OnSitioClick(item)}
        }


    }


}