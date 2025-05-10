package com.example.quizapp.data.local.Entity

import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "user_table")
data class UserEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,

    val userName: String = "",
    val occupation: String = "",
    val city: String = "",

    val numberOfQuiz: Int = 0,
    val category: String = "",
    val difficulty: String = "",
    val type: String = "",

    val correctAnswer: Int = 0,
    val scorePercentage: Int = 0
)
