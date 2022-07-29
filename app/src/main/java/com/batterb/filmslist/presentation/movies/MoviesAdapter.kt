package com.batterb.filmslist.presentation.movies

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.batterb.domain.models.MovieModel
import com.batterb.filmslist.databinding.MovieItemBinding
import com.bumptech.glide.Glide

class MoviesAdapter : RecyclerView.Adapter<MoviesAdapter.MovieViewHolder>() {

    class MovieViewHolder(
        val binding : MovieItemBinding
    ) : RecyclerView.ViewHolder(binding.root)

    var movies : MutableList<MovieModel> = mutableListOf()
        set (newValue){
            field = newValue
            notifyDataSetChanged()
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = MovieItemBinding.inflate(inflater, parent,false)
        return MovieViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        val movie = movies[position]
        with(holder.binding){
            movieTitle.text = movie.title
            movieDescription.text = movie.description
            Glide.with(root.context).load(movie.image).into(movieImage)
        }
    }
    override fun getItemCount(): Int = movies.size
}