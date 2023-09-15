package com.example.ui.search

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun SearchContent(
    modifier: Modifier,
    itemList: List<String>,
    onQueryChange: (String) -> Unit,
    onItemSelected: (String) -> Unit,
){
    Column() {
        SearchBar(
            modifier = modifier.fillMaxWidth()
                .padding(horizontal = 10.dp),
            onQueryChange = onQueryChange,
        )
        SearchDropDown(
            modifier = modifier.fillMaxWidth()
                .padding(horizontal = 10.dp),
            itemList = itemList,
            onItemSelected = onItemSelected
        )
    }
}

@Composable
fun SearchDropDown(
    modifier: Modifier,
    itemList: List<String>,
    onItemSelected: (String) -> Unit,
) {
    LazyColumn(modifier.padding(top = 5.dp)) {
        items(itemList) { item ->
            Text(
                text = item,
                modifier = Modifier.clickable { onItemSelected.invoke(item) }
            )
        }
    }
}

@Composable
fun SearchBar(
    modifier: Modifier = Modifier,
    onQueryChange: (String) -> Unit
) {
    var query by remember { mutableStateOf("") }
    BasicTextField(
        value = query,
        onValueChange = {
            query = it
            onQueryChange(it)
        },
        singleLine = true,
        modifier = modifier
            .fillMaxWidth()
            .background(Color.White)
    )
}
@Preview
@Composable
fun PreviewSearchContent(){
    SearchContent(
        modifier = Modifier,
        itemList = listOf(),
        onQueryChange = {},
        onItemSelected = {}

    )
}