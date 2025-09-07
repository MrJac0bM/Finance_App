package com.example.financeapp.ViewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.financeapp.Domain.ExpenseDomain
import com.example.financeapp.Domain.HeaderDomain
import com.example.financeapp.Repository.MainRepository

class MainViewModel(val repository: MainRepository) : ViewModel() {
    constructor() : this(MainRepository())

    val expenses: LiveData<MutableList<ExpenseDomain>> = repository.getItems()
    val header: LiveData<MutableList<HeaderDomain>> = repository.getHeader()
    val budgets = repository.budget
}