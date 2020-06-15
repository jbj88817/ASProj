package us.bojie.asproj.common.tab

import android.content.Context
import android.util.AttributeSet
import android.widget.FrameLayout
import androidx.fragment.app.Fragment

class HiFragmentTabView(
    context: Context,
    attrs: AttributeSet? = null
) : FrameLayout(context, attrs) {

    var mAdapter: HiTabViewAdapter? = null
        set(value) {
            if (field != null || value == null) {
                return
            }
            field = value
        }
    var mCurrentPosition: Int = -1
        set(value) {
            if (value < 0 || value >= mAdapter?.getCount() ?: 0) {
                return
            }
            if (field != value) {
                field = value
                mAdapter?.instantiateItem(this, value)
            }
        }

    fun getCurrentFragment(): Fragment? {
        if (mAdapter == null) {
            throw IllegalArgumentException("please call setAdapter first.")
        }
        return mAdapter!!.mCurFragment
    }
}