package com.example.quoraapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Text

import androidx.compose.runtime.Composable
import com.example.quoraapplication.Screen.CreateQuoteList
import com.example.quoraapplication.Screen.QuoteDetail

import com.example.quoraapplication.models.Quote

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Datamanager.main(this)
        setContent {
            quoteListShow(Datamanager.data){

            }
        }
    }
}

@Composable
fun quoteListShow(data: Array<Quote>,OnClick: (quote1:Quote)->Unit){
    if (Datamanager.isLoaded.value){
        if(Datamanager.currentPage.value == Pages.LISTING){
            LazyColumn{
                items(data){
                        item -> CreateQuoteList(item){
                            Datamanager.switchPage(it)
                }
                }
            }
        }else{
            Datamanager.curentQuote?.let { QuoteDetail(it) }

        }

    }else{
        Text("Loading")
    }

}

enum class Pages{
    LISTING,
    DETAIL
}
