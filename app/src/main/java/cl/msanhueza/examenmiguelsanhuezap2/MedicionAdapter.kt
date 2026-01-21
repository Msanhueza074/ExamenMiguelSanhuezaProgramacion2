package cl.msanhueza.examenmiguelsanhuezap2

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import cl.msanhueza.examenmiguelsanhuezap2.data.entity.Medicion
import java.text.NumberFormat
import java.util.Locale

class MedicionAdapter :
    ListAdapter<Medicion, MedicionAdapter.ViewHolder>(DiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_medicion, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val medicion = getItem(position)

        // Formato valor con puntos estilo Chile
        val localeChile = Locale.forLanguageTag("es-CL")
        val formato = NumberFormat.getNumberInstance(localeChile)
        val valorFormateado = formato.format(medicion.valor)

        // Asignar datos
        holder.txtTipo.text = medicion.tipo.uppercase()
        holder.txtValor.text = valorFormateado
        holder.txtFecha.text = medicion.fecha

        // Ícono según tipo
        val icono = when (medicion.tipo.lowercase()) {
            "agua" -> R.drawable.agua
            "luz"  -> R.drawable.luz
            "gas"  -> R.drawable.gas
            else   -> R.drawable.gas
        }

        holder.imgIcono.setImageResource(icono)
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imgIcono: ImageView = itemView.findViewById(R.id.imgIcono)
        val txtTipo: TextView = itemView.findViewById(R.id.txtTipo)
        val txtValor: TextView = itemView.findViewById(R.id.txtValor)
        val txtFecha: TextView = itemView.findViewById(R.id.txtFecha)
    }

    class DiffCallback : DiffUtil.ItemCallback<Medicion>() {
        override fun areItemsTheSame(oldItem: Medicion, newItem: Medicion): Boolean =
            oldItem.id == newItem.id

        override fun areContentsTheSame(oldItem: Medicion, newItem: Medicion): Boolean =
            oldItem == newItem
    }
}
