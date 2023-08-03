package com.example.myapplication

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.core.type.TypeReference

class DictionaryViewModel : ViewModel() {
    private val objectMapper = ObjectMapper()
    private val jsonData: List<WordDefinition> = loadJsonData()

    var searchResult: WordDefinition? = null

    fun searchWord(query: String) {
        viewModelScope.launch {
            withContext(Dispatchers.Default) {
                searchResult = jsonData.find { it.word.equals(query, ignoreCase = true) }
                Log.d("DictionaryViewModel", "Search result: $searchResult") // Add this log statement

            }
        }
    }

    private fun loadJsonData(): List<WordDefinition> {
        val inputStream = javaClass.classLoader?.getResourceAsStream("assets/data.json")
        return if (inputStream != null) {
            Log.d("DictionaryViewModel", "JSON data loaded successfully")
            objectMapper.readValue(
                inputStream,
                object : TypeReference<List<WordDefinition>>() {})
        } else {
            Log.e("DictionaryViewModel", "JSON data not found or failed to load")
            emptyList()
        }
    }
}


