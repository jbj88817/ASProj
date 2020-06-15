package us.bojie.asproj.common.tab

import android.content.Context
import android.util.AttributeSet
import android.widget.FrameLayout
import androidx.fragment.app.Fragment

class HiFragmentTabView(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0,
    defStyleRes: Int = 0
) : FrameLayout(context, attrs, defStyleAttr, defStyleRes) {


    var mAdapter: HiTabViewAdapter? = null
        set(value) {
            if (field != null || value == null) {
                return
            }
            field = value
            mCurrentPosition = -1
        }
    var mCurrentPosition: Int = 0
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