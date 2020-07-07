package com.example.blooddonationapp.nav_pages

import com.example.blooddonationapp.Adapter.RequestAdapter
import android.content.ContentValues.TAG
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.blooddonationapp.R
import com.example.blooddonationapp.models.Request
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.database.*

class AllRequestPage : Fragment() {

    private lateinit var linearLayoutManager: LinearLayoutManager
    var recyclerView : RecyclerView ?=null
    var adapter  : RequestAdapter?=null
    var user:FirebaseUser?=null
    var requestList:MutableList<Request>?=null
    var databaseRequest:DatabaseReference?=null

    override fun onStart() {
        super.onStart()
        //init things

    }

    private fun getData() {
       // requestList=null
//        var query  = databaseRequest?.child(user?.uid.toString())

        val postListener = object : ValueEventListener {
            override fun onDataChange(dataSnapshot: DataSnapshot) {
//                val list = ArrayList<Request>()
                if(dataSnapshot!!.exists()){
                    for (e in dataSnapshot.children){
//                        val post = e.getValue(Request::class.java)
                        val userName=e.child("userName").getValue().toString()
                        val userAge=e.child("userAge").getValue().toString()
                        val userPhone=e.child("userPhone").getValue().toString()
                        val userLocation=e.child("userLocation").getValue().toString()
                        val hospital=e.child("hospital").getValue().toString()
                        val unitNeeded=e.child("unitNeeded").getValue().toString()
                        val userBloodGrp=e.child("userBloodGrp").getValue().toString()
                        val uid=e.child("uid").getValue().toString()
                        val uEmail=e.child("uEmail").getValue().toString()
                        var item=Request(userName, userAge, userPhone, userLocation, hospital, unitNeeded, userBloodGrp, uid, uEmail)
                        Log.e("s",item.toString())
                        requestList?.add(item!!)
                    }
                    Log.e("f","finish")
                    adapter= RequestAdapter(requestList!!,context!!)
                    Log.e("r",requestList.toString())
                    recyclerView?.adapter=adapter
                }
            }

            override fun onCancelled(databaseError: DatabaseError) {
                // Getting Post failed, log a message
                Log.w(TAG, "loadPost:onCancelled", databaseError.toException())
            }
        }
        databaseRequest?.addValueEventListener(postListener)

    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        val view= inflater.inflate(R.layout.fragment_all_request_page, container, false)
        linearLayoutManager = LinearLayoutManager(context)
        recyclerView=view.findViewById<RecyclerView>(R.id.recyclerView)
        recyclerView?.layoutManager=linearLayoutManager
        recyclerView?.setHasFixedSize(true)

        requestList= mutableListOf()
        databaseRequest=FirebaseDatabase.getInstance().getReference("Request");
        user=FirebaseAuth.getInstance().currentUser
        if(user!=null){
            getData()
        }


        recyclerView?.adapter=adapter
        return view
    }

    companion object {
        fun newInstance(): AllRequestPage = AllRequestPage()
    }
}

