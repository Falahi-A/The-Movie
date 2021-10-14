package com.alif.themovie.ui.main.category


import android.view.LayoutInflater
import android.view.ViewGroup
import com.alif.themovie.databinding.FragmentCategoryBinding
import com.alif.themovie.ui.base.BaseBindingFragment


class CategoryFragment : BaseBindingFragment<FragmentCategoryBinding>() {
    override val bindingInflater: (LayoutInflater, ViewGroup?, Boolean) -> FragmentCategoryBinding =
        { layoutInflater, viewGroup, isAttached ->
            FragmentCategoryBinding.inflate(layoutInflater, viewGroup, isAttached)

        }

    override fun initView() {
    }


}