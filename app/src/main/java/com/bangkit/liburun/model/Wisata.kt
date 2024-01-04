package com.bangkit.liburun.model

import java.io.Serializable

data class Wisata(
    val id : String,
    val nama : String,
    val foto : String,
    val deskripsi : String
): Serializable