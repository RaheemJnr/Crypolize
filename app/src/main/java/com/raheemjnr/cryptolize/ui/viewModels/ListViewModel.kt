package com.raheemjnr.cryptolize.ui.viewModels

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import com.raheemjnr.cryptolize.data.repository.local.entity.CryptoEntity
import com.raheemjnr.cryptolize.domain.repository.list.ListRepo
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch


class CryptoListViewModel(private val repo: ListRepo) : ViewModel() {

    private val _isRefreshing = MutableStateFlow(false)

    val isRefreshing: StateFlow<Boolean>
        get() = _isRefreshing.asStateFlow()

    private fun repo(): Flow<PagingData<CryptoEntity>> {
        return repo.getCryptoList()
    }

    fun refresh() {
        viewModelScope.launch {
            _isRefreshing.emit(true)
            try {
                repo()
            } catch (e: Exception) {
                Log.d("refresh log", e.localizedMessage!!)
            }
            _isRefreshing.emit(false)
        }
    }


    fun getCryptoList(): Flow<PagingData<CryptoEntity>> {
        return repo.getCryptoList()
    }


    /** viewModel Factory
     * it function is to tell the viewModel how to
     * create the repo object injected as a dependency
     * */
    class CryptoListViewModelFactory(private val repo: ListRepo) :
        ViewModelProvider.Factory {
        @Suppress("UNCHECKED_CAST")
        override fun <T : ViewModel> create(modelClass: Class<T>): T {
            return CryptoListViewModel(repo) as T
        }
    }
}

