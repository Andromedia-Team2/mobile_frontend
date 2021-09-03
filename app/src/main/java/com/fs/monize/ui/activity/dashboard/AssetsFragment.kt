package com.fs.monize.ui.activity.dashboard

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.fs.monize.R
import com.fs.monize.databinding.FragmentAssetsBinding
import com.fs.monize.ui.viewmodel.MainViewModel
import com.fs.monize.ui.viewmodel.ViewModelFactory
import kotlinx.android.synthetic.main.fragment_assets.*

class AssetsFragment : Fragment() {
    private lateinit var binding: FragmentAssetsBinding
    private lateinit var mainViewModel: MainViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        binding = FragmentAssetsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setUpData()
    }

    private fun setUpData(){
        val factory = ViewModelFactory.getInstance(activity!!.application)
        mainViewModel = ViewModelProvider(this, factory).get(MainViewModel::class.java)
        mainViewModel.getAsset().observe(this, Observer { listAsset ->
            if (listAsset.size != 0) {
                binding.namaDarurat.text = listAsset[0].asset_name
                binding.descDarurat.text = listAsset[0].asset_desc
                binding.nominalDarurat.text = listAsset[0].asset_balance.toString()
                binding.namaAsuransi.text = listAsset[1].asset_name
                binding.descAsuransi.text = listAsset[1].asset_desc
                binding.nominalAsuransi.text = listAsset[1].asset_balance.toString()
                binding.namaAsset.text = listAsset[2].asset_name
                binding.descAsset.text = listAsset[2].asset_desc
                binding.nominalAsset.text = listAsset[2].asset_balance.toString()
            }
        })
    }
}