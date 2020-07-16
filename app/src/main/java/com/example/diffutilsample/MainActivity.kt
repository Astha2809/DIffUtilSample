package com.example.diffutilsample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

import androidx.recyclerview.widget.DiffUtil

class MainActivity : AppCompatActivity() {
    private val repository=Repository()
    private var employeeViewModel:EmployeeViewModel?=null
    var adapter=MyAdapter()
   // private val adapter=MyAdapter(repository.detailsModalSortedbyId)
    private lateinit var empList:Pair<DiffUtil.DiffResult?, List<DetailsModal>>
    //var em:ArrayList<DetailsModal>?=null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val recyclerView=findViewById<RecyclerView>(R.id.recycler)
        val updateButton=findViewById<Button>(R.id.b_update_item)
        val removeButton=findViewById<Button>(R.id.b_remove)


        recyclerView.layoutManager= LinearLayoutManager(this)
        recyclerView.adapter=adapter

        employeeViewModel= ViewModelProvider(this).get(EmployeeViewModel::class.java)
        empList= employeeViewModel!!.fetchUsers()
        adapter.setData(empList)

       // adapter=MyAdapter(this)





        updateButton.setOnClickListener(View.OnClickListener {
//            val aa=repository.firstFive
//            val bb=employeeViewModel!!.five()

           empList=employeeViewModel!!.ascSorting(empList.second)
            //empList=employeeViewModel!!.ascSorting(repository.detailsModelSortedbyIdAsc)
            adapter.setData(empList)
           Log.i("emplist", empList.toString())
           // adapter.setData(employeeViewModel!!.ascSorting())
            //Log.i("clicked","clicked")
        })

        removeButton.setOnClickListener(View.OnClickListener {
//            val aa =repository.firstFive
//            Log.i("aa", aa.toString())
            //empList=employeeViewModel!!.ascSorting(empList.second)
            empList=employeeViewModel!!.sortByName(repository.detailsModalSortbyName)
            adapter.setData(empList)
        })


    }

}