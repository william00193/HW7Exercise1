package com.example.hw7exercise1

import java.util.*



data class Crime(
    val id: UUID,
    val title: String,
    val date: Date,
    val isSolved: Boolean
)