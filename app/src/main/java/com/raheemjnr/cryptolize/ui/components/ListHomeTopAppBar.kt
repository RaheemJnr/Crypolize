package com.raheemjnr.cryptolize.ui.components

import android.util.Log
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.Person
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import com.raheemjnr.cryptolize.ui.viewModels.CryptoListViewModel

@Composable
fun ListTopAppbar(
    query: String,
    cryptoListViewModel: CryptoListViewModel
) {

    Surface(
        color = MaterialTheme.colors.surface,

        ) {
        ConstraintLayout(
            modifier = Modifier
                .fillMaxWidth(),
        ) {
            val (profileIcon, notificationIcon, moreVertIcon, searchBar) = createRefs()
            //person icon
            Icon(
                imageVector = Icons.Filled.Person,
                contentDescription = "profile icon",
                tint = MaterialTheme.colors.secondary,
                modifier = Modifier
                    .clip(RoundedCornerShape(32.dp))
                    .size(26.dp)
                    .constrainAs(profileIcon) {
                        start.linkTo(parent.start, margin = 8.dp)
                        top.linkTo(parent.top, margin = 8.dp)
                        bottom.linkTo(parent.bottom)
                        end.linkTo(searchBar.start)
                    }
            )
            CryptoListSearch(
                query = query,
                onTextChange = {
                    cryptoListViewModel.onSearchQueryChanged(it)
                },
                onSearchClicked = {
                    cryptoListViewModel.searchCrypto(it)
                    Log.d("Search result", it)
                },
                modifier = Modifier.constrainAs(searchBar) {
                    start.linkTo(profileIcon.end, margin = 4.dp)
                    end.linkTo(notificationIcon.start)
                }
            )
            // moreVert
            Icon(
                imageVector = Icons.Filled.MoreVert,
                contentDescription = "more vert",
                modifier = Modifier
                    .size(26.dp)
                    .constrainAs(moreVertIcon) {
                        end.linkTo(parent.end, margin = 8.dp)
                        top.linkTo(parent.top, margin = 4.dp)
                        bottom.linkTo(parent.bottom, margin = 4.dp)
                    },
                tint = MaterialTheme.colors.secondary
            )
            //notification
            Icon(
                imageVector = Icons.Filled.Notifications,
                contentDescription = "notification",
                tint = MaterialTheme.colors.secondary,
                modifier = Modifier
                    .size(26.dp)
                    .constrainAs(notificationIcon) {
                        end.linkTo(moreVertIcon.start, margin = 8.dp)
                        top.linkTo(parent.top)
                        bottom.linkTo(parent.bottom)
                    }
            )


        }
    }
}


@Preview(showBackground = true)
@Composable
fun ListTopAppbarPrev() {
    // ListTopAppbar()
}