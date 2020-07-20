package com.example.diffutilsample

import androidx.lifecycle.ViewModel

class EmployeeViewModelAsync : ViewModel() {
    var repository = Repository()

    fun fetchUsersAsync(): List<DetailsModal> {

        return repository.detailsModalSortedbyId


    }

    fun ascSortingASync(): List<DetailsModal> {
        return repository.detailsModelSortedbyIdAsc
    }

    fun sortByNameAsync(): List<DetailsModal> {

        return repository.detailsModalSortbyName
    }

}
