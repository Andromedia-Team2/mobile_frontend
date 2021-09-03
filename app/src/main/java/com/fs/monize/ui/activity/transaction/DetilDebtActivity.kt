package com.fs.monize.ui.activity.transaction

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.fs.monize.R
import com.fs.monize.databinding.ActivityDetilDebtBinding
import com.fs.monize.ui.activity.dashboard.DashboardActivity

class DetilDebtActivity : AppCompatActivity(), View.OnClickListener {
    private lateinit var binding: ActivityDetilDebtBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetilDebtBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.deleteTrans.setOnClickListener(this)

    }

    override fun onClick(v: View?) {
        when(v?.id){
            R.id.dateTrans -> startActivity(Intent(this, DashboardActivity::class.java))
        }
    }
}