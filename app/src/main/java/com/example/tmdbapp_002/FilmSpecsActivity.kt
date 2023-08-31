package com.example.tmdbapp_002

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import com.bumptech.glide.Glide
import com.example.tmdbapp_002.databinding.ActivityFilmSpecsBinding
import com.google.android.material.bottomnavigation.BottomNavigationView

class FilmSpecsActivity : AppCompatActivity() {
    private lateinit var binding: ActivityFilmSpecsBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFilmSpecsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.bottomnav.setOnNavigationItemSelectedListener { item ->
            when(item.itemId) {
                R.id.page_1 -> {
                    // Respond to navigation item 1 click
                    val intent1 = Intent(this@FilmSpecsActivity, MainActivity::class.java)
                    startActivity(intent1)
                    finish()
                    true
                }
                R.id.page_2 -> {
                    // Respond to navigation item 2 click
                    true
                }
                else -> false
            }
        }

        var actionBar = getSupportActionBar()

        if (actionBar != null) {
            actionBar.setHomeAsUpIndicator(R.drawable.back_icon_button)

            actionBar.setDisplayHomeAsUpEnabled(true);
        }

        val bundle = intent.extras

        Glide.with(binding.imageViewFilmSpecs.context)
            .load("https://image.tmdb.org/t/p/w500/${bundle?.getString("path")}")
            .placeholder(R.drawable.ic_launcher_background) // Yükleme sırasında gösterilecek varsayılan görsel
            .error(R.drawable.ic_launcher_background) // Hata durumunda gösterilecek varsayılan görsel
            .into(binding.imageViewFilmSpecs) // ImageView'e yüklemeyi gerçekleştir

        if (bundle != null) {
            binding.textViewName.text = bundle.getString("filmName")
            binding.textViewDate.text = bundle.getString("filmDate")
            binding.textViewLanguage.text = bundle.getString("filmLanguage")
            binding.textViewScore.text = bundle.getString("filmScore")
            binding.textViewOverview.text = bundle.getString("filmAbout")
        }
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        startActivity(Intent(this@FilmSpecsActivity, MainActivity::class.java))
        finish()
        return super.onOptionsItemSelected(item)
    }
}