package com.example.diffutilsample

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView

private const val ITEM_TYPE_0 = 0
private const val ITEM_TYPE_1 = 1

class MyAdapter :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    private var employeeList = mutableListOf<DetailsModal>()

    override fun getItemViewType(position: Int): Int {
       return if(employeeList[position].id%2==0) ITEM_TYPE_0 else ITEM_TYPE_1
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
       return when(viewType){
           ITEM_TYPE_0->{
               val itemView =
                   LayoutInflater.from(parent.context)
                       .inflate(R.layout.recycler_item2, parent, false)
               MyViewHolder2(itemView)
           }

               else->{
                 val itemView =  LayoutInflater.from(parent.context)
                       .inflate(R.layout.recycler_item, parent, false)
               MyViewHolder(itemView)
           }

       }

    }

    override fun getItemCount(): Int =
         employeeList.size


    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val employee = employeeList[position]
//        if (employeeList.get(position).id%2 == 0) {
//            (holder as MyViewHolder2).empFirstName2.text=employee.firstname
//           holder.empLastName2.text=employee.lastname
////           val holder2:MyViewHolder2=holder as MyViewHolder2
////            holder2.empFirstName2.text = employee.firstname
////            holder2.empLastName2.text = employee.lastname
//        }
//        else{
////            val holder1:MyViewHolder=holder as MyViewHolder
//            (holder as MyViewHolder).empFirstName.text=employee.firstname
//            holder.empLastName.text=employee.lastname
//        }
        when (holder.itemViewType) {
            ITEM_TYPE_0 -> {
                val viewHolder: MyViewHolder2? = (holder as? MyViewHolder2)
                viewHolder?.empFirstName2?.text = employee.firstname
                viewHolder?.empLastName2?.text = employee.lastname

            }
            else -> {

                val viewHolder = (holder as? MyViewHolder)
                viewHolder?.empFirstName?.text = employee.firstname
                viewHolder?.empLastName?.text = employee.lastname
            }
        }
    }


    fun setData(emloyeeList:Pair<DiffUtil.DiffResult?, List<DetailsModal>>) {
//        val employeeCallBack = EmployeeCallBack(employeeList, this.employeeList)
//        val diffResult = DiffUtil.calculateDiff(employeeCallBack)
        this.employeeList.clear()
        this.employeeList.addAll(emloyeeList.second)
        emloyeeList.first?.dispatchUpdatesTo(this)
    }

    inner class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val empFirstName: TextView = itemView.findViewById(R.id.tv_firstname)
        val empLastName: TextView = itemView.findViewById(R.id.tv_lastname)

    }

    inner class MyViewHolder2(itemView: View):RecyclerView.ViewHolder(itemView){
        val empFirstName2:TextView=itemView.findViewById(R.id.tv_firstname2)
        val empLastName2:TextView=itemView.findViewById(R.id.tv_lastname2)

    }
}