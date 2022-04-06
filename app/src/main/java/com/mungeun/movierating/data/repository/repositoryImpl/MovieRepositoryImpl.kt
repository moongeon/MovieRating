package com.mungeun.movierating.data.repository.repositoryImpl

import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.ktx.toObject
import com.mungeun.movierating.data.repository.MovieRepository
import com.mungeun.movierating.domain.model.Movie
import kotlinx.coroutines.tasks.await
import javax.inject.Inject


class MovieRepositoryImpl @Inject constructor(private val firestore: FirebaseFirestore) : MovieRepository {

    override suspend fun getAllMovies(): List<Movie> {
        return     firestore.collection("movies")
            .get()
            .await()
            .map { it.toObject<Movie>() }
    }
}