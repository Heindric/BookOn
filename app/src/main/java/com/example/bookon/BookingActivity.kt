package com.example.bookon

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Spinner
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class BookingActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_form)

        val bookRepo = BookRepo()
        val bookVM = BookViewModel(bookRepo)
        val rvMain = findViewById<RecyclerView>(R.id.recyclerView)
        rvMain.adapter = AdapterBook(bookVM.getBook())
        rvMain.layoutManager = LinearLayoutManager(this)

        val btnAdd = findViewById<Button>(R.id.bookbtn)
        val addNama = findViewById<EditText>(R.id.editName)
        val addRuang = findViewById<EditText>(R.id.listRuang)
        val addTanggal = findViewById<EditText>(R.id.editDate)
        val addWaktu = findViewById<EditText>(R.id.editTime)
        btnAdd.setOnClickListener {
            bookVM.addBook(ModelBook(addNama.text.toString(), addRuang.text.toString(), addTanggal.text.toString(),addWaktu.text.toString()))
            rvMain.adapter = AdapterBook(bookVM.getBook())
            rvMain.layoutManager = LinearLayoutManager(this)
        }
    }
}