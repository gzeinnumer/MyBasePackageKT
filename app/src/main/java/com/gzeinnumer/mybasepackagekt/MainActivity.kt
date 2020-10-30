package com.gzeinnumer.mybasepackagekt

import android.os.Bundle
import com.gzeinnumer.mybasepackagekt.base.BaseActivity

class MainActivity : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        onShowLoading()
    }
}