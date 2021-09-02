package com.fs.monize.ui.activity.transaction

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.lifecycle.Observer
import android.widget.CalendarView
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.fs.monize.R
import com.fs.monize.databinding.ActivityTransactionBinding
import com.fs.monize.repo.source.local.entity.FundEntity
import com.fs.monize.repo.source.local.entity.TransactionEntity
import com.fs.monize.ui.activity.dashboard.DashboardActivity
import com.fs.monize.ui.viewmodel.MainViewModel
import com.fs.monize.ui.viewmodel.ViewModelFactory
import com.google.android.material.bottomsheet.BottomSheetDialog
import kotlinx.android.synthetic.main.layout_bottom_calendar.*
import kotlinx.android.synthetic.main.layout_bottom_calendar.view.*
import kotlinx.android.synthetic.main.layout_bottom_icon.view.*
import java.text.SimpleDateFormat
import java.util.*

class TransactionActivity : AppCompatActivity(), View.OnClickListener {
    private lateinit var binding: ActivityTransactionBinding
    private lateinit var mainViewModel: MainViewModel
    private lateinit var transactionEntity: TransactionEntity
    private lateinit var fundEntity: FundEntity
    private lateinit var listFund: List<FundEntity>
    private var category = "income"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTransactionBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setUpData()

