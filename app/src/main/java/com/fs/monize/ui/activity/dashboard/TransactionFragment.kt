package com.fs.monize.ui.activity.dashboard

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.fs.monize.R
import com.fs.monize.databinding.FragmentTransactionBinding
import com.fs.monize.ui.activity.transaction.TransactionActivity

class TransactionFragment : Fragment() {
    private lateinit var binding: FragmentTransactionBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentTransactionBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.coba.setOnClickListener {
            val intent = Intent(context, TransactionActivity::class.java)
            startActivity(intent)
        }
    }
}