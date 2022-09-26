package com.arslan.resources.components

import android.annotation.SuppressLint
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.Dimension
import com.arslan.resources.R
import com.arslan.resources.theme.purple
import com.arslan.resources.theme.purpleLight

@SuppressLint("ComposableNaming")
@Composable
fun SearchBar() {
    ConstraintLayout(
        modifier = Modifier
            .fillMaxWidth()
            .height(48.dp)
            .background(MaterialTheme.colors.background)
            .border(BorderStroke(3.dp, purple), RoundedCornerShape(15.dp))
    ) {
        val (searchIcon, inputText, filterIcon) = createRefs()
        Image(
            painter = painterResource(id = R.drawable.ic_search),
            contentDescription = null,
            modifier = Modifier.constrainAs(searchIcon) {
                start.linkTo(parent.start, margin = 10.dp)
                top.linkTo(parent.top, margin = 10.dp)
                bottom.linkTo(parent.bottom, margin = 10.dp)
            }
        )

        Text(text = "Search",
            style = MaterialTheme.typography.body1.copy(color = purpleLight),
            modifier = Modifier
                .background(MaterialTheme.colors.background)
                .constrainAs(inputText) {
                    start.linkTo(searchIcon.end, margin = 12.dp)
                    end.linkTo(filterIcon.start, margin = 12.dp)
                    top.linkTo(parent.top)
                    bottom.linkTo(parent.bottom)
                    width = Dimension.fillToConstraints
                })
        Image(
            painter = painterResource(id = R.drawable.ic_filter),
            contentDescription = null,
            modifier = Modifier.constrainAs(filterIcon) {
                end.linkTo(parent.end, margin = 10.dp)
                top.linkTo(parent.top, margin = 10.dp)
                bottom.linkTo(parent.bottom, margin = 10.dp)
            }
        )
    }
}

@SuppressLint("ComposableNaming")
@Preview
@Composable
fun PreviewSearchBar() {
    SearchBar()
}