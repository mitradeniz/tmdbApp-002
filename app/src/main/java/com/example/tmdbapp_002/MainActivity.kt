package com.example.tmdbapp_002

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.tmdbapp_002.databinding.ActivityMainBinding
import com.google.android.material.bottomnavigation.BottomNavigationView
import kotlinx.coroutines.launch



class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private var resultsItem = arrayListOf<ResultsItem>()
    private var myAdapter = MyAdapter(resultsItem) { tem ->

        val bundle = Bundle()

        val intent = Intent(this@MainActivity, FilmSpecsActivity::class.java)

        bundle.putString("filmName", tem.title.toString())
        bundle.putString("filmDate", tem.release_date.toString())
        bundle.putString("filmScore", tem.vote_average.toString())
        bundle.putString("filmLanguage", tem.original_language.toString())
        bundle.putString("filmAbout", tem.overview.toString())
        bundle.putString("path", tem.poster_path.toString())


        intent.putExtras(bundle)

        startActivity(intent)


    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.bottomnav.setOnNavigationItemSelectedListener { item ->
            when(item.itemId) {
                R.id.page_1 -> {
                    // Respond to navigation item 1 click
//                    val intent1 = Intent(this@MainActivity, MainActivity::class.java)
//                    startActivity(intent1)
                    true
                }
                R.id.page_2 -> {
                    // Respond to navigation item 2 click
                    true
                }
                else -> false
            }
        }


        binding.recyclerView.adapter = myAdapter
        binding.recyclerView.layoutManager =
            LinearLayoutManager(this@MainActivity, LinearLayoutManager.HORIZONTAL, false)
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