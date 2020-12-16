package com.example.bookon

import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Spinner
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class BookingActivity : AppCompatActivity() {
    val TAG = "Activity"
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
        val addTime = findViewById<EditText>(R.id.editTime)
        btnAdd.setOnClickListener {
            bookVM.addBook(ModelBook(addNama.text.toString(), addRuang.text.toString(), addTanggal.text.toString(), addTime.text.toString()))
            rvMain.adapter = AdapterBook(bookVM.getBook())
            rvMain.layoutManager = LinearLayoutManager(this)
        }
    }
    override fun onStart(){
        super.onStart()
        Toast.makeText(getApplicationContext(),"onStart", Toast.LENGTH_SHORT).show();
        Log.d(TAG,"onStart")
    }
    override fun onResume(){
        super.onResume()
        Toast.makeText(getApplicationContext(),"onResume", Toast.LENGTH_SHORT).show();
        Log.d(TAG,"onResume")
    }

    override fun onPause() {
        super.onPause()
        Toast.makeText(getApplicationContext(),"onPause", Toast.LENGTH_SHORT).show();
        Log.d(TAG,"onPause")
    }

    override fun onStop() {
        super.onStop()
        Toast.makeText(getApplicationContext(),"onStop", Toast.LENGTH_SHORT).show();
        Log.d(TAG,"onStop")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d(TAG,"onDestroy")
        Toast.makeText(getApplicationContext(),"onDestroy", Toast.LENGTH_SHORT).show()
    }
}