package com.example.cryptolize.ui.viewModels

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.example.cryptolize.domain.models.detailModel.CoinDetail
import com.example.cryptolize.domain.repository.detail.DetailRepo
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch

class CoinDetailViewModel(private val repo: DetailRepo) : ViewModel() {



    private val _getCoin = MutableSharedFlow<List<CoinDetail>>()
    val getCoin: SharedFlow<List<CoinDetail>>
        get() = _getCoin

    private suspend fun repo(coinId: String): List<CoinDetail> {
        return repo.getCoinDetails(
            coinId
        )
    }




    fun getCoinDetail(coinId: String) = viewModelScope.launch {
        try {
            val result = repo(coinId = coinId)
            _getCoin.emit(result)
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
            return CoinDetailViewModel(repo) as T
        }
    }
}