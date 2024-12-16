package com.example.logitask

import android.os.Bundle
import android.os.Handler
import android.util.Log
import android.view.MenuItem
import android.view.View
import android.widget.ImageView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.fragment.app.Fragment
import com.example.logitask.fragments.DashboardFragment
import com.example.logitask.fragments.HomeFragment
import com.example.logitask.fragments.RecruitmentFragment
import com.example.logitask.navigationSystem.Routes
import com.google.android.material.badge.BadgeDrawable

import com.google.android.material.bottomnavigation.BottomNavigationView

class HomeActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_home)



        // Fragments initialization

        val homeFragment = HomeFragment()
        val dashboardFragment = DashboardFragment()
        val recruitmentFragment = RecruitmentFragment()


        setCurrentFragment(homeFragment) // Default fragment

        // Setting up badges with delays

        val bottomNavigation = findViewById<BottomNavigationView>(R.id.bottom_navigation)
        bottomNavigation.setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.nav_home -> {
                    setCurrentFragment(homeFragment)

                }
                R.id.nav_dashboard -> {
                    setCurrentFragment(dashboardFragment)

                }
                R.id.nav_recruitment -> {
                    setCurrentFragment(recruitmentFragment)
                }
            }
            true
        }
    }

        /*val bottomNavigationView = findViewById<BottomNavigationView>(R.id.bottom_navigation)
        bottomNavigationView.setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.nav_home -> {
                    Log.d("Nav home clicked", "Nav home clicked")
                    Routes.routeNavigation(this, "Home")
                }
                R.id.nav_dashboard -> {
                    Log.d("Nav dashboard", "Nav dashboard clicked")
                    Routes.routeNavigation(this, "Dashboard")
                }
                R.id.nav_recruitment -> {
                    Log.d("Nav recruitment", "Nav recruitment clicked")
                    Routes.routeNavigation(this, "Recruitment")
                }
            }
            true
        }*/


    private fun setCurrentFragment(fragment: Fragment) =
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.fl_wrapper, fragment)
            commit()
        }
}
