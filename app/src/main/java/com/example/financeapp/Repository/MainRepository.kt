package com.example.financeapp.Repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.financeapp.Domain.BudgetDomain
import com.example.financeapp.Domain.ExpenseDomain
import com.example.financeapp.Domain.HeaderDomain
import com.google.firebase.Firebase
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import com.google.firebase.database.database

class MainRepository {



    private val Database = FirebaseDatabase.getInstance()


    fun getItems(): LiveData<MutableList<ExpenseDomain>> {
        val listData = MutableLiveData<MutableList<ExpenseDomain>>()
        val ref = Database.getReference("Popular")
        ref.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                val list = mutableListOf<ExpenseDomain>()
                for (data in snapshot.children) {
                    val item = data.getValue(ExpenseDomain::class.java)
                    item?.let { list.add(it) }
                }
                listData.value = list
            }

            override fun onCancelled(error: DatabaseError) {

            }
        })

        return listData
    }

    fun getHeader(): LiveData<MutableList<HeaderDomain>> {
        val listData = MutableLiveData<MutableList<HeaderDomain>>()
        val ref = Database.getReference("Banner")
        ref.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                val list = mutableListOf<HeaderDomain>()
                for (data in snapshot.children) {
                    val item = data.getValue(HeaderDomain::class.java)
                    item?.let { list.add(it) }
                }
                listData.value = list
            }

            override fun onCancelled(error: DatabaseError) {

            }
        })

        return listData
    }


    val budget = mutableListOf(
        BudgetDomain(title = "Home Load", price = 1200.0 , percent = 80.8),
        BudgetDomain(title = "Subscription", price = 550.0 , percent = 10.0),
        BudgetDomain(title = "Car Jacob", price = 800.0 , percent = 30.0)

        )


}