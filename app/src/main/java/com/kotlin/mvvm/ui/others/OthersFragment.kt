package com.kotlin.mvvm.ui.others

import android.app.Activity
import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.RecyclerView
import com.kotlin.mvvm.R
import com.kotlin.mvvm.ui.details.DetailsFragment
import com.kotlin.mvvm.ui.details.DetailsFragment_MembersInjector
import com.kotlin.mvvm.ui.details.MainActivity

import dagger.android.support.AndroidSupportInjection
import dagger.android.support.DaggerFragment
import javax.inject.Inject

class OthersFragment : DaggerFragment(), View.OnClickListener {

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory
    private var btn_other: Button? = null
    private var mContext: MainActivity? = null
    private val countriesViewModel: OthersViewModel by viewModels {
        viewModelFactory
    }

    private var columnCount = 1
    private lateinit var thisView: View


    /**
     *
     */
    companion object {
        const val ARG_COLUMN_COUNT = "column-count"

        @JvmStatic
        fun newInstance(columnCount: Int) =
            OthersFragment().apply {
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
        thisView = inflater.inflate(R.layout.fragment_others, container, false)

        load()
        return thisView
    }

    override fun onAttach(activity: Activity) {
        super.onAttach(activity)
        mContext = (context as MainActivity)
    }

    private fun load() {
        btn_other = thisView!!.findViewById<View>(R.id.btn_other) as Button
        btn_other!!.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        if (v?.id == R.id.btn_other) {
            mContext?.finish()
        }
    }

}
