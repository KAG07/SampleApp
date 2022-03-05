package com.example.sampleapp

import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import androidx.navigation.Navigation
import androidx.navigation.ui.NavigationUI
import androidx.navigation.ui.setupWithNavController
import com.example.sampleapp.fragment.GalleryFragment
import com.example.sampleapp.fragment.HomeFragment
import com.example.sampleapp.fragment.SlideshowFragment
import com.google.android.material.navigation.NavigationView
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity(),NavigationView.OnNavigationItemSelectedListener {

    lateinit var drawer:DrawerLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setSupportActionBar(toolbar)

        drawer=findViewById(R.id.drawer)

        var toggle=ActionBarDrawerToggle(this,drawer,toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close)
        drawer.addDrawerListener(toggle)
        toggle.syncState()

        nav_view.setNavigationItemSelectedListener(this)

        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction().replace(R.id.fragment_container,
                HomeFragment()).commit()
            nav_view.setCheckedItem(R.id.homeFragment)
            supportActionBar!!.title="Home"
        }
    }


    override fun onBackPressed() {
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START)
        } else {
            super.onBackPressed()
        }
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.galleryFragment->{
                supportActionBar!!.title="Gallery"
                supportFragmentManager.beginTransaction().replace(R.id.fragment_container,GalleryFragment()).commit()
                //navController.navigate(R.id.action_homeFragment_to_galleryFragment)
            }
            R.id.SlideshowFragment->{
                supportActionBar!!.title="SlideShow"
                supportFragmentManager.beginTransaction().replace(R.id.fragment_container,SlideshowFragment()).commit()
               // navController.navigate(R.id.action_homeFragment_to_slideshowFragment)
            }
            R.id.homeFragment->{
                supportActionBar!!.title="Home"
                supportFragmentManager.beginTransaction().replace(R.id.fragment_container,HomeFragment()).commit()
            }
        }
        drawer.closeDrawer(GravityCompat.START)
        return true
    }
}