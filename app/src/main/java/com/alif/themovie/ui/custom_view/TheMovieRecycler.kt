package com.alif.themovie.ui.custom_view

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import androidx.constraintlayout.widget.ConstraintLayout
import com.alif.themovie.databinding.TheMovieRecyclerViewBinding
import com.alif.themovie.domain.model.discover_movie.Movie

class TheMovieRecycler : ConstraintLayout {

    private lateinit var binding: TheMovieRecyclerViewBinding

    constructor(context: Context) : super(context) {
        initView(context)
    }


    constructor(context: Context, attributeSet: AttributeSet?) : super(context, attributeSet) {
        initView(context)
    }

    constructor(context: Context, attributeSet: AttributeSet?, defStyleAttr: Int) : super(
        context,
        attributeSet,
        defStyleAttr
    ) {
        initView(context)
    }


    private val adapter: TheMovieAdapter by lazy {
        TheMovieAdapter()
    }


    fun setData(data: List<Movie>) {
        adapter.submitList(data)
    }

    fun setTitle(title: String) {
        binding.textTitleTheMovieRecycler.text = title
    }

    fun setButtonTogglesText(textLeftButton: String, textRightButton: String) {

        binding.buttonToggleLeftTheMovieRecycler.text = textLeftButton
        binding.buttonToggleRightTheMovieRecycler.text = textRightButton
    }

    private fun initView(context: Context) {
        binding = TheMovieRecyclerViewBinding.inflate(LayoutInflater.from(context), this, true)

        binding.theMovieRecycler.adapter = adapter
        binding.buttonToggleGroupTheMovieRecycler.addOnButtonCheckedListener { group, checkedId, isChecked ->


        }


    }


}