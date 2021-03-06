package com.raheemjnr.cryptolize.ui.viewModels

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


    fun getCryptoList(): Flow<PagingData<CryptoEntity>> {
        return repo.getCryptoList()
    }

//    fun getCryptoList(pageSize: Int = 20) =
//        Pager(config = PagingConfig(pageSize = pageSize, initialLoadSize = pageSize)) {
//            PageNumSource { pageNum, pageSize ->
//                repo(pageNum, pageSize)
//            }
//        }.flow.cachedIn(viewModelScope)

    // swipe to refresh
    fun refresh() {
        viewModelScope.launch {
            _isRefreshing.emit(true)
            getCryptoList()
            _isRefreshing.emit(false)
        }
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

