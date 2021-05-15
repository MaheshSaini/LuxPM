package com.kotlin.mvvm.ui.details

import android.app.Activity
import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.kotlin.mvvm.R
import com.kotlin.mvvm.ui.others.OthersFragment

import dagger.android.support.AndroidSupportInjection
import dagger.android.support.DaggerFragment
import javax.inject.Inject

class DetailsFragment : DaggerFragment(), View.OnClickListener {

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory
    private var btn_details: Button? = null
    private var mContext: MainActivity? = null

    private var columnCount = 1
    private lateinit var thisView: View

    companion object {
        const val ARG_COLUMN_COUNT = "column-count"

        @JvmStatic
        fun newInstance(columnCount: Int) =
            DetailsFragment().apply {
                arguments = Bundle().apply {
                    putInt(ARG_COLUMN_COUNT, columnCount)
                }
            }
    }

    /**
     *
     */
    override fun onAttach(context: Context) {
        AndroidSupportInjection.inject(this) // Providing the dependency
        super.onAttach(context)
    }

    /**
     *
     */
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        arguments?.let {
            columnCount = it.getInt(ARG_COLUMN_COUNT)
        }
    }

    /**
     *
     */
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        thisView = inflater.inflate(R.layout.fragment_details, container, false)

        load()
        return thisView
    }

    override fun onAttach(activity: Activity) {
        super.onAttach(activity)
        mContext = (context as MainActivity)
    }

    private fun load() {
        btn_details = thisView.findViewById<View>(R.id.btn_details) as Button
        btn_details!!.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        val fragment: Fragment
        if (v?.id == R.id.btn_details) {
            fragment = OthersFragment()
            mContext?.showFragment(fragment, null)
        }
    }

}
