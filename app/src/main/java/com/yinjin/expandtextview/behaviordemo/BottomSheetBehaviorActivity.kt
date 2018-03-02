package com.yinjin.expandtextview.behaviordemo

import android.os.Bundle
import android.support.design.widget.BottomSheetBehavior
import android.support.design.widget.BottomSheetDialog
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import kotlinx.android.synthetic.main.activity_bottom_sheet_behavior.*
import kotlinx.android.synthetic.main.layout_recycler.view.*


class BottomSheetBehaviorActivity : AppCompatActivity() {
    var sheetDialog:BottomSheetDialog?=null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_bottom_sheet_behavior)
        setSupportActionBar(toolbar)
        val bottomSheetBehavior = BottomSheetBehavior.from(tab_layout)
        bottomSheetBehavior.peekHeight = 0
        bottomSheetBehavior.skipCollapsed = false
        btn_bottom_sheet_control.setOnClickListener {
            if (bottomSheetBehavior.state == BottomSheetBehavior.STATE_EXPANDED) {
                bottomSheetBehavior.setState(BottomSheetBehavior.STATE_COLLAPSED)
            } else if (bottomSheetBehavior.state == BottomSheetBehavior.STATE_COLLAPSED) {
                bottomSheetBehavior.state = BottomSheetBehavior.STATE_EXPANDED
            }
        }
        btn_bottom_sheet_dialog.setOnClickListener {
            createBottomSheetDialog()
        }
    }

    private fun createBottomSheetDialog() {
        if (sheetDialog == null) {
            sheetDialog = BottomSheetDialog(this)
        }

        val stringList = arrayListOf<String>()
        (0..29).mapTo(stringList) { it.toString() + "" }
        val view = LayoutInflater.from(this).inflate(R.layout.layout_recycler, null)
        view.recycle_view.adapter = object : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
            override fun onBindViewHolder(holder: RecyclerView.ViewHolder?, position: Int) {
                (holder as MyHolder).tvTitle.text = stringList[position]
            }

            override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): RecyclerView.ViewHolder {
                val view = layoutInflater.inflate(R.layout.item_news_list1, parent, false)
                return MyHolder(view)
            }

            override fun getItemCount(): Int = stringList.size
        }
        val manager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        view.recycle_view.layoutManager = manager
        sheetDialog!!.setContentView(view)
        sheetDialog!!.setCancelable(true)
        sheetDialog!!.setCanceledOnTouchOutside(true)
        if (sheetDialog!!.isShowing) {
            sheetDialog!!.dismiss()
        } else {
            sheetDialog!!.show()
        }
    }

}
