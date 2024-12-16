package com.example.logitask.navigationSystem

import android.app.Activity
import android.util.Log
import android.content.Intent
import com.example.logitask.CreateTeam
import com.example.logitask.HomeActivity
import com.example.logitask.LoginPageActivity
import com.example.logitask.ManageTeam
import com.example.logitask.WelcomeActivity
import com.example.logitask.RegisterPageActivity
import com.example.logitask.UserProfile

var routes: MutableList<Destiny> = mutableListOf(
    Destiny("Welcome", WelcomeActivity()),
    Destiny("Login", LoginPageActivity()),
    Destiny("Register", RegisterPageActivity()),
    Destiny("Home", HomeActivity()),
    Destiny("GerirEquipa", ManageTeam()),
    Destiny("PerfilUtilizador", UserProfile()),
    Destiny("CriarEquipa", CreateTeam())
)

class Routes {
    companion object {
        fun routeNavigation(currentRoute: Activity, destinyRoute: String) {
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
