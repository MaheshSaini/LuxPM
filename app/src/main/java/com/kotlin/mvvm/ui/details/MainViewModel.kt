package com.kotlin.mvvm.ui.details

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.kotlin.mvvm.repository.model.countries.Country
import com.kotlin.mvvm.repository.repo.countries.CountriesRepository
import kotlinx.coroutines.launch
import javax.inject.Inject

/**
 * Created by Mahesh Saini on 08,November,2019
 */

/**
 * A container for [Country] related data to show on the UI.
 */
class MainViewModel @Inject constructor(val countriesRepository: CountriesRepository) :
    ViewModel() {

    /**
     * Loading news articles from internet and database
     */
    private var countries: MutableLiveData<List<Country>> = MutableLiveData()

    fun getCountries(): LiveData<List<Country>> {
        viewModelScope.launch {
            val result = countriesRepository.getCountries()
            countries.postValue(result)
        }
        return countries
    }
}