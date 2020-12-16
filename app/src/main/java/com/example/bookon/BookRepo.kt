package com.example.bookon

class BookRepo {
    var bookingList = mutableListOf<ModelBook>()


    init {
        bookingList.add(ModelBook("Gilbert", "A15", "15 Desember 2020", "15.00"))

    }

    fun getBooking() = bookingList

    fun addBooking(newBook : ModelBook){
        bookingList.add(newBook)
    }
}