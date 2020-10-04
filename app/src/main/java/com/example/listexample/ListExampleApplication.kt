package com.example.listexample

import android.app.Application
import com.example.listexample.data.repository.ProductRepository
import com.example.listexample.data.repository.ProductRepositoryImpl
import com.example.listexample.data.service.getHttpClient
import com.example.listexample.presenter.products.ProductsViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.context.startKoin
import org.koin.core.module.Module
import org.koin.dsl.module

@Suppress("unused")
class ListExampleApplication : Application() {

    private val presenterModule: Module = module {
        viewModel {
            ProductsViewModel(
                get()
            )
        }
    }

    private val dataModule: Module = module {
        single { getHttpClient() }
        single<ProductRepository> { ProductRepositoryImpl(get()) }
    }

    override fun onCreate() {
        super.onCreate()

        startKoin { modules(presenterModule, dataModule) }
    }
}
