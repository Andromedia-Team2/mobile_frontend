package com.fs.monize.ui.activity.transaction

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.fs.monize.R
import android.widget.FrameLayout
import com.fs.monize.databinding.FragmentAddSavingBinding
import com.fs.monize.databinding.FragmentConfirmDeleteBinding
import com.fs.monize.databinding.FragmentSavingBinding
import com.fs.monize.databinding.FragmentTransactionBinding
import com.fs.monize.ui.activity.dashboard.DashboardActivity
import com.fs.monize.ui.activity.menabung.addSaving


class ConfirmDeleteFragment : Fragment(), View.OnClickListener {
    private lateinit var binding: FragmentConfirmDeleteBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = FragmentConfirmDeleteBinding.inflate(layoutInflater)

        fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                         savedInstanceState: Bundle?): View? {
            binding = FragmentConfirmDeleteBinding.inflate(inflater, container, false)
            return binding.root
        }
    }

    override fun onClick(v: View?) {
        when(v?.id){

            R.id.hapus -> startActivity(Intent(this, FragmentTransactionBinding::class.java))
        }
    }

    private fun Intent(confirmDeleteFragment: ConfirmDeleteFragment, java: Class<FragmentTransactionBinding>): Intent? {
        return null
    }




    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_confirm_delete, container, false)
    }


}


