package com.example.ui.search

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.presentation.search.model.LocationPresentationModel

@Composable
fun SearchContent(
    modifier: Modifier,
    itemList: List<LocationPresentationModel>,
    onQueryChange: (String) -> Unit,
    onItemSelected: (LocationPresentationModel) -> Unit,
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
    itemList: List<LocationPresentationModel>,
    onItemSelected: (LocationPresentationModel) -> Unit,
) {
    LazyColumn(modifier.padding(top = 5.dp)) {
        items(itemList) { item ->
            Text(
                text = item.location,
                modifier = Modifier.clickable { onItemSelected.invoke(item) }
            )
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SearchBar(
    modifier: Modifier = Modifier,
    onQueryChange: (String) -> Unit
) {
    var query by remember { mutableStateOf("") }
    val interactionSource = remember { MutableInteractionSource() }
    BasicTextField(
        value = query,
        onValueChange = {
            query = it
            onQueryChange(it)
        },
        singleLine = true,
        modifier = modifier
            .fillMaxWidth()
            .background(Color.White),
        decorationBox = {
            TextFieldDefaults.TextFieldDecorationBox(
                value = query,
                innerTextField = it,
                visualTransformation = VisualTransformation.None,
                trailingIcon = {
                    Icon(
                        imageVector = Icons.Default.Search,
                        contentDescription = "search icon"
                    )
                },
                contentPadding = TextFieldDefaults.textFieldWithoutLabelPadding(
                    start = 0.dp,
                ),
                colors = TextFieldDefaults.textFieldColors(
                    containerColor = Color.White,
                    unfocusedIndicatorColor = Color.DarkGray,
                    focusedIndicatorColor = Color.LightGray
                ),
                enabled = true,
                interactionSource = interactionSource,
                singleLine = false,
            )
        }

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