package com.example.myapplication

import android.util.Log
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRow
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp


@Composable
fun TabLayout(viewModel: DictionaryViewModel) {
    val selectedTabIndex = remember { mutableStateOf(0) }

    Column(
        modifier = Modifier.fillMaxSize()
    ) {
        TabRow(
            selectedTabIndex = selectedTabIndex.value,
            modifier = Modifier.weight(0.1f) // Allocate some space for the TabRow
        ) {
            Tab(
                selected = selectedTabIndex.value == 0,
                onClick = { selectedTabIndex.value = 0 }
            ) {
                Text("Definition")
            }
            Tab(
                selected = selectedTabIndex.value == 1,
                onClick = { selectedTabIndex.value = 1 }
            ) {
                Text("Synonyms")
            }
            Tab(
                selected = selectedTabIndex.value == 2,
                onClick = { selectedTabIndex.value = 2 }
            ) {
                Text("Antonyms")
            }
        }
        Spacer(modifier = Modifier.padding(top = 100.dp))

        Box(
            modifier = Modifier.weight(0.9f) // Use the rest of the available space
        ) {
            when (selectedTabIndex.value) {
                0 -> {
                    Log.d("TabLayout", "Selected tab: Definition") // Log the selected tab
                    WordDetailsTab(viewModel.searchResult?.definition ?: "")
                }
                1 -> {
                    Log.d("TabLayout", "Selected tab: Synonyms") // Log the selected tab
                    SynonymsTab(viewModel.searchResult?.synonyms ?: emptyList())
                }
                2 -> {
                    Log.d("TabLayout", "Selected tab: Antonyms") // Log the selected tab
                    AntonymsTab(viewModel.searchResult?.antonyms ?: emptyList())
                }
            }

        }
    }
}

@Preview
@Composable
fun TabLayoutPreview() {
    // Create a preview of the TabLayout component
    val fakeViewModel = DictionaryViewModel()
    TabLayout(viewModel = fakeViewModel)
}