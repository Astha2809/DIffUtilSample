package com.example.diffutilsample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity2 : AppCompatActivity() {
    //private val repository=Repository()

    private var employeeViewModelAsync = EmployeeViewModelAsync()

    lateinit var empList: List<DetailsModal>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)
        val adapter2 = MyAdapter2()
        val recyclerView2 = findViewById<RecyclerView>(R.id.recycler2)
        val button2 = findViewById<Button>(R.id.b_main2)
        val remove = findViewById<Button>(R.id.b_remove_main)


        recyclerView2.layoutManager = LinearLayoutManager(this)
        recyclerView2.setHasFixedSize(true)
        recyclerView2.adapter = adapter2

        employeeViewModelAsync = ViewModelProvider(this).get(EmployeeViewModelAsync::class.java)

        //empList=repository.detailsModalSortedbyId
        empList = employeeViewModelAsync.fetchUsersAsync()
        adapter2.submitList(empList)


        button2.setOnClickListener {
            empList = employeeViewModelAsync.ascSortingASync()
            adapter2.submitList(empList)

        }
        remove.setOnClickListener {
            //empList=repository.detailsModelSortedbyIdAsc
            empList = employeeViewModelAsync.sortByNameAsync()
            adapter2.submitList(empList)
        }

    }
}