package com.example.logitask.navigationSystem

import android.content.Context
import android.util.Log
import android.content.Intent
import com.example.logitask.CreateTeam
import com.example.logitask.CreateUser1
import com.example.logitask.HomeActivity
import com.example.logitask.LoginPage
import com.example.logitask.ManageColaborators
import com.example.logitask.ManageTeam
import com.example.logitask.WelcomeActivity
import com.example.logitask.RegisterPage
import com.example.logitask.UserProfile

var routes: MutableList<Destiny> = mutableListOf(
    Destiny("Welcome", WelcomeActivity()),
    Destiny("Login", LoginPage()),
    Destiny("Register", RegisterPage()),
    Destiny("Home", HomeActivity()),
    Destiny("ManageTeam", ManageTeam()),
    Destiny("UserProfile", UserProfile()),
    Destiny("CreateTeam", CreateTeam()),
    Destiny("ManageColaborators", ManageColaborators()),
    Destiny("CreateUser1", CreateUser1())
)

class Routes {
    companion object {
        fun routeNavigation(currentRoute: Context, destinyRoute: String) {
            for (r in routes) {
                if (r.name == destinyRoute) {
                    val intent = Intent(currentRoute, r.activity::class.java)
                    currentRoute.startActivity(intent)
                    Log.d("Rota Correta", "Chegou em ${r.name}")

                } else {
                    Log.e("Rota errada", "Troque a rota: ${r.activity.toString()}")
                }
            }
        }
    }



}
