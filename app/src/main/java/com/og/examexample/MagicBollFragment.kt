package com.og.examexample

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import androidx.fragment.app.Fragment

private const val LAST_BOLL_IMAGE = "image"

class DiceRollFragment : Fragment() {

    lateinit var bollImageView: ImageView
    lateinit var rollButton: Button

    private val bollImageList: List<Int> = listOf(
        R.drawable.solution_1,
        R.drawable.solution_2,
        R.drawable.solution_3,
        R.drawable.solution_4,
        R.drawable.solution_5,
        R.drawable.solution_6,
        R.drawable.solution_7,
        R.drawable.solution_8,
        R.drawable.solution_9,
        R.drawable.solution_10,
    )

    var lastRolledImageRes = 0

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_magic_boll, container, false)

        bollImageView = view.findViewById(R.id.boll_image_view)
        rollButton = view.findViewById(R.id.roll_button)

        if (savedInstanceState != null)
            bollImageView.setImageResource(savedInstanceState.getInt(LAST_BOLL_IMAGE))

        rollButton.setOnClickListener {
            lastRolledImageRes = bollImageList.random()
            bollImageView.setImageResource(lastRolledImageRes)
        }

        return view
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putInt(LAST_BOLL_IMAGE, lastRolledImageRes)
    }

}