        binding.btnIncome.setOnClickListener(this)
        binding.btnSpend.setOnClickListener(this)
        binding.linearDate.setOnClickListener(this)
        binding.txtIcon.setOnClickListener(this)
        binding.btnSaveTrans.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.btn_income -> {
                category = "income"
                binding.btnIncome.isSelected = true
                binding.btnSpend.isSelected = false
                Glide.with(this)
                    .load(resources.getDrawable(R.drawable.img_income))
                    .apply(RequestOptions()
                    .override(250, 250))
                    .into(binding.imgTransaction)
            }
            R.id.btn_spend ->{
                category = "spend"
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
                val formatter = SimpleDateFormat("dd/MM/yyyy")
                val sdf = SimpleDateFormat("dd MMMM yyyy")
                var currentDate = sdf.format(Date())
                dialog.setContentView(btnsheet)
                btnsheet.calendar.setOnDateChangeListener{ view, year, month, dayOfMonth ->
                    val bln = month+1
                    val tgl = dayOfMonth.toString()+"/"+bln.toString()+"/"+year.toString()
                    val date = formatter.parse(tgl)
                    currentDate = sdf.format(date)
                }
                btnsheet.btn_calendar_apply.setOnClickListener {
                    binding.txtDate.text = currentDate
                    dialog.dismiss()
                }
                dialog.show()
            }
            R.id.txt_icon ->{
                var icon_name = "ikon_pin"
                val btnsheetIcon = layoutInflater.inflate(R.layout.layout_bottom_icon, null)
                val dialogIcon = BottomSheetDialog(this, R.style.BottomSheetDialog)
                dialogIcon.setContentView(btnsheetIcon)
                btnsheetIcon.icon_call.setOnClickListener {
                    icon_name = "ikon_call"
                    btnsheetIcon.icon_call.isSelected = true
                    btnsheetIcon.icon_tools.isSelected = false
                    btnsheetIcon.icon_music.isSelected = false
                    btnsheetIcon.icon_car.isSelected = false
                    btnsheetIcon.icon_movie.isSelected = false
                    btnsheetIcon.icon_chart.isSelected = false
                    btnsheetIcon.icon_electric.isSelected = false
                    btnsheetIcon.icon_phone.isSelected = false
                    btnsheetIcon.icon_computer.isSelected = false
                    btnsheetIcon.icon_camera.isSelected = false
                }
                btnsheetIcon.icon_tools.setOnClickListener {
                    icon_name = "ikon_tools"
                    btnsheetIcon.icon_call.isSelected = false
                    btnsheetIcon.icon_tools.isSelected = true
                    btnsheetIcon.icon_music.isSelected = false
                    btnsheetIcon.icon_car.isSelected = false
                    btnsheetIcon.icon_movie.isSelected = false
                    btnsheetIcon.icon_chart.isSelected = false
                    btnsheetIcon.icon_electric.isSelected = false
                    btnsheetIcon.icon_phone.isSelected = false
                    btnsheetIcon.icon_computer.isSelected = false
                    btnsheetIcon.icon_camera.isSelected = false
                }
                btnsheetIcon.icon_music.setOnClickListener {
                    icon_name = "ikon_music"
                    btnsheetIcon.icon_call.isSelected = false
                    btnsheetIcon.icon_tools.isSelected = false
                    btnsheetIcon.icon_music.isSelected = true
                    btnsheetIcon.icon_car.isSelected = false
                    btnsheetIcon.icon_movie.isSelected = false
                    btnsheetIcon.icon_chart.isSelected = false
                    btnsheetIcon.icon_electric.isSelected = false
                    btnsheetIcon.icon_phone.isSelected = false
                    btnsheetIcon.icon_computer.isSelected = false
                    btnsheetIcon.icon_camera.isSelected = false
                }
                btnsheetIcon.icon_car.setOnClickListener {
                    icon_name = "ikon_car"
                    btnsheetIcon.icon_call.isSelected = false
                    btnsheetIcon.icon_tools.isSelected = false
                    btnsheetIcon.icon_music.isSelected = false
                    btnsheetIcon.icon_car.isSelected = true
                    btnsheetIcon.icon_movie.isSelected = false
                    btnsheetIcon.icon_chart.isSelected = false
                    btnsheetIcon.icon_electric.isSelected = false
                    btnsheetIcon.icon_phone.isSelected = false
                    btnsheetIcon.icon_computer.isSelected = false
                    btnsheetIcon.icon_camera.isSelected = false
                }
                btnsheetIcon.icon_movie.setOnClickListener {
                    icon_name = "ikon_movie"
                    btnsheetIcon.icon_call.isSelected = false
                    btnsheetIcon.icon_tools.isSelected = false
                    btnsheetIcon.icon_music.isSelected = false
                    btnsheetIcon.icon_car.isSelected = false
                    btnsheetIcon.icon_movie.isSelected = true
                    btnsheetIcon.icon_chart.isSelected = false
                    btnsheetIcon.icon_electric.isSelected = false
                    btnsheetIcon.icon_phone.isSelected = false
                    btnsheetIcon.icon_computer.isSelected = false
                    btnsheetIcon.icon_camera.isSelected = false
                }
                btnsheetIcon.icon_chart.setOnClickListener {
                    icon_name = "ikon_chart"
                    btnsheetIcon.icon_call.isSelected = false
                    btnsheetIcon.icon_tools.isSelected = false
                    btnsheetIcon.icon_music.isSelected = false
                    btnsheetIcon.icon_car.isSelected = false
                    btnsheetIcon.icon_movie.isSelected = false
                    btnsheetIcon.icon_chart.isSelected = true
                    btnsheetIcon.icon_electric.isSelected = false
                    btnsheetIcon.icon_phone.isSelected = false
                    btnsheetIcon.icon_computer.isSelected = false
                    btnsheetIcon.icon_camera.isSelected = false
                }
                btnsheetIcon.icon_electric.setOnClickListener {
                    icon_name = "ikon_electric"
                    btnsheetIcon.icon_call.isSelected = false
                    btnsheetIcon.icon_tools.isSelected = false
                    btnsheetIcon.icon_music.isSelected = false
                    btnsheetIcon.icon_car.isSelected = false
                    btnsheetIcon.icon_movie.isSelected = false
                    btnsheetIcon.icon_chart.isSelected = false
                    btnsheetIcon.icon_electric.isSelected = true
                    btnsheetIcon.icon_phone.isSelected = false
                    btnsheetIcon.icon_computer.isSelected = false
                    btnsheetIcon.icon_camera.isSelected = false
                }
                btnsheetIcon.icon_phone.setOnClickListener {
                    icon_name = "ikon_phone"
                    btnsheetIcon.icon_call.isSelected = false
                    btnsheetIcon.icon_tools.isSelected = false
                    btnsheetIcon.icon_music.isSelected = false
                    btnsheetIcon.icon_car.isSelected = false
                    btnsheetIcon.icon_movie.isSelected = false
                    btnsheetIcon.icon_chart.isSelected = false
                    btnsheetIcon.icon_electric.isSelected = false
                    btnsheetIcon.icon_phone.isSelected = true
                    btnsheetIcon.icon_computer.isSelected = false
                    btnsheetIcon.icon_camera.isSelected = false
                }
                btnsheetIcon.icon_computer.setOnClickListener {
                    icon_name = "ikon_computer"
                    btnsheetIcon.icon_call.isSelected = false
                    btnsheetIcon.icon_tools.isSelected = false
                    btnsheetIcon.icon_music.isSelected = false
                    btnsheetIcon.icon_car.isSelected = false
                    btnsheetIcon.icon_movie.isSelected = false
                    btnsheetIcon.icon_chart.isSelected = false
                    btnsheetIcon.icon_electric.isSelected = false
                    btnsheetIcon.icon_phone.isSelected = false
                    btnsheetIcon.icon_computer.isSelected = true
                    btnsheetIcon.icon_camera.isSelected = false
                }
                btnsheetIcon.icon_camera.setOnClickListener {
                    icon_name = "ikon_camera"
                    btnsheetIcon.icon_call.isSelected = false
                    btnsheetIcon.icon_tools.isSelected = false
                    btnsheetIcon.icon_music.isSelected = false
                    btnsheetIcon.icon_car.isSelected = false
                    btnsheetIcon.icon_movie.isSelected = false
                    btnsheetIcon.icon_chart.isSelected = false
                    btnsheetIcon.icon_electric.isSelected = false
                    btnsheetIcon.icon_phone.isSelected = false
                    btnsheetIcon.icon_computer.isSelected = false
                    btnsheetIcon.icon_camera.isSelected = true
                }
                btnsheetIcon.btn_icon_apply.setOnClickListener {
                    binding.txtIcon.text = icon_name
                    dialogIcon.dismiss()
                }
                dialogIcon.show()
            }
            R.id.btn_save_trans -> saveData()
            R.id.btn_save_trans -> startActivity(Intent(this,DashboardActivity::class.java))
        }
    }

    private fun setUpData(){
        val factory = ViewModelFactory.getInstance(this)
        mainViewModel = ViewModelProvider(this, factory).get(MainViewModel::class.java)

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

        fetchFund()
    }

    private fun fetchFund(){
        mainViewModel.getFund().observe(this, Observer { list_fund ->
            listFund = list_fund
        })
    }

    private fun saveData(){
        val nominal: Int = Integer.parseInt(binding.nominalInput.text.toString())
        val name = binding.nameInput.text.toString()
        val desc = binding.descInput.text.toString()
        val date = binding.txtDate.text.toString()
        val icon = binding.txtIcon.text.toString()
        val id = (0..9999).random()

        if (listFund.size != 0) {
            if (category == "income"){
                val balance = listFund[0].fund_balance + nominal
                val debit = listFund[0].debit_balance + nominal
                fundEntity = FundEntity(0, balance, listFund[0].credit_balance, debit)
            }else{
                val balance = listFund[0].fund_balance - nominal
                val credit = listFund[0].credit_balance + nominal
                fundEntity = FundEntity(0, balance, credit, listFund[0].debit_balance)
            }
        } else {
            if (category == "income"){
                fundEntity = FundEntity(0, nominal, 0, nominal)
            }else{
                Toast.makeText(this, "Anda belum memasukkan saldo anda", Toast.LENGTH_SHORT).show()
            }
        }

        transactionEntity = TransactionEntity(id, name, nominal, desc, date, icon, category )
        mainViewModel.insertFund(fundEntity)
        mainViewModel.insertTransaction(transactionEntity)
        success()
    }

    private fun success(){
        Toast.makeText(this, "Data Disimpan", Toast.LENGTH_SHORT).show()
        startActivity(Intent(this, DashboardActivity::class.java))
        finish()
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }

}