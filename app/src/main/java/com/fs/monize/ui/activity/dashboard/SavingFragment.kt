package com.fs.monize.ui.activity.dashboard

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.fs.monize.R
import com.fs.monize.databinding.FragmentSavingBinding
import com.fs.monize.ui.viewmodel.MainViewModel
import com.fs.monize.ui.viewmodel.ViewModelFactory

class SavingFragment : Fragment() {
    private lateinit var binding: FragmentSavingBinding
    private lateinit var mainViewModel: MainViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        binding = FragmentSavingBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setUpData()
    }

    private fun setUpData(){
        val factory = ViewModelFactory.getInstance(activity!!.application)
        mainViewModel = ViewModelProvider(this, factory).get(MainViewModel::class.java)
        setUpRecycler()
    }

    private fun setUpRecycler(){
        binding.rvSaving.setHasFixedSize(true)
        binding.rvSaving.layoutManager = LinearLayoutManager(context)
        mainViewModel.getSaving().observe(this, Observer { listSaving ->
            val adapter = SavingAdapter(listSaving)
            binding.rvSaving.adapter = adapter

            if (listSaving.size != 0) {
                binding.linearEmpty.visibility = View.GONE
            } else {
                binding.linearEmpty.visibility = View.VISIBLE
            }
        })
    }


}