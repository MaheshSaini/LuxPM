package com.kotlin.mvvm.di.modules

import com.kotlin.mvvm.ui.details.DetailsFragment
import com.kotlin.mvvm.ui.login.LoginFragment
import com.kotlin.mvvm.ui.others.OthersFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Suppress("unused")
@Module
abstract class FragmentModule {

    /**
     * Injecting Fragments
     */
    @ContributesAndroidInjector
    internal abstract fun contributeCountryDetailsFragment(): DetailsFragment

    @ContributesAndroidInjector
    internal abstract fun contributeCountryListFragment(): LoginFragment

    @ContributesAndroidInjector
    internal abstract fun contributeCountryOthersFragment(): OthersFragment
}