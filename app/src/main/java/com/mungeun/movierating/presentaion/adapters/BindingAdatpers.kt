package com.mungeun.movierating.presentaion.adapters

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions


@BindingAdapter("imageFromUrl")
fun bindingImageFromUrl (view : ImageView, imageUrl : String?){
    if(!imageUrl.isNullOrEmpty()){
        Glide.with(view.context)
            .load(imageUrl)
            .into(view)
    }
}