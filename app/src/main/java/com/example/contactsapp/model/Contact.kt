package com.example.contactsapp.model

import androidx.annotation.DrawableRes


data class Contact(
    val name: String,
    @DrawableRes val image:Int,
    val number : String

){

}
