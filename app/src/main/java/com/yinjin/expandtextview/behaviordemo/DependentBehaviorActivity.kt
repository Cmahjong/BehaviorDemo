package com.yinjin.expandtextview.behaviordemo

import android.os.Bundle
import android.support.v4.view.ViewCompat
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_dependnt_behavior.*

class DependentBehaviorActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dependnt_behavior)
        textView1.setOnClickListener {
            ViewCompat.offsetTopAndBottom(it, 5)
        }
    }

}
