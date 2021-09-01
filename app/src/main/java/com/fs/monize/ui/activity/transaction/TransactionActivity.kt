package com.fs.monize.ui.activity.transaction

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.CalendarView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.fs.monize.R
import com.fs.monize.databinding.ActivityTransactionBinding
import com.google.android.material.bottomsheet.BottomSheetDialog
import kotlinx.android.synthetic.main.layout_bottom_calendar.*
import kotlinx.android.synthetic.main.layout_bottom_calendar.view.*
import java.text.SimpleDateFormat
import java.util.*

class TransactionActivity : AppCompatActivity(), View.OnClickListener {
    private lateinit var binding: ActivityTransactionBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTransactionBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setUpData()

        binding.btnIncome.setOnClickListener(this)
        binding.btnSpend.setOnClickListener(this)
        binding.linearDate.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.btn_income -> {
                binding.btnIncome.isSelected = true
                binding.btnSpend.isSelected = false
                Glide.with(this)
                    .load(resources.getDrawable(R.drawable.img_income))
                    .apply(RequestOptions()
                    .override(250, 250))
                    .into(binding.imgTransaction)
            }
            R.id.btn_spend ->{
                binding.btnIncome.isSelected = false
                binding.btnSpend.isSelected = true
                Glide.with(this)
                    .load(resources.getDrawable(R.drawable.img_spend))
                    .apply(RequestOptions()
                    .override(250, 250))
                    .into(binding.imgTransaction)
            }
            R.id.linear_date ->{
                val btnsheet = layoutInflater.inflate(R.layout.layout_bottom_calendar, null)
                val dialog = BottomSheetDialog(this, R.style.BottomSheetDialog)
                dialog.setContentView(btnsheet)
                btnsheet.btn_calendar_apply.setOnClickListener {
                    dialog.dismiss()
                }
                val calendar = btnsheet.findViewById<CalendarView>(R.id.calendar)
                calendar.setOnDateChangeListener{ view, year, month, dayOfMonth ->
                    val tgl = calendar.date
                    val sdf = SimpleDateFormat("dd MMMM yyyy")
                    val currentDate = sdf.format(tgl)
                    binding.txtDate.text = currentDate
                }
                dialog.show()
            }
        }
    }

    private fun setUpData(){
        supportActionBar!!.setTitle(resources.getString(R.string.new_trans))
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)
        binding.btnIncome.isSelected = true
        Glide.with(this)
            .load(resources.getDrawable(R.drawable.img_income))
            .apply(RequestOptions()
                .override(250, 250))
            .into(binding.imgTransaction)
        val sdf = SimpleDateFormat("dd MMMM yyyy")
        val currentDate = sdf.format(Date())
        binding.txtDate.text = currentDate
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }

}