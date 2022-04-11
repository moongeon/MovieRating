package com.mungeun.movierating.presentaion.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mungeun.movierating.domain.model.Movie
import com.mungeun.movierating.domain.usecase.GetAllMoviesUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val getAllMoviesUseCase: GetAllMoviesUseCase
): ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "This is home Fragment"
    }
    val text: LiveData<String> = _text

    private  var _moveList = MutableLiveData<List<Movie>>()

    val moveList = _moveList

    init {
        viewModelScope.launch {
            _moveList.value = getAllMoviesUseCase.Invoke()


        }

    }
}