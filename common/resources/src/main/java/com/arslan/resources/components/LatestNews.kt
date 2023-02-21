package com.arslan.resources.components

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.arslan.resources.R

@SuppressLint("ComposableNaming")
@Composable
fun LatestNews(seeAll: ()-> Unit) {
    Column {
        RowHeader(title = "Latest", seeAll)
        Box {
            TabLayout(
                listOf(stringResource(id = R.string.all), "Sports", "Politics", "Business", "Health", "Travel")
            ) {
                LazyColumn() {
                    repeat(10) {
                        item {
                            News()
                        }
                    }
                }


                Text(text = it)
            }
        }
    }

}

@SuppressLint("ComposableNaming")
@Preview
@Composable
fun previewLatestNews() {
    LatestNews(){}
}