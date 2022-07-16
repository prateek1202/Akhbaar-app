package com.example.akhbaar

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import com.example.akhbaar.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var toggle:ActionBarDrawerToggle

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        toggle = ActionBarDrawerToggle(this,binding.drawerlayout,R.string.open,R.string.close)
        binding.drawerlayout.addDrawerListener(toggle)
        toggle.syncState()

        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        binding.navView.setNavigationItemSelectedListener {
            when(it.itemId) {
                R.id.item1 -> Toast.makeText(applicationContext,"Clicked Item 1",Toast.LENGTH_SHORT).show()
                R.id.item2 -> Toast.makeText(applicationContext,"Clicked Item 2",Toast.LENGTH_SHORT).show()
                R.id.item3 -> Toast.makeText(applicationContext,"Clicked Item 3",Toast.LENGTH_SHORT).show()
            }
            true
        }
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (toggle.onOptionsItemSelected(item)) {
            return true
        }
        return super.onOptionsItemSelected(item)
    }
}
