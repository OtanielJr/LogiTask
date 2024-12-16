package com.example.logitask.fragments

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.logitask.R
import com.example.logitask.navigationSystem.Routes

class DashboardFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? = inflater.inflate(R.layout.fragment_dashboard, container, false)

    fun onManageTeamClick() {
        Log.d("ManageTeam","ManageTeam clicked")
        Routes.routeNavigation(requireContext(),"CreateTeam")
    }
}