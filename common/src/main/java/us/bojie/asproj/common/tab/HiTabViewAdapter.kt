package us.bojie.asproj.common.tab

import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import us.bojie.hi.ui.tab.bottom.HiTabBottomInfo

class HiTabViewAdapter(
    private val mFragmentManager: FragmentManager,
    private val mInfoList: List<HiTabBottomInfo<*>>
) {
    var mCurFragment: Fragment? = null
        private set

    fun instantiateItem(container: View, position: Int) {
        val mCurTransaction =
            mFragmentManager.beginTransaction()
        mCurFragment?.let {
            mCurTransaction.hide(it)
        }

        val name = "${container.id} : $position"
        var fragment = mFragmentManager.findFragmentByTag(name)
        fragment?.let {
            mCurTransaction.show(it)
        } ?: let {
            fragment = getItem(position)
            if (!fragment!!.isAdded) {
                mCurTransaction.add(container.id, fragment!!, name)
            }
        }

        mCurFragment = fragment
        mCurTransaction.commitAllowingStateLoss()
    }

    fun getItem(position: Int): Fragment {
        return mInfoList[position].fragment.newInstance()
    }

    fun getCount(): Int = mInfoList.size

}