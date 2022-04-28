package com.flyconcept.alphanew

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.flyconcept.alphanew.databinding.ActivityNewsFeedBinding


class NewsFeedActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding: ActivityNewsFeedBinding = DataBindingUtil.setContentView(this, R.layout.activity_news_feed)
        setContentView(R.layout.activity_news_feed)
        binding.textOnScreen = "Hello"
        val viewModel: NewsFeedViewModel = ViewModelProvider(this).get(NewsFeedViewModel::class.java)

        binding.lifecycleOwner = this
        binding.viewModel = viewModel
    }
}