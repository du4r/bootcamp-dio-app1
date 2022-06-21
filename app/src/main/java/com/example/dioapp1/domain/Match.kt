package com.example.dioapp1.domain

import com.google.gson.annotations.SerializedName

data class Match (
    @SerializedName("descricao")
    val description: String,
    @SerializedName("local")
    val place: Place,
    @SerializedName("visitante")
    val awayTeam: Team,
    @SerializedName("mandante")
    val homeTeam: Team
    )