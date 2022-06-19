package com.example.dioapp1.domain

import com.google.gson.annotations.SerializedName

data class Team (
        @SerializedName("nome")
        val name: String,
        @SerializedName("forca")
        val stars: String,
        @SerializedName("Imagem")
        val image: String
        )