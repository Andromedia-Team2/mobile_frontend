package com.fs.monize.ui.activity.dashboard

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.fs.monize.R
import com.fs.monize.databinding.FragmentSavingBinding

class SavingFragment : Fragment() {
    private lateinit var binding: FragmentSavingBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        binding = FragmentSavingBinding.inflate(inflater, container, false)
        return binding.root
    }


}