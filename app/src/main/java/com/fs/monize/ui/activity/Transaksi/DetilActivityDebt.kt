package com.fs.monize.ui.activity.Transaksi

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.Toast
import com.fs.monize.R
import com.fs.monize.ui.activity.dashboard.DashboardActivity
import com.google.android.material.bottomnavigation.BottomNavigationView

class DetilActivityDebt : AppCompatActivity(),
    BottomNavigationView.OnNavigationItemSelectedListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detil_debt)

        val bottomNavigationView = findViewById<BottomNavigationView>(R.id.navbar)
        bottomNavigationView.setOnNavigationItemSelectedListener(this)
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.dashboard -> run {
                val dashboard = Intent(this, DashboardActivity::class.java)
                startActivity(dashboard)
            }
            R.id.Transaksi -> run {
                val transaksi = Intent(this, DetilActivityDebt::class.java)
                startActivity(transaksi)
            }
            R.id.Simpanan -> {
                Toast.makeText(this, "Simpanan clicked", Toast.LENGTH_SHORT).show()
            }
            R.id.Menabung -> {
                Toast.makeText(this, "Menabung clicked", Toast.LENGTH_SHORT).show()
            }

        }
        return true
    }
}

