package com.batterb.filmslist.presentation.movies

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.batterb.filmslist.app.FilmsList
import com.batterb.filmslist.databinding.MoviesActivityBinding
import javax.inject.Inject

class MoviesActivity : AppCompatActivity() {

    private lateinit var binding: MoviesActivityBinding

    private lateinit var viewModel : MoviesViewModel

    @Inject
    lateinit var moviesViewModelFactory: MoviesViewModelFactory

    @Inject
    lateinit var adapter: MoviesAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        (applicationContext as FilmsList).appComponent.inject(this)
        super.onCreate(savedInstanceState)
        binding = MoviesActivityBinding.inflate(layoutInflater)
        viewModel = ViewModelProvider(this, moviesViewModelFactory)[MoviesViewModel::class.java]

        setContentView(binding.root)
        val layoutManager = LinearLayoutManager(this)
        binding.recyclerViewMovies.adapter = adapter
        binding.recyclerViewMovies.layoutManager = layoutManager
        viewModel.loadMovies()
        setObserver()
        setListener(layoutManager)

    }

    private fun setListener(layoutManager : LinearLayoutManager){
        binding.recyclerViewMovies.addOnScrollListener(object : RecyclerView.OnScrollListener(){
            override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                super.onScrolled(recyclerView, dx, dy)
                val visibleItemCount = layoutManager.childCount
                val totalItemCount = layoutManager.itemCount
                val firstVisibleItems = layoutManager.findFirstVisibleItemPosition()
                if (!viewModel.isLoading) {//проверка не загружается ли уже что то в данный момент
                    if ((visibleItemCount + firstVisibleItems) >= totalItemCount - 10) { // если просматривастя последние 10 элементов то начинается подргрузка новых
                        viewModel.loadMovies()
                    }
                }
            }
        })
    }

    private fun setObserver() {
        viewModel.movieList.observe(this){
            if (it != null){
                val newMovieList = adapter.movies.toMutableList()
                newMovieList.addAll(it)
                adapter.movies = newMovieList
            }
        }
    }
}