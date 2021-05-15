package com.kotlin.mvvm.ui.login

import android.app.Activity
import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
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

class LoginFragment : DaggerFragment(), View.OnClickListener {

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory
    private var btn_login: Button? = null
    private var edtUserName: EditText? = null
    private var edtPassword: EditText? = null
    private var mContext: MainActivity? = null
    private var dummyPwd: String? = "test1234!"
    private var dummyUserName: String? = "test@luxpmsoft.com"
    private val countriesViewModel: LoginViewModel by viewModels {
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
            LoginFragment().apply {
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
        thisView = inflater.inflate(R.layout.fragment_login, container, false)

        load()
        return thisView
    }

    override fun onAttach(activity: Activity) {
        super.onAttach(activity)
        mContext = (context as MainActivity)
    }

    private fun load() {
        btn_login = thisView!!.findViewById<View>(R.id.btn_login) as Button
        edtPassword = thisView!!.findViewById<View>(R.id.edtPassword) as EditText
        edtUserName = thisView!!.findViewById<View>(R.id.edtUserName) as EditText
        btn_login!!.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        val fragment: Fragment
        if (v?.id == R.id.btn_login) {
            if (edtUserName?.text.toString() != null && edtPassword?.text.toString() != null && edtUserName?.text.toString()
                    .trim()
                    .equals(dummyUserName, ignoreCase = true) && edtPassword?.text.toString().trim()
                    .equals(dummyPwd, ignoreCase = true)
            ) {
                fragment = DetailsFragment()
                mContext?.showFragment(fragment, null)
            } else {
                Toast.makeText(
                    mContext,
                    "Please enter correct user name and password",
                    Toast.LENGTH_LONG
                ).show()
            }
        }
    }

}
