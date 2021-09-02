package com.fs.monize.ui.activity.dashboard

import android.content.Intent
import android.os.Bundle
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.fs.monize.R
import com.fs.monize.databinding.ActivityDashboardBinding
import com.fs.monize.ui.activity.signin.SignInActivity
import com.google.android.material.bottomnavigation.BottomNavigationView

class DashboardActivity : AppCompatActivity(), BottomNavigationView.OnNavigationItemSelectedListener {
    private lateinit var binding: ActivityDashboardBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDashboardBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportFragmentManager.beginTransaction().replace(R.id.fragment_container, TransactionFragment()).commit()
        binding.navbar.setOnNavigationItemSelectedListener(this)
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        var frag: Fragment = TransactionFragment()
        when (item.itemId) {
            R.id.dashboard -> frag = DashboardFragment()
            R.id.Transaksi -> frag = TransactionFragment()
            R.id.Simpanan -> frag = AssetsFragment()
            R.id.Menabung -> frag = SavingFragment()
        }
        supportFragmentManager.beginTransaction().replace(R.id.fragment_container, frag!!).commit()
        return true
    }
}
