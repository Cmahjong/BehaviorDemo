package com.yinjin.expandtextview.behaviordemo

import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.TextView
import kotlinx.android.synthetic.main.item_news_list1.view.*


/**
 * desc:
 * time: 2018/3/2
 * @author yinYin
 */
class MyHolder:RecyclerView.ViewHolder{
    val tvTitle:TextView
    constructor(view:View):super(view){
        tvTitle =view.tv_content
    }
}