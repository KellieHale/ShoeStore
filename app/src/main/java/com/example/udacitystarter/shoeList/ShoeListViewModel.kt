package com.example.udacitystarter.shoeList

import androidx.databinding.Bindable
import androidx.lifecycle.ViewModel

class ShoeListViewModel : ViewModel() {

    @get:Bindable
    var name = ""

    @get:Bindable
    var location = ""

    @get:Bindable
    var gender = ""

    @get:Bindable
    var price = ""

    @get:Bindable
    var size = ""

    val shoeList = ArrayList<ShoeDataModel>()

    init {
        shoeList.add(
            ShoeDataModel(
                "Air Jordan 1 Mid SE", "Nike", "Male", 10.0, 135.00
            )
        )
        shoeList.add(
            ShoeDataModel(
            "ULTRABOOST 22 RUNNING SHOES", "Adidas", "Gender Neutral", 9.5, 95.00
            )
        )
        shoeList.add(
            ShoeDataModel(
                "GEL-KAYANO 29 LITE-SHOW","ASICS", "Women", 8.0, 170.00
            )
        )
        shoeList.add(
            ShoeDataModel(
                "Chuck Taylor All Star Lift Platform Canvas","Converse", "Gender Neutral", 7.5, 75.00
            )
        )
    }

    fun hasShoe(): Boolean {
        return name.isNotEmpty() && size.isNotEmpty() && price.isNotEmpty() && gender.isNotEmpty() && location.isNotEmpty()
    }

    fun clearShoe() {
        name = ""
        size = ""
        price = ""
        gender = ""
        location = ""
    }

    fun getCurrentShoe(): ShoeDataModel {
        return ShoeDataModel(
            name, location, gender, size.toDouble(), price.toDouble()
        )
    }
}