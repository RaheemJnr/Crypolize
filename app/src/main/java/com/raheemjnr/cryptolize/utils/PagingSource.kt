package com.raheemjnr.cryptolize.utils

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.raheemjnr.cryptolize.data.repository.local.CryptoDatabase
import com.raheemjnr.cryptolize.data.repository.local.entity.CryptoEntity
import retrofit2.HttpException
import java.io.IOException


//from compose cookbook
class PageNumSource(
    private val cryptoDatabase: CryptoDatabase,
    private val query: String
) : PagingSource<Int, CryptoEntity>() {
    //load data
    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, CryptoEntity> {
        return try {
            // Start refresh at page 1 if undefined.
            val page = params.key ?: 1
            //get network data
            val result = cryptoDatabase.CryptoDao().searchCrypto(query)

            if (result.isNotEmpty()) {
                LoadResult.Page(
                    // data to be loaded
                    data = result,
                    //Set this parameter if you can load more up, otherwise don't set it
                    prevKey = if (page == 1) null else page - 1,
                    //Load the key of the next page. If you pass null, it means the end
                    nextKey = page.plus(1)
                )
            } else {
                LoadResult.Page(
                    // data to be loaded
                    data = emptyList(),
                    //Set this parameter if you can load more up, otherwise don't set it
                    prevKey = null,
                    //Load the key of the next page. If you pass null, it means the end
                    nextKey = null
                )
            }
        } catch (e: IOException) {
            // IOException for network failures.
            return LoadResult.Error(e)
        } catch (e: HttpException) {
            // HttpException for any non-2xx HTTP status codes.
            return LoadResult.Error(e)
        }
    }

    override fun getRefreshKey(state: PagingState<Int, CryptoEntity>): Int? {
        // Try to find the page key of the closest page to anchorPosition, from
        // either the prevKey or the nextKey, but you need to handle nullability
        // here:
        //  * prevKey == null -> anchorPage is the first page.
        //  * nextKey == null -> anchorPage is the last page.
        //  * both prevKey and nextKey null -> anchorPage is the initial page, so
        //    just return null.
        return state.anchorPosition?.let { anchorPosition ->
            val anchorPage = state.closestPageToPosition(anchorPosition)
            anchorPage?.prevKey?.plus(1) ?: anchorPage?.nextKey?.minus(1)
        }
    }
}