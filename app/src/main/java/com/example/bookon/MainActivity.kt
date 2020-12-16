package com.example.bookon

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.ImageButton
import android.widget.Toast
import androidx.viewpager.widget.ViewPager
import com.example.bookon.adapter.PagerViewAdapter
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.activity_login.*
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    val TAG = "Activity"
    private lateinit var homeIcon: ImageButton
    private lateinit var historyIcon: ImageButton
    private lateinit var profileIcon: ImageButton

    private lateinit var mViewPager: ViewPager
    private lateinit var mPagerViewAdapter: PagerViewAdapter


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //init views
        mViewPager = findViewById(R.id.mViewPager)

        //init image buttons
        homeIcon = findViewById(R.id.homeIcon)
        historyIcon = findViewById(R.id.historyIcon)
        profileIcon = findViewById(R.id.profileIcon)

        //onclick listener
        homeIcon.setOnClickListener {
            mViewPager.currentItem = 0
        }
        historyIcon.setOnClickListener {
            mViewPager.currentItem = 1
        }
        profileIcon.setOnClickListener {
            mViewPager.currentItem = 2
        }

        mPagerViewAdapter = PagerViewAdapter(supportFragmentManager)
        mViewPager.adapter = mPagerViewAdapter
        mViewPager.offscreenPageLimit = 3

        //add page change listener
        mViewPager.addOnPageChangeListener(object : ViewPager.OnPageChangeListener {
            override fun onPageScrollStateChanged(state: Int) {
            }

            override fun onPageScrolled(
                    position: Int,
                    positionOffset: Float,
                    positionOffsetPixels: Int
            ) {
            }

            override fun onPageSelected(position: Int) {
                changingTabs(position)
            }
        })

        //default tab
        mViewPager.currentItem = 0
        homeIcon.setImageResource(R.drawable.ic_baseline_home)
    }

    private fun changingTabs(position: Int) {
        if (position == 0) {
            homeIcon.setImageResource(R.drawable.ic_baseline_home)
            historyIcon.setImageResource(R.drawable.ic_baseline_history_24)
            profileIcon.setImageResource(R.drawable.ic_baseline_person_24)
        }
        if (position == 1) {
            homeIcon.setImageResource(R.drawable.ic_baseline_home_24)
            historyIcon.setImageResource(R.drawable.ic_baseline_history)
            profileIcon.setImageResource(R.drawable.ic_baseline_person_24)
        }
        if (position == 2) {
            homeIcon.setImageResource(R.drawable.ic_baseline_home_24)
            historyIcon.setImageResource(R.drawable.ic_baseline_history_24)
            profileIcon.setImageResource(R.drawable.ic_baseline_person)
        }
    }

    fun logout(view: View) {
        FirebaseAuth.getInstance().signOut();
        val intent = Intent(this, Login::class.java)
        startActivity(intent)
        finish()
    }

    fun openForm(view: View) {
        val intent = Intent(this, BookingActivity::class.java)
        startActivity(intent)
    }

    override fun onStart(){
        super.onStart()
        Toast.makeText(getApplicationContext(),"onStart", Toast.LENGTH_SHORT).show();
        Log.d(TAG,"onStart")
    }
    override fun onResume(){
        super.onResume()
        Toast.makeText(getApplicationContext(),"onResume", Toast.LENGTH_SHORT).show();
        Log.d(TAG,"onResume")
    }

    override fun onPause() {
        super.onPause()
        Toast.makeText(getApplicationContext(),"onPause", Toast.LENGTH_SHORT).show();
        Log.d(TAG,"onPause")
    }

    override fun onStop() {
        super.onStop()
        Toast.makeText(getApplicationContext(),"onStop", Toast.LENGTH_SHORT).show();
        Log.d(TAG,"onStop")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d(TAG,"onDestroy")
        Toast.makeText(getApplicationContext(),"onDestroy", Toast.LENGTH_SHORT).show()
    }
}