package com.flyconcept.alphanew.view

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.flyconcept.alphanew.NewsFeedItem
import com.flyconcept.alphanew.NewsFeedRepository
import com.flyconcept.alphanew.R
import com.flyconcept.alphanew.databinding.ViewHolderNewsFeedItemBinding

class NewsFeedRecyclerViewAdapter: RecyclerView.Adapter<RecyclerView.ViewHolder>(){

    private val newsFeedItem = mutableListOf<NewsFeedItem>()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return NewsFeedViewHolder(parent)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        (holder as NewsFeedViewHolder).onBind(newsFeedItem[position])
    }

    override fun getItemCount(): Int {
        return  newsFeedItem.size
    }

    fun setItems(newFeedItems:List<NewsFeedItem>){
        this.newsFeedItem.clear()
        this.newsFeedItem.addAll(newFeedItems)
        notifyDataSetChanged()
    }

    inner class NewsFeedViewHolder(parent: ViewGroup):RecyclerView.ViewHolder(LayoutInflater.from(parent.context).inflate(
        R.layout.view_holder_news_feed_item, parent, false)){
        private val binding = ViewHolderNewsFeedItemBinding.bind(itemView)
        fun onBind(newsFeedItem: NewsFeedItem) {
                binding.titleTextView.text = newsFeedItem.title
                binding.descriptionTextView.text = newsFeedItem.description
        }


    }
}