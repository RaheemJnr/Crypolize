package com.example.cryptolize.ui.viewModels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.cachedIn
import com.example.cryptolize.domain.repository.CryptolizeRepo
import com.example.cryptolize.utils.PageNumSource


class CryptoListViewModel(private val repo: CryptolizeRepo) : ViewModel() {

    //
    fun getCryptoList(pageSize: Int = 20) =
        Pager(config = PagingConfig(pageSize = pageSize, initialLoadSize = pageSize)) {
            PageNumSource { pageNum, pageSize ->
                repo.getGitHubDataList(
                    pageNum, pageSize
                )
            }
        }.flow.cachedIn(viewModelScope)


    /** viewModel Factory
     * it function is to tell the viewModel how to
     * create the repo object injected as a dependency
     * */
    class CryptoListViewModelFactory(private val repo: CryptolizeRepo) : ViewModelProvider.Factory {
        @Suppress("UNCHECKED_CAST")
        override fun <T : ViewModel?> create(modelClass: Class<T>): T {
            return CryptoListViewModel(repo) as T
        }
    }
}

