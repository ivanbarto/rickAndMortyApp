package com.ivanbarto.viewModelPractice.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.ui.NavigationUI
import com.ivanbarto.viewModelPractice.R
import com.ivanbarto.viewModelPractice.databinding.ActivityMainBinding
import java.security.AccessController

class MainActivity : AppCompatActivity() {

    private lateinit var navController: NavController
    private lateinit var binding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        //find and setup navController for this activity
        navController = findNavController(R.id.nav_host_fragment)
        NavigationUI.setupActionBarWithNavController(this,navController)
    }


    //this is for setup the back arrow in toolbar, depending on the nav graph
    override fun onSupportNavigateUp(): Boolean {
        return navController.navigateUp()
    }
}