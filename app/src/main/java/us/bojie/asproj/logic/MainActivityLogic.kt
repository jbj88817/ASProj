package us.bojie.asproj.logic

import android.content.res.Resources
import android.view.View
import androidx.annotation.IdRes
import androidx.annotation.StringRes
import androidx.fragment.app.FragmentManager
import us.bojie.asproj.R
import us.bojie.asproj.common.tab.HiFragmentTabView
import us.bojie.hi.ui.tab.bottom.HiTabBottomInfo
import us.bojie.hi.ui.tab.bottom.HiTabBottomLayout
import java.util.*

class MainActivityLogic(private val activityProvider: ActivityProvider) {
    private val fragmentTabView: HiFragmentTabView? = null
    private lateinit var hiTabBottomLayout: HiTabBottomLayout
    private lateinit var infoList: List<HiTabBottomInfo<*>>
    private val currentItemIndex = 0

    fun initTabBottom() {
        hiTabBottomLayout = activityProvider.findViewById(R.id.tab_bottom_layout)
        hiTabBottomLayout.setTabAlpha(0.85f)
        infoList = ArrayList()
    }

}

interface ActivityProvider {
    fun <T : View?> findViewById(@IdRes id: Int): T
    val resources: Resources?
    val supportFragmentManager: FragmentManager?
    fun getString(@StringRes resId: Int): String?
}