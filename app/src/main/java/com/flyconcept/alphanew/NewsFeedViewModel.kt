package com.flyconcept.alphanew

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import kotlinx.coroutines.delay

class NewsFeedViewModel:ViewModel() {
    var repository= NewsFeedRepository()
   private val _newsFeedLiveData = MutableLiveData<List<NewsFeedRepository.NewsFeedItem>>()
    val newsFeedLiveData:LiveData<List<NewsFeedRepository.NewsFeedItem>> = _newsFeedLiveData
    fun fetchNewsFeed(){
        repository.fetchNewsData(_newsFeedLiveData)
    }
}