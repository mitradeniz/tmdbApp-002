package com.example.tmdbapp_002

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.tmdbapp_002.databinding.ActivityMainBinding
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private var resultsItem = arrayListOf<ResultsItem>()
    private var myAdapter = MyAdapter(resultsItem) { tem ->

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.recyclerView.adapter = myAdapter
        binding.recyclerView.layoutManager =
            LinearLayoutManager(this@MainActivity, LinearLayoutManager.VERTICAL, false)
        var page = 1
        binding.buttonNuxt.setOnClickListener {
            page++
            binding.textViewPageNumber.text = "Page: ${page.toString()}"

            lifecycleScope.launch {

                try {
                    val authKey = "Bearer eyJhbGciOiJIUzI1NiJ9.eyJhdWQiOiJhZDk0OGM5ZTg1Y2M1ODkzNzFjZGU4Yjk0MTRjMTI3YyIsInN1YiI6IjY0NTY4NmNkZmUwNzdhMDE1Njc1M2Y4OSIsInNjb3BlcyI6WyJhcGlfcmVhZCJdLCJ2ZXJzaW9uIjoxfQ.TTfWaDJyMJ3lFy4y3L0l0X1BozaAiwsOnpCDi9lQwk8"

                    val apiInterface = retrofit.create(ApiInterface::class.java)

                    val response = apiInterface.getPosts(authKey, page)
                    val total_pages = response.total_pages
                    val total_results = response.total_results
                    val page = response.page



                    var resultsItem = response.results
                    myAdapter.newList(resultsItem as ArrayList<ResultsItem>)
                    for (i in resultsItem) {
                        Log.e("Film", i.toString())
                    }

                } catch (e: Exception) {
                    // Hata durumunda işlemler
                }
            }
        }

        binding.buttonBack.setOnClickListener {
            if (page > 1) {

                page--
                binding.textViewPageNumber.text = "Page: ${page.toString()}"
            }
            lifecycleScope.launch {

                try {
                    val authKey = "Bearer eyJhbGciOiJIUzI1NiJ9.eyJhdWQiOiJhZDk0OGM5ZTg1Y2M1ODkzNzFjZGU4Yjk0MTRjMTI3YyIsInN1YiI6IjY0NTY4NmNkZmUwNzdhMDE1Njc1M2Y4OSIsInNjb3BlcyI6WyJhcGlfcmVhZCJdLCJ2ZXJzaW9uIjoxfQ.TTfWaDJyMJ3lFy4y3L0l0X1BozaAiwsOnpCDi9lQwk8"

                    val apiInterface = retrofit.create(ApiInterface::class.java)

                    val response = apiInterface.getPosts(authKey, page)
                    val total_pages = response.total_pages
                    val total_results = response.total_results
                    val page = response.page



                    var resultsItem = response.results
                    myAdapter.newList(resultsItem as ArrayList<ResultsItem>)
                    for (i in resultsItem) {
                        Log.e("Film", i.toString())
                    }

                } catch (e: Exception) {
                    // Hata durumunda işlemler
                }
            }
        }

        lifecycleScope.launch {

            try {
                val authKey = "Bearer eyJhbGciOiJIUzI1NiJ9.eyJhdWQiOiJhZDk0OGM5ZTg1Y2M1ODkzNzFjZGU4Yjk0MTRjMTI3YyIsInN1YiI6IjY0NTY4NmNkZmUwNzdhMDE1Njc1M2Y4OSIsInNjb3BlcyI6WyJhcGlfcmVhZCJdLCJ2ZXJzaW9uIjoxfQ.TTfWaDJyMJ3lFy4y3L0l0X1BozaAiwsOnpCDi9lQwk8"

                val apiInterface = retrofit.create(ApiInterface::class.java)

                val response = apiInterface.getPosts(authKey, page)
                val total_pages = response.total_pages
                val total_results = response.total_results
                val page = response.page



                var resultsItem = response.results
                myAdapter.newList(resultsItem as ArrayList<ResultsItem>)
                for (i in resultsItem) {
                    Log.e("Film", i.toString())
                }

            } catch (e: Exception) {
                // Hata durumunda işlemler
            }
        }

    }
}