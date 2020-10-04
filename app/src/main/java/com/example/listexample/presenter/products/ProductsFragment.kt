package com.example.listexample.presenter.products

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.RecyclerView
import com.example.listexample.R
import com.example.listexample.databinding.FragmentProductsBinding
import com.example.listexample.presenter.adapter.ProductAdapter
import com.example.listexample.presenter.adapter.SpotlightAdapter
import org.koin.androidx.viewmodel.ext.android.viewModel

class ProductsFragment : Fragment() {

    private val viewModel: ProductsViewModel by viewModel()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding: FragmentProductsBinding =
            DataBindingUtil.inflate(inflater, R.layout.fragment_products, container, false)

        binding.lifecycleOwner = viewLifecycleOwner
        binding.viewModel = viewModel

        observeSpotlights(binding.vSpotlights.rvSpotlights)
        observeProducts(binding.vProducts.rvProducts)

        viewModel.getProducts()

        return binding.root
    }

    private fun observeSpotlights(rvSpotlights: RecyclerView) {
        viewModel.spotlights.observe(viewLifecycleOwner, Observer {
            rvSpotlights.adapter = SpotlightAdapter(it)
        })
    }

    private fun observeProducts(rvProducts: RecyclerView) {
        viewModel.products.observe(viewLifecycleOwner, Observer {
            rvProducts.adapter = ProductAdapter(it)
        })
    }
}
