package com.example.cryptolize.ui.viewModels

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.example.cryptolize.domain.models.detailModel.CoinDetail
import com.example.cryptolize.domain.repository.detail.DetailRepo
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class CoinDetailViewModel(private val repo: DetailRepo) : ViewModel() {

    private val _isRefreshing = MutableStateFlow(false)

    val isRefreshing: StateFlow<Boolean>
        get() = _isRefreshing.asStateFlow()

    private suspend fun repo(coinId: String): List<CoinDetail> {
        return repo.getCoinDetails(
            coinId
        )
    }

//    fun refresh(pageSize: Int = 20) {
//        viewModelScope.launch {
//            _isRefreshing.emit(true)
//            try {
//                repo(pageSize, pageSize)
//            } catch (e: Exception) {
//                Log.d("refresh log", e.localizedMessage!!)
//            }
//            _isRefreshing.emit(false)
//
//        }
//    }


    fun getCoinDetail(coinId: String) = viewModelScope.launch {
        try {
            repo(coinId = coinId)
        } catch (e: Exception) {
            Log.d("details error", e.localizedMessage!!)
        }
    }


    /** viewModel Factory
     * it function is to tell the viewModel how to
     * create the repo object injected as a dependency
     * */
    class CoinDetailViewModelFactory(private val repo: DetailRepo) :
        ViewModelProvider.Factory {
        @Suppress("UNCHECKED_CAST")
        override fun <T : ViewModel> create(modelClass: Class<T>): T {
            return CryptoListViewModel(repo) as T
        }
    }
}