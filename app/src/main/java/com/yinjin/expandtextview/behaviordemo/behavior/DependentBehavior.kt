package com.yinjin.expandtextview.behaviordemo.behavior

import android.content.Context
import android.support.design.widget.CoordinatorLayout
import android.support.v4.view.ViewCompat
import android.util.AttributeSet
import android.view.View
import android.widget.TextView

/**
 * desc:DependentBehavior
 * time: 2018/3/2
 * @author yinYin
 */
class DependentBehavior : CoordinatorLayout.Behavior<View> {
    constructor():super()
    constructor(context: Context, attrs: AttributeSet) : super(context, attrs)

    override fun layoutDependsOn(parent: CoordinatorLayout?, child: View?, dependency: View?): Boolean {
        return dependency is TextView
    }

    override fun onDependentViewChanged(parent: CoordinatorLayout?, child: View?, dependency: View?): Boolean {
      val offset= dependency?.top!! - child?.top!!
        ViewCompat.offsetTopAndBottom(child,offset)
        return true
    }
}