package com.mungeun.movierating.presentaion.di

import com.google.firebase.firestore.FirebaseFirestore
import com.mungeun.movierating.data.repository.MovieRepository
import com.mungeun.movierating.data.repository.repositoryImpl.MovieRepositoryImpl
import com.mungeun.movierating.domain.usecase.GetAllMoviesUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Inject
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class AppModule {

    @Provides
    @Singleton
    fun provideMovieRepository (firestore: FirebaseFirestore) : MovieRepository{
        return MovieRepositoryImpl(firestore)
    }

    @Provides
    @Singleton
    fun provideMovieGetAllMoviesUseCase(movieRepository: MovieRepository): GetAllMoviesUseCase{
        return GetAllMoviesUseCase(movieRepository)
    }
}