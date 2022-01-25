package com.example.firebasevsmvvm.repository

import androidx.lifecycle.MutableLiveData
import com.example.firebasevsmvvm.model.ComputersModel
import com.google.firebase.database.*

class ComputersRepository {

    private val firebaseDatabase: FirebaseDatabase = FirebaseDatabase.getInstance()
    private lateinit var firebaseReference: DatabaseReference

    private var mutableList = MutableLiveData<List<ComputersModel>>()
    private lateinit var comps: List<ComputersModel>
    fun getMutableLiveData(): MutableLiveData<List<ComputersModel>> {

        firebaseReference = firebaseDatabase.getReference("computers")

        firebaseReference.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                comps = ArrayList<ComputersModel>()

                snapshot.children.forEach {
                    val value = it.getValue(ComputersModel::class.java)

                    if (value != null) {
                        (comps as ArrayList<ComputersModel>).add(value)
                    }
                }
                mutableList.value = comps
            }

            override fun onCancelled(error: DatabaseError) {

            }

        })
        return mutableList
    }

}