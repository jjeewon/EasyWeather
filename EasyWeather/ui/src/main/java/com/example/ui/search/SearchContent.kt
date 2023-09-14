package com.example.ui.search

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material.Text
import androidx.compose.material3.MaterialTheme
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
){
    SearchBar(
        modifier = modifier.fillMaxWidth().padding(horizontal = 10.dp),
        onQueryChange = {

        },
    )
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
            .padding(8.dp)
    )
}
@Preview
@Composable
fun PreviewSearchContent(){
    SearchContent(modifier = Modifier)
}