package com.example.blooddonationapp.nav_pages

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.blooddonationapp.R

class Profile_Page : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_profile__page, container, false)
    }

    companion object {
        fun newInstance(): Profile_Page = Profile_Page()
    }
}