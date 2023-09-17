package com.example.ui.search

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.animateIntAsState
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.slideInHorizontally
import androidx.compose.animation.slideOutHorizontally
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
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
import androidx.compose.ui.Alignment
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
    var isSpreadOut by remember { mutableStateOf(true) }
    Column() {
        SearchBar(
            modifier = modifier
                .fillMaxWidth()
                .padding(horizontal = 10.dp),
            isSpreadOut = isSpreadOut,
            searchIconClicked = { isSpreadOut = !isSpreadOut },
            onQueryChange = onQueryChange,
        )
        SearchDropDown(
            isVisible = isSpreadOut,
            modifier = modifier
                .fillMaxWidth()
                .padding(horizontal = 10.dp),
            itemList = itemList,
            onItemSelected = onItemSelected
        )
    }
}

@Composable
fun SearchDropDown(
    isVisible: Boolean,
    modifier: Modifier,
    itemList: List<LocationPresentationModel>,
    onItemSelected: (LocationPresentationModel) -> Unit,
) {
    AnimatedVisibility(
        modifier = modifier
            .fillMaxWidth()
            .background(Color.White),
        visible = isVisible,
        enter = fadeIn(),
        exit = fadeOut(),
    ) {
        LazyColumn(modifier.padding(5.dp)) {
            items(itemList) { item ->
                Text(
                    text = item.location,
                    modifier = Modifier.clickable { onItemSelected.invoke(item) }
                )
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SearchBar(
    isSpreadOut: Boolean,
    modifier: Modifier = Modifier,
    searchIconClicked: () -> Unit,
    onQueryChange: (String) -> Unit
) {
    val animationOffset by animateIntAsState(
        if (isSpreadOut) 0 else (-200), // Adjust the offset as needed
        tween(durationMillis = 500)
    )
    var query by remember { mutableStateOf("") }
    val interactionSource = remember { MutableInteractionSource() }
    Box() {
        AnimatedVisibility(
            modifier = modifier
                .fillMaxWidth()
                .background(Color.White),
            visible = isSpreadOut,
            enter = slideInHorizontally(
                initialOffsetX = { it }, // Slide in from right to left
                animationSpec = tween(durationMillis = 500)
            ),
            exit = fadeOut() + slideOutHorizontally(
                targetOffsetX = { -animationOffset }, // Slide out from left to right
                animationSpec = tween(durationMillis = 500)
            ),
        ) {
            BasicTextField(
                value = query,
                onValueChange = {
                    query = it
                    onQueryChange(it)
                },
                singleLine = true,
                decorationBox = {
                    TextFieldDefaults.TextFieldDecorationBox(
                        value = query,
                        innerTextField = it,
                        visualTransformation = VisualTransformation.None,
                        colors = TextFieldDefaults.textFieldColors(
                            containerColor = Color.White,
                            unfocusedIndicatorColor = Color.DarkGray,
                            focusedIndicatorColor = Color.LightGray
                        ),
                        placeholder = {
                                      Text(
                                          text = "Search location",
                                          color = Color.DarkGray
                                      )
                        },
                        enabled = true,
                        interactionSource = interactionSource,
                        singleLine = false,
                    )
                }
            )
        }
        Row() {
            Spacer(modifier = modifier.weight(0.8f))
            Icon(
                modifier = modifier
                    .weight(0.2f)
                    .padding(top = 15.dp, start = 10.dp)
                    .clickable {
                        searchIconClicked.invoke()
                    },
                imageVector = Icons.Default.Search,
                contentDescription = "search icon"
            )
        }


    }
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