package com.example.lobutuscodingtest.ui


import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.example.lobutuscodingtest.R
import com.example.lobutuscodingtest.databinding.ActivityHomeBinding
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.internal.ContextUtils.getActivity


class HomeActivity : AppCompatActivity() {

    private lateinit var binding: ActivityHomeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)




        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

//        mToolbar = mFragmentView.findViewById(com.example.lobutuscodingtest.R.id.toolbar) as Toolbar
//        (getActivity() as ActionBarActivity).setSupportActionBar(mToolbar)

        setSupportActionBar(binding.toolbar)

        val navView: BottomNavigationView = binding.navView

        val navController = findNavController(com.example.lobutuscodingtest.R.id.nav_host_fragment_activity_home)
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        val appBarConfiguration = AppBarConfiguration(
            setOf(
                com.example.lobutuscodingtest.R.id.navigation_home, com.example.lobutuscodingtest.R.id.navigation_dashboard, com.example.lobutuscodingtest.R.id.navigation_notifications
            )
        )
        setupActionBarWithNavController(navController, appBarConfiguration)
        navView.setupWithNavController(navController)
    }
}