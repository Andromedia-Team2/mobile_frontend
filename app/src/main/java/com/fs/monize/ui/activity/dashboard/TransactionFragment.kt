package com.fs.monize.ui.activity.dashboard

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.fs.monize.R
import com.fs.monize.databinding.FragmentTransactionBinding
import com.fs.monize.ui.activity.transaction.TransactionActivity
import com.fs.monize.ui.viewmodel.MainViewModel
import com.fs.monize.ui.viewmodel.ViewModelFactory

class TransactionFragment : Fragment() {
    private lateinit var binding: FragmentTransactionBinding
    private lateinit var mainViewModel: MainViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentTransactionBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setUpData()
        binding.coba.setOnClickListener {
            val intent = Intent(context, TransactionActivity::class.java)
            startActivity(intent)
        }
    }

    private fun setUpData(){
        val factory =ViewModelFactory.getInstance(activity!!.application)
        mainViewModel =ViewModelProvider(this, factory).get(MainViewModel::class.java)
        mainViewModel.getFund().observe(this, Observer { listFund ->
            if (listFund.size != 0){
                binding.txtSaldo.text = "Rp. " + listFund[0].fund_balance.toString()+ ".-"
            }else{
                binding.txtSaldo.text = "Rp. 0.-"
            }
        })
        setUpRecycler()
    }

    private fun setUpRecycler(){
        binding.rvTransaction.setHasFixedSize(true)
        binding.rvTransaction.layoutManager =LinearLayoutManager(context)
        mainViewModel.getTransaction().observe(this, Observer { listTransaction ->
            val adapter = TransactionAdapter(listTransaction)
            binding.rvTransaction.adapter = adapter

            if (listTransaction.size != 0) {
                binding.linearEmpty.visibility = View.GONE
            } else {
                binding.linearEmpty.visibility = View.VISIBLE
            }
        })
    }
}