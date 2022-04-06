package com.mungeun.movierating.domain.usecase

import com.mungeun.movierating.data.repository.MovieRepository
import com.mungeun.movierating.domain.model.Movie
import javax.inject.Inject

class GetAllMoviesUseCase @Inject constructor(private val movieRepository: MovieRepository){

    suspend fun Invoke() : List<Movie> {
        return movieRepository.getAllMovies()
    }
}