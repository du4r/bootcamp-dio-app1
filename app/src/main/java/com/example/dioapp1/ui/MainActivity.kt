package com.example.dioapp1.ui

import android.hardware.usb.UsbEndpoint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.dioapp1.R
import com.example.dioapp1.data.MatchesApi
import com.example.dioapp1.data.NetworkUtils
import com.example.dioapp1.databinding.ActivityDetailBinding
import com.example.dioapp1.databinding.ActivityMainBinding
import com.example.dioapp1.domain.Match
import com.google.android.material.snackbar.Snackbar
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity() {

    private lateinit var binding:ActivityMainBinding
    private lateinit var endpoint: MatchesApi
    private lateinit var callback: Call<List<Match>>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupHttpClient()
        setupMatchesList()
        setupMatchesRefresh()
        setupFloatingActionButton()
    }

    private fun setupHttpClient(){

        val retrofitClient = NetworkUtils
            .getRetrofitInstance("https://du4r.github.io/mockings/")
             endpoint = retrofitClient.create(MatchesApi::class.java)
             callback = endpoint.getMatches()
    }

    private fun setupMatchesList() {
        callback.enqueue(object : Callback<List<Match>>{

           override fun onResponse(call: Call<List<Match>>, response: Response<List<Match>>) {
                if(response.isSuccessful){
                   var matches:  List<Match>? = response.body()
                }else{
                    showMessageError()
                }
            }

           override  fun onFailure(call: Call<List<Match>>, t: Throwable) {
                    showMessageError()
             }

            }
        )
    }


    private fun setupFloatingActionButton() {
        TODO("Not yet implemented")
    }

    private fun setupMatchesRefresh() {
        TODO("Not yet implemented")
    }

    private fun showMessageError() {
        TODO("Not yet implemented")
        Snackbar.make(binding.fabSimulate, R.string.error_api, Snackbar.LENGTH_LONG).show()
    }



}