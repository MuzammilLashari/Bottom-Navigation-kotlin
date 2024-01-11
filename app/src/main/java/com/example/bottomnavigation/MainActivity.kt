package com.example.bottomnavigation

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.bottomnavigation.databinding.ActivityMainBinding
import com.example.bottomnavigation.ContactFragment
import com.example.bottomnavigation.HomeFragment
import com.example.bottomnavigation.SettingsFragment

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        replaceFragment(HomeFragment())

        binding.bottomNavigationView.setOnItemSelectedListener {

            when (it.itemId) {

                R.id.homeBtn -> replaceFragment(HomeFragment())
                R.id.personBtn -> replaceFragment(ContactFragment())
                R.id.settingBtn -> replaceFragment(SettingsFragment())

                else -> {}
            }
            true
        }

    }

    private fun replaceFragment(fragment: Fragment) {

        val fragManager = supportFragmentManager
        val fragmentTransacation = fragManager.beginTransaction()
        fragmentTransacation.replace(R.id.frameLayout, fragment)
        fragmentTransacation.commit()

    }
}