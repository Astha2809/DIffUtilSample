package com.example.diffutilsample

import android.content.Intent
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

    private var employeeViewModel:EmployeeViewModel?=null

   // private val adapter=MyAdapter(repository.detailsModalSortedbyId)
    private lateinit var empList:Pair<DiffUtil.DiffResult?, List<DetailsModal>>
    //var em:ArrayList<DetailsModal>?=null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val adapter=MyAdapter()

        val recyclerView=findViewById<RecyclerView>(R.id.recycler)
        val updateButton=findViewById<Button>(R.id.b_update_item)
        val removeButton=findViewById<Button>(R.id.b_remove)
        val nextButton=findViewById<Button>(R.id.b_next)


        recyclerView.layoutManager= LinearLayoutManager(this)
        recyclerView.adapter=adapter

        employeeViewModel= ViewModelProvider(this).get(EmployeeViewModel::class.java)
        empList= employeeViewModel?.fetchUsers()?: Pair(null, arrayListOf())
        adapter.setData(empList)







        updateButton.setOnClickListener {


           empList=employeeViewModel?.ascSorting(empList.second)?: Pair(null, arrayListOf())
            //empList=employeeViewModel!!.ascSorting(repository.detailsModelSortedbyIdAsc)
            adapter.setData(empList)
           Log.i("emplist", empList.toString())
           // adapter.setData(employeeViewModel!!.ascSorting())
            //Log.i("clicked","clicked")
        }

        removeButton.setOnClickListener{
//            val aa =repository.firstFive
//            Log.i("aa", aa.toString())
            empList=employeeViewModel?.sortByName(empList.second)?: Pair(null, arrayListOf())
            //empList=employeeViewModel!!.sortByName(repository.detailsModalSortbyName)
            adapter.setData(empList)
        }
nextButton.setOnClickListener {

    intent = Intent(applicationContext, MainActivity2::class.java)
    startActivity(intent)
}

    }

}