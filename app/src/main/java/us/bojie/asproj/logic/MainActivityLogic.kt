package us.bojie.asproj.logic

import android.content.res.Resources
import android.view.View
import androidx.annotation.IdRes
import androidx.annotation.StringRes
import androidx.fragment.app.FragmentManager
import us.bojie.asproj.R
import us.bojie.asproj.common.tab.HiFragmentTabView
import us.bojie.asproj.common.tab.HiTabViewAdapter
import us.bojie.asproj.fragment.*
import us.bojie.hi.ui.tab.bottom.HiTabBottomInfo
import us.bojie.hi.ui.tab.bottom.HiTabBottomLayout

class MainActivityLogic(private val activityProvider: ActivityProvider) {
    lateinit var fragmentTabView: HiFragmentTabView
        private set
    lateinit var hiTabBottomLayout: HiTabBottomLayout
        private set
    lateinit var infoList: List<HiTabBottomInfo<*>>
        private set
    private val currentItemIndex = 0

    init {
        initTabBottom()
    }

    private fun initTabBottom() {
        hiTabBottomLayout = activityProvider.findViewById(R.id.tab_bottom_layout)
        hiTabBottomLayout.setTabAlpha(0.85f)
        val defaultColor: Int =
            activityProvider.getResources()!!.getColor(R.color.tabBottomDefaultColor)
        val tintColor: Int = activityProvider.getResources()!!.getColor(R.color.tabBottomTintColor)
        val homeInfo = HiTabBottomInfo(
            "首页",
            "fonts/iconfont.ttf",
            activityProvider.getString(R.string.if_home),
            null,
            defaultColor,
            tintColor
        )
        homeInfo.fragment = HomePageFragment::class.java
        val infoFavorite = HiTabBottomInfo(
            "收藏",
            "fonts/iconfont.ttf",
            activityProvider.getString(R.string.if_favorite),
            null,
            defaultColor,
            tintColor
        )
        infoFavorite.fragment = FavoriteFragment::class.java
        val infoCategory = HiTabBottomInfo(
            "分类",
            "fonts/iconfont.ttf",
            activityProvider.getString(R.string.if_category),
            null,
            defaultColor,
            tintColor
        )
        infoCategory.fragment = CategoryFragment::class.java
        val infoRecommend = HiTabBottomInfo(
            "推荐",
            "fonts/iconfont.ttf",
            activityProvider.getString(R.string.if_recommend),
            null,
            defaultColor,
            tintColor
        )
        infoRecommend.fragment = RecommendFragment::class.java
        val infoProfile = HiTabBottomInfo(
            "我的",
            "fonts/iconfont.ttf",
            activityProvider.getString(R.string.if_profile),
            null,
            defaultColor,
            tintColor
        )
        infoProfile.fragment = ProfileFragment::class.java
        infoList = arrayListOf(homeInfo, infoFavorite, infoCategory, infoRecommend, infoProfile)
        initFragmentTabView()
        hiTabBottomLayout.apply {
            inflateInfo(infoList)
            addTabSelectedChangeListener { index, prevInfo, nextInfo ->
                fragmentTabView.mCurrentPosition = index
            }
            defaultSelected(homeInfo)
        }
    }

    private fun initFragmentTabView() {
        val adapter =
            activityProvider.getSupportFragmentManager()?.let { HiTabViewAdapter(it, infoList) }
        fragmentTabView = activityProvider.findViewById(R.id.fragment_tab_view)
        fragmentTabView.mAdapter = adapter
    }
}

interface ActivityProvider {
    fun getResources(): Resources?
    fun getSupportFragmentManager(): FragmentManager?
    fun <T : View?> findViewById(@IdRes id: Int): T
    fun getString(@StringRes resId: Int): String?
}