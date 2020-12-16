package com.example.bookon

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class BookViewModel(private val mhsRepo : BookRepo) : ViewModel() {
    var mhs = MutableLiveData<List<ModelBook>>()

    fun getMhs(): LiveData<List<ModelBook>> {
        mhs.value = mhsRepo.getBooking()
        return mhs
    }

    fun addMhs(newMhs: ModelBook){
        mhsRepo.addBooking(newMhs)
        mhs.value = mhsRepo.getBooking()
    }
}
