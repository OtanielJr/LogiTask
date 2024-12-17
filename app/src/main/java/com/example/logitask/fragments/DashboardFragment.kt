package com.example.logitask.fragments

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.AppCompatButton
import androidx.fragment.app.Fragment
import com.example.logitask.R
import com.example.logitask.navigationSystem.Routes

class DashboardFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? = inflater.inflate(R.layout.fragment_dashboard, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val manageTeamButton = view.findViewById<AppCompatButton>(R.id.gerir_equipas_btn)
        val manageCollaboratorsButton = view.findViewById<AppCompatButton>(R.id.gerir_colaboradores_btn)

        manageTeamButton.setOnClickListener {
            Log.d("ManageTeam", "ManageTeam clicked")
            Routes.routeNavigation(requireContext(), "ManageTeam")
        }

        manageCollaboratorsButton.setOnClickListener {
            Log.d("ManageColaborators", "ManageColaborators clicked")
            Routes.routeNavigation(requireContext(), "ManageColaborators")
        }
    }
}