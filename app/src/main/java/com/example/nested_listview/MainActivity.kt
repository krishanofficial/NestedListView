package com.example.nested_listview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ListView

import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class MainActivity : AppCompatActivity() {
    private val mainList = ArrayList<DataModel>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val recyclerView=findViewById<RecyclerView>(R.id.mainRecyclerView)
        recyclerView.setHasFixedSize(true)
        recyclerView.layoutManager=LinearLayoutManager(this)
        addDataToList()
        val adapter = MainItemAdpater(mainList)
        recyclerView.adapter = adapter
    }

    override fun onStart() {
        super.onStart()
                ChildListApiCalling.create().getUser().observeOn(AndroidSchedulers.mainThread())
                    .subscribeOn(Schedulers.io())
                    .subscribe { result ->
                        val listView = findViewById<ListView>(R.id.mainRecyclerView)
                        listView.adapter =ChildAdpater(this,result)
                    }
    }
    private fun addDataToList() {
        val childItems1 = ArrayList<ChildDataModel>()
        childItems1.add(ChildDataModel("Biryani", R.drawable.biryani))
        childItems1.add(ChildDataModel("Cake", R.drawable.cake))
        childItems1.add(ChildDataModel("Chicken", R.drawable.dala))
        childItems1.add(ChildDataModel("Panner", R.drawable.panner))
        mainList.add(DataModel("Game Development", R.drawable.krishan, childItems1))

        val childItems2 = ArrayList<ChildDataModel>()
        childItems2.add(ChildDataModel("Pizza", R.drawable.pizza))
        childItems2.add(ChildDataModel("Roll", R.drawable.roll))
        childItems2.add(ChildDataModel("Samosa", R.drawable.samosa))
        childItems2.add(ChildDataModel("Thali", R.drawable.thali))
        mainList.add(DataModel("Development", R.drawable.rajana, childItems2))
    }
}
