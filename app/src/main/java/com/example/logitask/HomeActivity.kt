package com.example.logitask

import android.annotation.SuppressLint
import android.os.Bundle
import android.os.Handler
import android.util.Log
import android.view.MenuItem
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.fragment.app.Fragment
import com.example.logitask.cache.getUserDataFromCache
import com.example.logitask.fragments.DashboardFragment
import com.example.logitask.fragments.HomeFragment
import com.example.logitask.fragments.RecruitmentFragment
import com.example.logitask.navigationSystem.Routes
import com.google.android.material.badge.BadgeDrawable
import java.io.File
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class HomeActivity : AppCompatActivity() {

    @SuppressLint("SuspiciousIndentation")
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

    val welcomeText = findViewById<TextView>(R.id.welcome_message)
    val user = getUserDataFromCache(this@HomeActivity)
        if (user != null) {
            welcomeText.text = "Bem vindo, "+user.username
            Log.d("username", user.username)
        }

    }




    private fun setCurrentFragment(fragment: Fragment) =
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.fl_wrapper, fragment)
            commit()
        }


}

private operator fun CharSequence.plusAssign(s: String) {

}
