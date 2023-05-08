package com.example.udacitystarter.shoeList

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class ShoeDataModel(
    var name: String = "",
    var location: String = "",
    var gender: String = "",
    var size: Double = 0.0,
    var price: Double = 0.00
): Parcelable