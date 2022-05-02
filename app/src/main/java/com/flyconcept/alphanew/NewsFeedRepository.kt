package com.flyconcept.alphanew

import android.util.Log
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase

class NewsFeedRepository {
    data class NewsFeedItem(
        val title: String = "",
        val description: String = ""
    )

    val NewFeedItem = NewsFeedItem("Corona  virus", "2019 viral virus breakout")
    val database = FirebaseDatabase.getInstance()
    val myStore = database.reference.child("NewsFeed")
        .setValue(NewFeedItem)


    init {
        myStore.addOnCompleteListener {
            Firebase.database.getReference("NewsFeed").addValueEventListener(object: ValueEventListener{
                override fun onDataChange(snapshot: DataSnapshot) {
                    Log.e("Result interval", snapshot.value.toString())

                    val newsFeedItemList = snapshot.children.map {
                        dataSnapshot ->
                            dataSnapshot.getValue(NewsFeedItem::class.java)!!
                    }

                    Log.e("result interval2", newsFeedItemList.toString())
                }

                override fun onCancelled(error: DatabaseError) {
                    Log.e("error", "error loading data")
                }
            }
            )
        }
    }

}