package com.raheemjnr.cryptolize.ui.viewModels

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.raheemjnr.cryptolize.domain.models.detailModel.CoinDetail
import com.raheemjnr.cryptolize.domain.repository.detail.DetailRepo
import com.raheemjnr.cryptolize.utils.UIDataState
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.launch

class CoinDetailViewModel(private val repo: DetailRepo) : ViewModel() {


    private val _getCoinWithReloadData = MutableSharedFlow<UIDataState<CoinDetail>>()
    val getCoinWithReloadData: SharedFlow<UIDataState<CoinDetail>>
        get() = _getCoinWithReloadData

    private val _getCoin = MutableSharedFlow<CoinDetail>()
    val getCoin: SharedFlow<CoinDetail>
        get() = _getCoin

    private suspend fun repo(coinId: String): CoinDetail? {
        return repo.getCoinDetails(
            coinId
        )
    }

    fun getCoinDetail(coinId: String) = viewModelScope.launch {
        try {
            _getCoinWithReloadData.emit(UIDataState.loading())
            val result = repo(coinId = coinId)
            if (result != null) {
                _getCoinWithReloadData.emit(UIDataState.success(result))
                _getCoin.emit(result)
            }
        } catch (e: Exception) {
            _getCoinWithReloadData.emit(UIDataState.failed(e.localizedMessage!!))
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