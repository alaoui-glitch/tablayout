package com.example.myapplication


data class WordDefinition(
    val word: String = "",
    val definition: String = "",
    val synonyms: List<String> = emptyList(),
    val antonyms: List<String> = emptyList()
)




