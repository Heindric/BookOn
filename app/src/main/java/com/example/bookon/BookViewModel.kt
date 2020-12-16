package com.example.bookon

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class BookViewModel(private val BookRepo : BookRepo) : ViewModel() {
    var book = MutableLiveData<List<ModelBook>>()

    fun getBook(): LiveData<List<ModelBook>> {
        book.value = BookRepo.getBooking()
        return book
    }

    fun addBook(newBook: ModelBook){
        BookRepo.addBooking(newBook)
        book.value = BookRepo.getBooking()
    }
}
