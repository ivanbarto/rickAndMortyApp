package com.ivanbarto.viewModelPractice.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.ui.NavigationUI
import com.ivanbarto.viewModelPractice.R
import java.security.AccessController

class MainActivity : AppCompatActivity() {

    private lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //find and setup navController for this activity
        navController = findNavController(R.id.nav_host_fragment)
        NavigationUI.setupActionBarWithNavController(this,navController)
    }


    //this is for setup the back arrow in toolbar, depending on the nav graph
    override fun onSupportNavigateUp(): Boolean {
        return navController.navigateUp()
    }
}