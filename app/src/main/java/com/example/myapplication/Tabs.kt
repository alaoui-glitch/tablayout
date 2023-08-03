package com.example.myapplication


import android.util.Log
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card

@Composable
fun WordDetailsTab(definition: String) {
    Log.d("WordDetailsTab", "Definition: $definition")

    Card(modifier = Modifier.fillMaxWidth().padding(16.dp)) {
        Text(
            text = definition,
            modifier = Modifier.padding(16.dp)
        )
    }
}


@Composable
fun SynonymsTab(synonyms: List<String>) {
    Log.d("SynonymsTab", "Synonyms: $synonyms")

    LazyColumn {
        items(synonyms) { synonym ->
            Text(text = synonym, modifier = Modifier.padding(16.dp))
        }
    }
}


@Composable
fun AntonymsTab(antonyms: List<String>) {
    Log.d("AntonymsTab", "Antonyms: $antonyms")

    LazyColumn {
        items(antonyms) { antonym ->
            Text(text = antonym, modifier = Modifier.padding(16.dp))
        }
    }
}


