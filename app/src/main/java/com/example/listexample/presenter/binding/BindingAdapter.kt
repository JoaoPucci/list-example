package com.example.listexample.presenter.binding

import android.view.View
import android.widget.ImageView
import androidx.core.content.ContextCompat
import androidx.databinding.BindingAdapter
import com.example.listexample.R
import com.squareup.picasso.Picasso

@BindingAdapter("imageUrl")
fun setImageUrl(imageView: ImageView, url: String?) {
    url?.let {
        if (it.isNotBlank()) loadImage(it, imageView)
    }
}

private fun loadImage(url: String, imageView: ImageView) {
    with(Picasso.get().load(url)) {
        ContextCompat.getDrawable(imageView.context, R.drawable.placeholder_item_product)
            ?.let {
                error(it)
            }
        into(imageView)
    }
}

@BindingAdapter("isVisible")
fun setIsVisible(view: View, isVisible: Boolean) {
    view.visibility = if (isVisible) View.VISIBLE else View.INVISIBLE
}
