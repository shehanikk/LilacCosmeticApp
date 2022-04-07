package com.example.lilaccosmeticapp

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.lilaccosmeticapp.databinding.FragmentHome2Binding
import com.example.lilaccosmeticapp.databinding.FragmentHome3Binding

class Home3Fragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val bind = FragmentHome3Binding.inflate(layoutInflater)

        bind.btnMoonCollection.setOnClickListener{
            val intent = Intent (this@Home3Fragment.requireContext(), remcollection::class.java)
            startActivity(intent)
        }
        return bind.root

    }

}