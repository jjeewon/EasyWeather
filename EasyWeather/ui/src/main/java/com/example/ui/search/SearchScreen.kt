package com.example.ui.search

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import com.example.presentation.search.viewmodel.SearchViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SearchScreen(
    viewModel: SearchViewModel,
){
    val uiState by viewModel.uiState.collectAsState()

    Scaffold { paddingValues ->
       SearchContent(
           modifier = Modifier
               .padding(paddingValues),
           itemList = uiState.autoCompleteList,
           searchWeatherUiState = uiState.searchWeatherUiState,
           onQueryChange = { viewModel.getLocationByQuery(it) },
           onItemSelected = {
               viewModel.onWeatherItemSelected(it)
            },
       )
    }
}
