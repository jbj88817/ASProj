package us.bojie.asproj

import android.os.Bundle
import us.bojie.asproj.common.ui.component.HiBaseActivity

class MainActivity : HiBaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}