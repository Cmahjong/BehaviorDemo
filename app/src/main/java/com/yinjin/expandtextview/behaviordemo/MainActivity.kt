package com.yinjin.expandtextview.behaviordemo

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        dependence.setOnClickListener {
            startActivity(Intent(this,DependentBehaviorActivity::class.java))
        }
        scrollview.setOnClickListener {
            startActivity(Intent(this,ScrollBehaviorActivity::class.java))
        }
        bottomSheetBehavior.setOnClickListener {
            startActivity(Intent(this,BottomSheetBehaviorActivity::class.java))
        }
    }
}
