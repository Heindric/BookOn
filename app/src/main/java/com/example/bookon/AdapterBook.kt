package com.example.bookon

import android.view.LayoutInflater
import android.view.TextureView
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.lifecycle.LiveData
import androidx.recyclerview.widget.RecyclerView

class AdapterBook(val booking: LiveData<List<ModelBook>>) :
        RecyclerView.Adapter<AdapterBook.BookViewHolder>() {

    inner class BookViewHolder(items: View): RecyclerView.ViewHolder(items)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BookViewHolder {
        val layoutInflater =      LayoutInflater.from(parent.context).inflate(R.layout.show_booking, parent, false)
        return BookViewHolder(layoutInflater)
    }

    override fun getItemCount(): Int {
        return booking.value?.size ?: 0
    }

    override fun onBindViewHolder(holder: BookViewHolder, position: Int) {
        holder.itemView.apply {
            val tvNama = findViewById<TextView>(R.id.tv_nama)
            val tvRuang = findViewById<TextView>(R.id.tv_ruang)
            val tvTanggal = findViewById<TextView>(R.id.tv_tanggal)
            val tvWaktu = findViewById<TextView>(R.id.tv_waktu)

            tvNama.text = booking.value?.get(position) ?.nama ?: ""
            tvRuang.text = booking.value?.get(position) ?.ruang ?: ""
            tvTanggal.text = booking.value?.get(position) ?.tanggal ?: ""
            tvWaktu.text = booking.value?.get(position) ?.waktu ?: ""
        }
    }
}
