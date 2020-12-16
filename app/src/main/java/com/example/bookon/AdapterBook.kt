package com.example.bookon

import android.view.LayoutInflater
import android.view.TextureView
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.lifecycle.LiveData
import androidx.recyclerview.widget.RecyclerView

class AdapterMhs(val booking: LiveData<List<ModelBook>>) : RecyclerView.Adapter<AdapterMhs.MhsViewHolder>() {

    inner class MhsViewHolder(items: View): RecyclerView.ViewHolder(items)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MhsViewHolder {
        val layoutInflater =      LayoutInflater.from(parent.context).inflate(R.layout.show_booking, parent, false)
        return MhsViewHolder(layoutInflater)
    }

    override fun getItemCount(): Int {
        return booking.value?.size ?: 0
    }

    override fun onBindViewHolder(holder: MhsViewHolder, position: Int) {
        holder.itemView.apply {
            val tvNama = findViewById<TextView>(R.id.tv_nama)
            val tvNim = findViewById<TextView>(R.id.tv_ruang)
            val tvKelas = findViewById<TextView>(R.id.tv_tanggal)

            tvNama.text = booking.value?.get(position) ?.nama ?: ""
            tvNim.text = booking.value?.get(position) ?.ruang ?: ""
            tvKelas.text = booking.value?.get(position) ?.tanggal ?: ""
        }
    }
}
