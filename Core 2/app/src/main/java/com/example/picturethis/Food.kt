package com.example.picturethis

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Food(var ID: Int, var name: String, var cuisine: String, var date: String, var rating: Float, val resID:Int): Parcelable
