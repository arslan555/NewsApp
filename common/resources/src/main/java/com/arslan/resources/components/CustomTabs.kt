package com.arslan.resources.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.ScrollableTabRow
import androidx.compose.material.Tab
import androidx.compose.material.TabRowDefaults.tabIndicatorOffset
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.arslan.resources.theme.black
import com.arslan.resources.theme.blue
import com.arslan.resources.theme.purpleLight


@Composable
fun TabLayout(
    tabItems: List<String>, content: @Composable (String) -> Unit
) {
    var tabIndex by remember { mutableStateOf(0) }
    var selectedItem by remember { mutableStateOf(tabItems[0]) }
    Column {
        ScrollableTabRow(
            selectedTabIndex = tabIndex,
            edgePadding = 0.dp,
            backgroundColor = MaterialTheme.colors.background,
            contentColor = blue,
            indicator = { tabPositions ->
                Box(
                    modifier = Modifier
                        .tabIndicatorOffset(tabPositions[tabIndex])
                        .height(4.dp)
                        .padding(horizontal = 0.dp)
                        .background(color = blue, shape = RoundedCornerShape(8.dp))
                )
            },
            divider = {},
        ) {
            tabItems.forEachIndexed { index, item ->
                Tab(selected = tabIndex == index,
                    onClick = {
                        tabIndex = index
                        selectedItem = item
                    },
                    selectedContentColor = black,
                    unselectedContentColor = purpleLight,
                    text = {
                        Text(text = item, style = MaterialTheme.typography.body1.copy(fontSize = 16.sp, letterSpacing = 0.12.sp, lineHeight = 24.sp))
                    })
            }
        }
        content(selectedItem)
    }
}
@Preview
@Composable
fun PreviewTabLayout() {
    TabLayout(
        listOf("All", "Sports","Politics", "Business","Health", "Travel")
    ) {
        Text(text = it)
    }
}


