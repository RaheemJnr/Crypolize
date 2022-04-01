package com.example.cryptolize.ui.viewModels

import android.content.Context
import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.cachedIn
import androidx.paging.compose.collectAsLazyPagingItems
import com.example.cryptolize.domain.models.CryptoListModel
import com.example.cryptolize.domain.repository.CryptolizeRepo
import com.example.cryptolize.utils.PageNumSource
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch


class CryptoListViewModel(private val repo: CryptolizeRepo) : ViewModel() {

    private val _isRefreshing = MutableStateFlow(false)

    val isRefreshing: StateFlow<Boolean>
        get() = _isRefreshing.asStateFlow()

    private suspend fun repo(pageNum: Int, pageSize: Int): List<CryptoListModel> {
        return repo.getGitHubDataList(
            pageNum, pageSize
        )
    }

    fun refresh(pageSize: Int = 20) {
        viewModelScope.launch {
            _isRefreshing.emit(true)
            try {
                repo(pageSize, pageSize)
            } catch (e: Exception) {
                Log.d("refresh log", e.localizedMessage!!)
            }
            _isRefreshing.emit(false)

        }
    }


    fun getCryptoList(pageSize: Int = 20) =
        Pager(config = PagingConfig(pageSize = pageSize, initialLoadSize = pageSize)) {
            PageNumSource { pageNum, pageSize ->
                repo(pageNum, pageSize)
            }
        }.flow.cachedIn(viewModelScope)


    /** viewModel Factory
     * it function is to tell the viewModel how to
     * create the repo object injected as a dependency
     * */
    class CryptoListViewModelFactory(private val repo: CryptolizeRepo) :
        ViewModelProvider.Factory {
        @Suppress("UNCHECKED_CAST")
        override fun <T : ViewModel> create(modelClass: Class<T>): T {
            return CryptoListViewModel(repo) as T
        }
    }
}

