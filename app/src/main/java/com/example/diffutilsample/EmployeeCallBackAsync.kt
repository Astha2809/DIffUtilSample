package com.example.diffutilsample

import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil

class EmployeeCallBackAsync : DiffUtil.ItemCallback<DetailsModal>() {
    //private val adapter2:MyAdapter2=MyAdapter2()
    // private val employeeCallBackAsync= EmployeeCallBackAsync()
    // val diffCallbAck=object : DiffUtil.ItemCallback<DetailsModal>(){
    override fun areItemsTheSame(oldItem: DetailsModal, newItem: DetailsModal): Boolean =
        oldItem.id == newItem.id


    override fun areContentsTheSame(oldItem: DetailsModal, newItem: DetailsModal): Boolean =
        oldItem.firstname == newItem.firstname

}
//    override fun areItemsTheSame(oldItem: DetailsModal, newItem: DetailsModal): Boolean {
//        return oldItem.id==newItem.id
//    }
//
//    override fun areContentsTheSame(oldItem: DetailsModal, newItem: DetailsModal): Boolean {
//        return oldItem.firstname == newItem.firstname
//    }
//val differ: AsyncListDiffer<DetailsModal> = AsyncListDiffer(adapter2,diffCallbAck)


//}