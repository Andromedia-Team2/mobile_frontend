package com.fs.monize.ui.activity.simpanan

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.fs.monize.R
import com.fs.monize.databinding.FragmentEditSimpananBinding
import com.fs.monize.databinding.FragmentTransactionBinding


class EditSimpanan : Fragment() {
    private lateinit var binding: FragmentEditSimpananBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = FragmentEditSimpananBinding.inflate(layoutInflater)

        fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                         savedInstanceState: Bundle?): View? {
            binding = FragmentEditSimpananBinding.inflate(inflater, container, false)
            return binding.root
        }
    }

    fun onClick(v: View?) {
        when(v?.id){
            R.id.btn_save_trans -> startActivity(Intent(this, FragmentTransactionBinding::class.java))
        }
    }

    private fun Intent(editSimpanan: EditSimpanan, java: Class<FragmentTransactionBinding>): Intent? {
        return null
    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_edit_simpanan, container, false)
    }



}