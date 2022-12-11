package com.alphaomardiallo.parisforkids.common.data.local.pagingSource

import android.provider.CalendarContract.Events
import androidx.paging.PagingSource
import androidx.paging.PagingState

class EventsPagingSource(): PagingSource<Int, Events>() {
    // The refresh key is used for the initial load of the next PagingSource, after invalidation
    override fun getRefreshKey(state: PagingState<Int, Events>): Int? {
        return state.anchorPosition?.let { position ->
            val page = state.closestPageToPosition(position)
            page?.prevKey?.minus(1) ?: page?.nextKey?.plus(1)
        }
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Events> {
        TODO("Not yet implemented")
    }
}