package com.example.diffutilsample

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView

class MyAdapter2 : RecyclerView.Adapter<RecyclerView.ViewHolder>() {


    var diffCallBack = EmployeeCallBackAsync()

    //         override fun areItemsTheSame(oldItem: DetailsModal, newItem: DetailsModal): Boolean {
//             return oldItem.id==newItem.id
//         }
//
//         override fun areContentsTheSame(oldItem: DetailsModal, newItem: DetailsModal): Boolean {
//             return oldItem.firstname == newItem.firstname
//         }
//
//     }
    val differ: AsyncListDiffer<DetailsModal> = AsyncListDiffer(this, diffCallBack)


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyAdapter2.MyViewHolder {
        val itemView =
            LayoutInflater.from(parent.context).inflate(R.layout.recycler_item, parent, false)
        return MyViewHolder(itemView)
    }

    override fun getItemCount(): Int {
        return differ.currentList.size
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val employee = differ.currentList[position]
        (holder as MyViewHolder).empFirstName2.text = employee.firstname
        holder.empLastName2.text = employee.lastname

    }

    fun submitList(emloyeeList2: List<DetailsModal>) {
        differ.submitList(emloyeeList2)

    }

//    fun UserGetItem(position: Int): DetailsModal {
//        return differ.currentList[position]
//
//    }


    inner class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val empFirstName2: TextView = itemView.findViewById(R.id.tv_firstname)
        val empLastName2: TextView = itemView.findViewById(R.id.tv_lastname)


    }
}