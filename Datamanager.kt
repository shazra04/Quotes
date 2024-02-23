package com.example.quoraapplication

import android.content.ContentValues.TAG
import android.content.Context
import android.util.Log
import androidx.compose.runtime.mutableStateOf
import com.example.quoraapplication.models.Quote
import com.google.gson.Gson
import java.io.File
import java.nio.charset.Charset
import kotlin.math.log

object Datamanager {

   var isLoaded = mutableStateOf(false)
   var data = emptyArray<Quote>()
   var currentPage = mutableStateOf(Pages.LISTING)
   var curentQuote : Quote? = null

//   fun main() {
//
//      val jsonFile = File("C://Users//shazr//AndroidStudioProjects//QuoraApplication//app//src//main//assets//data.json")
//      val jsonString = jsonFile.readText()
//      val gson = Gson()
//      data = gson.fromJson(jsonString,Array<Quote>::class.java)
//      isLoaded.value = true
//
//
//
//   }

   fun switchPage(quote: Quote?){
      if(currentPage.value == Pages.LISTING){
         curentQuote = quote
         currentPage.value = Pages.DETAIL
      }else{
         currentPage.value = Pages.LISTING
      }
   }


   fun main(context: Context) {

      val inputStream = context.assets.open("data.json")
      val size:Int = inputStream.available()
      val buffer = ByteArray(size)
      inputStream.read(buffer)
      val json = String(buffer, Charsets.UTF_8)
      val gson = Gson()
      data = gson.fromJson(json,Array<Quote>::class.java)
      isLoaded.value = true



   }
}