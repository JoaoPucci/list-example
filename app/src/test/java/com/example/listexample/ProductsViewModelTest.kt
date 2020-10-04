package com.example.listexample

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.LifecycleRegistry
import androidx.lifecycle.Observer
import com.example.listexample.data.repository.ProductRepository
import com.example.listexample.model.Product
import com.example.listexample.model.ServiceResponse
import com.example.listexample.presenter.products.ProductsViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.test.setMain
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.BDDMockito.*
import org.mockito.Mock
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class ProductsViewModelTest {

    @get:Rule
    var instantExecutorRule = InstantTaskExecutorRule()

    @Mock
    private lateinit var lifecycleOwner: LifecycleOwner

    @Mock
    private lateinit var repository: ProductRepository

    @Mock
    private lateinit var cashObserver: Observer<Product>

    @Mock
    private lateinit var productsObserver: Observer<List<Product>>

    @Mock
    private lateinit var spotlightsObserver: Observer<List<Product>>

    @Mock
    private lateinit var loadingObserver: Observer<Boolean>


    @ExperimentalCoroutinesApi
    @Before
    fun setup() {
        Dispatchers.setMain(Dispatchers.Unconfined)

        val lifecycleRegistry = LifecycleRegistry(lifecycleOwner)
        given(lifecycleOwner.lifecycle).willReturn(lifecycleRegistry)
        lifecycleRegistry.handleLifecycleEvent(Lifecycle.Event.ON_RESUME)
    }

    @Test
    fun `should get products when initializing`() = runBlocking {
        val response = ServiceResponse(
            listOf(),
            listOf(),
            Product()
        )

        given(repository.getAll()).willReturn(response)

        ProductsViewModel(repository).run {
            loading.observe(lifecycleOwner, loadingObserver)
            cash.observe(lifecycleOwner, cashObserver)
            products.observe(lifecycleOwner, productsObserver)
            spotlights.observe(lifecycleOwner, spotlightsObserver)
            getProducts()
        }

        verify(loadingObserver, times(1)).onChanged(false)
        verify(loadingObserver, times(1)).onChanged(true)

        verify(cashObserver, times(1)).onChanged(refEq(response.cash))
        verify(productsObserver, times(1)).onChanged(refEq(response.products))
        verify(spotlightsObserver, times(1)).onChanged(refEq(response.spotlights))
    }
}
