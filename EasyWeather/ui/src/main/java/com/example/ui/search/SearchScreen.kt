package com.example.ui.search

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SearchScreen(){
    Scaffold { paddingValues ->
       SearchContent(
           modifier = Modifier
               .padding(paddingValues)
       )
    }
}

@Preview
@Composable
fun PreviewSearchScreen(){
    SearchScreen()
}