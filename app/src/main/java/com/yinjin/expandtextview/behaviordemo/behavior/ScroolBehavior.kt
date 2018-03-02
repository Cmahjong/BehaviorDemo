package com.yinjin.expandtextview.behaviordemo.behavior

import android.content.Context
import android.support.design.widget.CoordinatorLayout
import android.support.v4.view.ViewCompat
import android.support.v4.widget.NestedScrollView
import android.util.AttributeSet
import android.util.Log
import android.view.View

/**
 * desc:ScroolBehavior
 * time: 2018/3/2
 * @author yinYin
 */
class ScroolBehavior : CoordinatorLayout.Behavior<View> {
    constructor():super()
    constructor(context: Context,attributeSet: AttributeSet):super(context,attributeSet)

    override fun onStartNestedScroll(coordinatorLayout: CoordinatorLayout, child: View, directTargetChild: View, target: View, axes: Int, type: Int): Boolean {
        return (axes and ViewCompat.SCROLL_AXIS_VERTICAL) !== 0
    }

    override fun onNestedPreScroll(coordinatorLayout: CoordinatorLayout, child: View, target: View, dx: Int, dy: Int, consumed: IntArray, type: Int) {
        Log.e(dx.toString()+"....",dy.toString())
        super.onNestedPreScroll(coordinatorLayout, child, target, dx, dy, consumed, type)
        child.scrollY = target.scrollY
    }

    override fun onNestedPreFling(coordinatorLayout: CoordinatorLayout, child: View, target: View, velocityX: Float, velocityY: Float): Boolean {
        (child as NestedScrollView).fling(velocityY.toInt())
        return true
    }
}