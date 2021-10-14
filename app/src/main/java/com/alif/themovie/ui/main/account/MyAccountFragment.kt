package com.alif.themovie.ui.main.account

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.alif.themovie.R
import com.alif.themovie.databinding.FragmentMyAccountBinding
import com.alif.themovie.ui.base.BaseBindingFragment


class MyAccountFragment : BaseBindingFragment<FragmentMyAccountBinding>() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_my_account, container, false)
    }


    override val bindingInflater: (LayoutInflater, ViewGroup?, Boolean) -> FragmentMyAccountBinding =
        { layoutInflater, viewGroup, isAttached ->
            FragmentMyAccountBinding.inflate(layoutInflater, viewGroup, isAttached)
        }

    override fun initView() {

    }
}