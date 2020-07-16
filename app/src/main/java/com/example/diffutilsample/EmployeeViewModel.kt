package com.example.diffutilsample

import androidx.lifecycle.ViewModel
import androidx.recyclerview.widget.DiffUtil

class EmployeeViewModel :ViewModel(){
    var repository=Repository()
    lateinit var updatedList: List<DetailsModal>

    fun fetchUsers(): Pair<DiffUtil.DiffResult?, List<DetailsModal>> {
        //
        val newUserList:List<DetailsModal>
        newUserList=repository.detailsModalSortedbyId
        val employeeCallBack = arrayListOf<DetailsModal>()?.let { EmployeeCallBack(newUserList, it) }
        val diffResult = employeeCallBack?.let { DiffUtil.calculateDiff(it) }


        return Pair(diffResult,newUserList)

    }
    fun ascSorting (oldUsers:List<DetailsModal>?=null):Pair<DiffUtil.DiffResult?, List<DetailsModal>> {
       // updatedList=repository.detailsModelSortedbyIdAsc
        var newUserList:List<DetailsModal> = arrayListOf()
        newUserList=repository.detailsModalSortedbyId
        val employeeCallBack = oldUsers?.let { EmployeeCallBack(newUserList, it) }
        val diffResult = employeeCallBack?.let { DiffUtil.calculateDiff(it) }
        //return updatedList
        return Pair(diffResult,newUserList)
    }

    fun sortByName(oldUsers: List<DetailsModal>?=null): Pair<DiffUtil.DiffResult?, List<DetailsModal>> {
        var newUserList:List<DetailsModal> = arrayListOf()
        newUserList=repository.detailsModalSortbyName
        val employeeCallBack = oldUsers?.let { EmployeeCallBack(newUserList, it) }
        val diffResult = employeeCallBack?.let { DiffUtil.calculateDiff(it) }

        //updatedList=repository.firstFive

        return Pair(diffResult,newUserList)

    }

}