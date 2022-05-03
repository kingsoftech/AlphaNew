package com.flyconcept.alphanew

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.liveData
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase

class NewsFeedRepository {



    init {


    }
    fun fetchNewsData(liveData:MutableLiveData<List<NewsFeedItem>>){
        val NewFeedItem = NewsFeedItem("Corona  virus", "2019 viral virus breakout")
        val newsFeedTwo = NewsFeedItem("Teju na fine boy", "that's the latest story")
        val database = FirebaseDatabase.getInstance()
        var newsFeedItemList:ArrayList<NewsFeedItem> = ArrayList()
        newsFeedItemList.add(NewFeedItem)
        newsFeedItemList.add(newsFeedTwo)
        val myStore = database.reference.child("NewsFeed")
            .setValue(newsFeedItemList)
        myStore.addOnCompleteListener {
            database.reference.child("NewsFeed").addValueEventListener(object: ValueEventListener{
                override fun onDataChange(snapshot: DataSnapshot) {
                    Log.e("Result interval", snapshot.toString())

                    val newsFeedItemList = snapshot.children.map {
                            dataSnapshot ->
                        dataSnapshot.getValue(NewsFeedItem::class.java)!!
                    }


                    liveData.postValue(newsFeedItemList)
                    Log.e("Result interval1", newsFeedItemList[0].toString())


                }

                override fun onCancelled(error: DatabaseError) {
                    Log.e("error", "error loading data")
                }
            }
            )
        }
    }
}