package com.example.ui.search

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SearchScreen(
    itemList: List<String>,
    onQueryChanged: (String) -> Unit,
    onItemSelected: (String) -> Unit,
){
    Scaffold { paddingValues ->
       SearchContent(
           modifier = Modifier
               .padding(paddingValues),
           itemList = itemList,
           onQueryChange = onQueryChanged,
           onItemSelected = onItemSelected,
       )
    }
}
