package com.example.myapplication

import android.util.Log
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp



@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SearchBar(
    value: String,
    onValueChange: (String) -> Unit,
    onSearchClick: () -> Unit
) {
    TextField(
        value = value,
        onValueChange = { newValue ->
            onValueChange(newValue)
        },
        placeholder = { Text("Search...") },
        modifier = Modifier.fillMaxWidth(),
        trailingIcon = {
            Button(
                onClick = {
                    Log.d("SearchBar", "Search button clicked") // Add this log message

                    onSearchClick() // Call the onSearchClick lambda
                },
                modifier = Modifier.padding(8.dp) // Add some padding to the button
            ) {
                Text("Search")
            }
        }
    )
}





@Preview
@Composable
fun SearchBarPreview() {
    SearchBar(value = "", onValueChange = {}, onSearchClick = {})
}
