package com.mungeun.movierating.presentaion.home

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.mungeun.movierating.databinding.ItemFeaturedMovieBinding
import com.mungeun.movierating.databinding.ItemMovieBinding
import com.mungeun.movierating.domain.model.Movie
import com.mungeun.movierating.domain.model.Review

class HomeAdapter : ListAdapter<Any,RecyclerView.ViewHolder>(HomeCallback()){



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return when(viewType){
            ITEM_REVIEW ->{
                 ReviewItemViewHolder(ItemFeaturedMovieBinding.inflate(LayoutInflater.from(parent.context),parent,false))
            }
            ITEM_MOVIE -> {
                 MovieItemViewHolder(ItemMovieBinding.inflate(LayoutInflater.from(parent.context),parent,false))
            }
            else -> throw IllegalStateException("Unknow viewType")
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val item = getItem(position)
        if(holder is MovieItemViewHolder) {
            holder.bind(item as Movie)
        }
        if(holder is ReviewItemViewHolder) {
            holder.bind(item as Review)
        }

    }

    override fun getItemViewType(position: Int): Int {
        val item = getItem(position)
        return when(item){
            is Movie -> ITEM_MOVIE
            is Review -> ITEM_REVIEW
                else -> throw IllegalStateException("Unknow type")
        }
    }




    inner class ReviewItemViewHolder(private val reviewBinding : ItemFeaturedMovieBinding) : RecyclerView.ViewHolder(reviewBinding.root){
        fun bind(item : Review){
            reviewBinding.review = item
        }
    }

    inner class MovieItemViewHolder(private val movieBinding : ItemMovieBinding) : RecyclerView.ViewHolder(movieBinding.root){
        fun bind(item : Movie){
            movieBinding.movie = item
        }
    }

    companion object{
        const val ITEM_REVIEW = 1
        const val ITEM_MOVIE = 2
    }




}









private class HomeCallback() : DiffUtil.ItemCallback<Any>(){
    override fun areContentsTheSame(oldItem: Any, newItem: Any): Boolean {
        return oldItem == newItem
    }

    override fun areItemsTheSame(oldItem: Any, newItem: Any): Boolean {
        return oldItem == newItem
    }

}