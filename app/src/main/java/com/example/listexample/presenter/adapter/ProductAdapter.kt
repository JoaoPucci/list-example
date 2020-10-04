package com.example.listexample.presenter.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.listexample.R
import com.example.listexample.databinding.ItemSpotlightBinding
import com.example.listexample.model.Product

class ProductAdapter(private val spotlights: List<Product> = arrayListOf()) :
    RecyclerView.Adapter<ProductAdapter.SpotlightViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SpotlightViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding: ItemSpotlightBinding =
            DataBindingUtil.inflate(inflater, R.layout.item_spotlight, parent, false)

        return SpotlightViewHolder(binding)
    }

    override fun getItemCount() = spotlights.count()

    override fun onBindViewHolder(holder: SpotlightViewHolder, position: Int) {
        holder.bind(spotlights[position])
    }

    inner class SpotlightViewHolder(private val binding: ItemSpotlightBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(product: Product) {
            binding.product = product
        }
    }
}
