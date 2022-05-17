package com.armin.user.data

data class UserItem(
    val _id: String,
    val firstName: String,
    val hobbies: List<String>,
    val image: String,
    val lastName: String,
    val nationalCode: String
)