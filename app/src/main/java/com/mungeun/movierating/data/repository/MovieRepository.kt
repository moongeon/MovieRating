package com.mungeun.movierating.data.repository

import com.mungeun.movierating.domain.model.Movie

interface MovieRepository {

    suspend fun getAllMovies() : List<Movie>
}