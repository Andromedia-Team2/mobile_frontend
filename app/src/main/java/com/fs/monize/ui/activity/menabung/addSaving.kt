package com.fs.monize.ui.activity.menabung

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.fs.monize.R
import com.fs.monize.databinding.FragmentAddSavingBinding
import com.fs.monize.databinding.FragmentSavingBinding


class addSaving : Fragment(), View.OnClickListener {
    private lateinit var binding: FragmentAddSavingBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = FragmentAddSavingBinding.inflate(layoutInflater)

        fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                                  savedInstanceState: Bundle?): View? {
            binding = FragmentAddSavingBinding.inflate(inflater, container, false)
            return binding.root
        }
    }

    override fun onClick(v: View?) {
        when(v?.id){
            R.id.btn_save_trans -> startActivity(Intent(this, FragmentSavingBinding::class.java))
        }
    }

    private fun Intent(addSaving: addSaving, java: Class<FragmentSavingBinding>): Intent? {
        return null
    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_add_saving, container, false)
    }


}


