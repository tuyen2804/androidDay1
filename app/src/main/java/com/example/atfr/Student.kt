package com.example.atfr

import java.io.Serializable

data class Student(
    val id: String,
    val name: String,
    val age: Int
) : Serializable
