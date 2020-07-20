package com.example.diffutilsample

import androidx.lifecycle.ViewModel
import androidx.recyclerview.widget.DiffUtil

class EmployeeViewModel :ViewModel(){
    var repository=Repository()


    fun fetchUsers(): Pair<DiffUtil.DiffResult?, List<DetailsModal>> {
        //
        val newUserList:List<DetailsModal>
        newUserList=repository.detailsModalSortedbyId
        val employeeCallBack=EmployeeCallBack(newUserList, arrayListOf())
        //val employeeCallBack = arrayListOf<DetailsModal>().let { EmployeeCallBack(newUserList, it) }
val diffResult=DiffUtil.calculateDiff(employeeCallBack)
       // val diffResult = employeeCallBack.let { DiffUtil.calculateDiff(it) }


        return Pair(diffResult,newUserList)

    }
    fun ascSorting (oldUsers:List<DetailsModal>):Pair<DiffUtil.DiffResult?, List<DetailsModal>> {


        val newUserList=repository.detailsModalSortedbyId
        //val employeeCallBack = oldUsers?.let { EmployeeCallBack(newUserList, it) }

        val employeeCallBack=EmployeeCallBack(newUserList,oldUsers)
        val diffResult = DiffUtil.calculateDiff(employeeCallBack)
        //return updatedList
        return Pair(diffResult,newUserList)
    }


    fun sortByName(oldUsers: List<DetailsModal>): Pair<DiffUtil.DiffResult?, List<DetailsModal>> {
        var newUserList:List<DetailsModal> = arrayListOf()
        newUserList=repository.detailsModalSortbyName
        val employeeCallBack=EmployeeCallBack(newUserList,oldUsers)
        val diffResult = DiffUtil.calculateDiff(employeeCallBack)

        //updatedList=repository.firstFive

        return Pair(diffResult,newUserList)

    }

}