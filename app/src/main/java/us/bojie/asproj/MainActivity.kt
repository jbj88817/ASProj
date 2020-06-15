package us.bojie.asproj

import android.os.Bundle
import us.bojie.asproj.common.ui.component.HiBaseActivity
import us.bojie.asproj.logic.ActivityProvider
import us.bojie.asproj.logic.MainActivityLogic

class MainActivity : HiBaseActivity(), ActivityProvider {

    private lateinit var mActivityLogic: MainActivityLogic

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        mActivityLogic = MainActivityLogic(this, savedInstanceState)
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        mActivityLogic.onSaveInstanceState(outState)
    }
}