package com.example.diffutilsample


import androidx.recyclerview.widget.DiffUtil

class EmployeeCallBack(
    var newList:List<DetailsModal>,
    var oldList: List<DetailsModal>
) : DiffUtil.Callback(){
    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return oldList[oldItemPosition].id==newList[newItemPosition].id
    }

    override fun getOldListSize(): Int {
       return oldList.size
    }

    override fun getNewListSize(): Int {
       return newList.size
    }

    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return oldList[oldItemPosition].firstname == newList[newItemPosition].lastname
    }


}