package com.example.e_softwarica

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.viewpager2.widget.ViewPager2
import com.example.e_softwarica.Fragment.AboutusFragment
import com.example.e_softwarica.Fragment.AddstudentFragment
import com.example.e_softwarica.Fragment.HomeFragment
import com.example.e_softwarica.adapter.Viewpageradapter
import com.example.e_softwarica.model.Student
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator

class DashboardActivity : AppCompatActivity() {
    private lateinit var lstTitle: ArrayList<String>
    private lateinit var lstFragments: ArrayList<Fragment>
    private lateinit var viewpager: ViewPager2
    private lateinit var tablayout: TabLayout


    companion object {
        @JvmStatic
        public var listOfStudents = arrayListOf<Student>();
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dashboard)

        viewpager = findViewById(R.id.viewpager)
        tablayout = findViewById(R.id.tablayout)

        populatelist()

        val adapter = Viewpageradapter(lstFragments, supportFragmentManager, lifecycle)
        viewpager.adapter = adapter
        TabLayoutMediator(tablayout, viewpager) { tab, position ->
            tab.text = lstTitle[position]
        }.attach()
    }

    private fun populatelist(){
        lstTitle= ArrayList<String>()
        lstTitle.add("Home")
        lstTitle.add("AddStudent")
        lstTitle.add("Aboutus")
        lstFragments= ArrayList<Fragment>()
        lstFragments.add(HomeFragment())
        lstFragments.add(AddstudentFragment())
        lstFragments.add(AboutusFragment())

    }
}