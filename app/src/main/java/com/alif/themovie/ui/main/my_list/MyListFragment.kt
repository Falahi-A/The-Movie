package com.alif.themovie.ui.main.my_list


import android.view.LayoutInflater
import android.view.ViewGroup
import com.alif.themovie.databinding.FragmentMyListBinding
import com.alif.themovie.ui.base.BaseBindingFragment


class MyListFragment : BaseBindingFragment<FragmentMyListBinding>() {
    override val bindingInflater: (LayoutInflater, ViewGroup?, Boolean) -> FragmentMyListBinding =
        { layoutInflater, viewGroup, isAttached ->
            FragmentMyListBinding.inflate(layoutInflater, viewGroup, isAttached)
        }

    override fun initView() {

    }


}