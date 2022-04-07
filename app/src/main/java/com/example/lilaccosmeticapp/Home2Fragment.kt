package com.example.lilaccosmeticapp

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.lilaccosmeticapp.databinding.FragmentHome2Binding

class Home2Fragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val bind = FragmentHome2Binding.inflate(layoutInflater)

        bind.btnMidnightCollection.setOnClickListener{
            val intent = Intent (this@Home2Fragment.requireContext(), maccollection::class.java)
            startActivity(intent)
        }
        return bind.root

    }

}