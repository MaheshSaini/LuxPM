package com.kotlin.mvvm.ui.details

import android.os.Bundle
import androidx.fragment.app.Fragment
import com.kotlin.mvvm.R
import com.kotlin.mvvm.ui.BaseActivity
import com.kotlin.mvvm.ui.login.LoginFragment

/**
 * Created by Mahesh Saini on 08,November,2019
 */
class MainActivity : BaseActivity() {

    /**
     */
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if (savedInstanceState == null) {
            supportFragmentManager
                .beginTransaction()
                .add(R.id.fragment_container, LoginFragment.newInstance(1))
                .commit()
        }
    }

    fun showFragment(fragment: Fragment, args: Bundle?) {
        val mTransactiont = supportFragmentManager.beginTransaction()
        fragment.arguments = args
        mTransactiont.replace(R.id.fragment_container, fragment, fragment.javaClass.name)
        mTransactiont.commit()
    }
}
