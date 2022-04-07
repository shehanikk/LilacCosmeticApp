package com.example.lilaccosmeticapp

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.lilaccosmeticapp.databinding.FragmentHome1Binding

class Home1Fragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val bind = FragmentHome1Binding.inflate(layoutInflater)

        bind.btnKylieCollection.setOnClickListener{
            val intent = Intent (this@Home1Fragment.requireContext(), kyliecollection::class.java)
            startActivity(intent)
        }
        return bind.root

    }


}