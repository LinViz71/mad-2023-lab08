package com.example.lab8.data.db

import android.graphics.Bitmap
import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.lab8.domain.entity.Card
import java.util.UUID

@Entity
data class CardTable(
    @PrimaryKey val id: String = UUID.randomUUID().toString(),
    val question: String,
    val example: String,
    val answer: String,
    val translation: String,
    val image: Bitmap? = null,
)

fun Card.toDb(): CardTable =
    CardTable(id, question, example, answer, translation, image)