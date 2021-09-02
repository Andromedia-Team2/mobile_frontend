package com.fs.monize.ui.activity.profile

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.fs.monize.R
import com.fs.monize.databinding.ActivityProfileBinding
import com.fs.monize.ui.activity.dashboard.DashboardActivity

class ProfileActivity : AppCompatActivity(), View.OnClickListener{
    private lateinit var binding: ActivityProfileBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityProfileBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnSaveTrans.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        when(v?.id){
            R.id.btn_save_trans -> startActivity(Intent(this, DashboardActivity::class.java))
        }
    }
}
