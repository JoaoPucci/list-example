package com.example.listexample.presenter.binding

import android.view.View
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.squareup.picasso.Picasso

@BindingAdapter("imageUrl")
fun setImageUrl(imageView: ImageView, url: String?) {
    url?.let {
        if (it.isNotBlank()) Picasso.get().load(it).into(imageView)
    }
}

@BindingAdapter("isVisible")
fun setIsVisible(view: View, isVisible: Boolean) {
    view.visibility  = if(isVisible) View.VISIBLE else View.INVISIBLE
}
