package com.example.tmdbapp_002

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.tmdbapp_002.databinding.FilmItemsBinding


class MyAdapter(val results: ArrayList<ResultsItem>, val callback: (ResultsItem) -> Unit) :
    RecyclerView.Adapter<MyAdapter.ResultsItemHolder>() {

    class ResultsItemHolder(val binding: FilmItemsBinding) :
        RecyclerView.ViewHolder(binding.root) {
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ResultsItemHolder {
        val view = FilmItemsBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ResultsItemHolder(view)
    }

    override fun onBindViewHolder(holder: ResultsItemHolder, position: Int) {
        // Convert Invoice to ContractAccount and bind it to the view
        val resultsItem = results[position]

        Glide.with(holder.itemView.context)
            .load("https://image.tmdb.org/t/p/w500/${resultsItem.poster_path}")
            .placeholder(R.drawable.ic_launcher_background) // Yükleme sırasında gösterilecek varsayılan görsel
            .error(R.drawable.ic_launcher_background) // Hata durumunda gösterilecek varsayılan görsel
            .into(holder.binding.backDropPath)
        holder.binding.textViewFilmName.text = resultsItem.title.toString()
        holder.binding.backDropPath.setOnClickListener {
            callback.invoke(resultsItem)

        }
/*        holder.binding.id.text = resultsItem.id.toString()
        holder.binding.textViewAdult.text = resultsItem.adult.toString()
        holder.binding.originalLanguage.text = resultsItem.original_language.toString()
        holder.binding.originalTitle.text = resultsItem.original_title.toString()
        holder.binding.overview.text = resultsItem.overview.toString()
        holder.binding.popularity.text = resultsItem.popularity.toString()
        holder.binding.posterPath.text = resultsItem.poster_path.toString()
        holder.binding.releaseDate.text = resultsItem.release_date.toString()
        holder.binding.title.text = resultsItem.title.toString()
        holder.binding.video.text = resultsItem.video.toString()
        holder.binding.voteAverage.text = resultsItem.vote_average.toString()
        holder.binding.voteCount.text = resultsItem.vote_count.toString()*/



    }


    override fun getItemCount(): Int {
        return results.size
    }

    fun newList(myList: ArrayList<ResultsItem>) {
        results.clear()
        results.addAll(myList)
        notifyDataSetChanged()
    }
}