package com.example.tmdbapp_002

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bumptech.glide.Glide
import com.example.tmdbapp_002.databinding.ActivityFilmSpecsBinding

class FilmSpecsActivity : AppCompatActivity() {
    private lateinit var binding: ActivityFilmSpecsBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFilmSpecsBinding.inflate(layoutInflater)
        setContentView(binding.root)

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
}