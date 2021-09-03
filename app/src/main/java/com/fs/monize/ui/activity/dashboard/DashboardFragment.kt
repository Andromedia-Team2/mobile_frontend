package com.fs.monize.ui.activity.dashboard

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.fs.monize.R
import com.fs.monize.databinding.FragmentDashboardBinding
import com.fs.monize.ui.viewmodel.MainViewModel
import com.fs.monize.ui.viewmodel.ViewModelFactory
import com.github.mikephil.charting.data.Entry
import com.github.mikephil.charting.data.LineData
import com.github.mikephil.charting.data.LineDataSet
import com.github.mikephil.charting.interfaces.datasets.ILineDataSet
import java.security.KeyStore

class DashboardFragment : Fragment() {
    private lateinit var binding: FragmentDashboardBinding
    private lateinit var mainViewModel: MainViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentDashboardBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setUpData()
    }

    private fun setUpData(){
        val factory = ViewModelFactory.getInstance(activity!!.application)
        mainViewModel = ViewModelProvider(this, factory).get(MainViewModel::class.java)
        mainViewModel.getFund().observe(this, Observer { listFund ->
            if (listFund.size != 0){
                binding.txtSaldoDash.text = "Rp. " + listFund[0].fund_balance.toString()+ ".-"
                binding.txtDebit.text = "Rp. " + listFund[0].debit_balance.toString()
                binding.txtCredit.text = "Rp. " + listFund[0].credit_balance.toString()
            }else{
                binding.txtSaldoDash.text = "Rp. 0.-"
                binding.txtDebit.text = "Rp. 0"
                binding.txtCredit.text = "Rp. 0"
            }
        })

        setLine()
    }

    fun setLine() {
        val xvalue = ArrayList<String>()
        xvalue.add("")

        val lineEntry = ArrayList<Entry>();
        lineEntry.add(Entry(1f, 13f))
        lineEntry.add(Entry(2f, 22f))
        lineEntry.add(Entry(3f, 15f))
        val lineEntry1 = ArrayList<Entry>();
        lineEntry1.add(Entry(1f, 14f))
        lineEntry1.add(Entry(2f, 23f))
        lineEntry1.add(Entry(3f, 13f))

        val lineDataSet = LineDataSet(lineEntry, "First")
        lineDataSet.setDrawCircles(false)
        lineDataSet.color = resources.getColor(R.color.green)
        val lineDataSet1 = LineDataSet(lineEntry1, "Seccond")
        lineDataSet1.setDrawCircles(false)
        lineDataSet1.color = resources.getColor(R.color.red)
        val iLineDataSet = ArrayList<ILineDataSet>()
        iLineDataSet.add(lineDataSet)
        iLineDataSet.add(lineDataSet1)

        val lineData = LineData(iLineDataSet)
        binding.Linechart.data = lineData
        binding.Linechart.invalidate()
        binding.Linechart.setNoDataText("Tidak ada data transaksi")



    }
}