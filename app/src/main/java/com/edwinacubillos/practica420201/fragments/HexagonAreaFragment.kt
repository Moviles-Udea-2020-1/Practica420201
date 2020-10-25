package com.edwinacubillos.practica420201.fragments

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.edwinacubillos.practica420201.R
import kotlinx.android.synthetic.main.fragment_hexagon_area.*
import kotlin.math.sqrt


class HexagonAreaFragment : Fragment() {

    private var regularRadioButtonChecked: Boolean = false
    private var irregularRadioButtonChecked: Boolean = false

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_hexagon_area, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        result_textView.text = getString(R.string.result_textView, 0.0)

        //Setup
        setup()
    }

    private fun setup() {
        side_editText.addTextChangedListener(textWatcher)

        regular_radioButton.setOnClickListener {
            side_textFieldLayout.visibility = View.VISIBLE
            result_layout.visibility = View.VISIBLE
            inputAnglesIrregularHexagon_layout.visibility = View.GONE
            if (!regularRadioButtonChecked) {
                side_editText.text = null
                result_textView.text = getString(R.string.result_textView, 0.0)
            }
            hexagonImageView.setImageResource(R.drawable.ic_regular_hexagon)
            regularRadioButtonChecked = true
            irregularRadioButtonChecked = false
        }

        irregular_radioButton.setOnClickListener {
            result_layout.visibility = View.GONE
            inputAnglesIrregularHexagon_layout.visibility = View.VISIBLE
            side_textFieldLayout.visibility = View.GONE
            if (!irregularRadioButtonChecked) {
                side_editText.text = null
                result_textView.text = getString(R.string.result_textView, 0.0)
            }
            hexagonImageView.setImageResource(R.drawable.ic_irregular_hexagon_angles)
            irregularRadioButtonChecked = true
            regularRadioButtonChecked = false
        }

        calculateArea_materialButton.setOnClickListener {
            calculateArea()
        }
    }

    private val textWatcher = object : TextWatcher {
        override fun afterTextChanged(s: Editable?) {
        }

        override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
        }

        override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
            side_textFieldLayout.error = null
        }
    }

    private fun calculateArea() {
        val perimeter: Double   //units
        val area: Double
        if (side_editText.text?.isNotBlank()!!) {
            side_textFieldLayout.error = null
            if (regular_radioButton.isChecked) {
                val side = side_editText.text.toString().toDouble() // meters units

                perimeter = side * 6.0
                val apothem = (side / 2.0) * sqrt(3.0)
                area = (perimeter * apothem) / 2.0

                result_textView.text = getString(R.string.result_textView, area)
            } else if (irregular_radioButton.isChecked) {
                result_textView.text = getString(R.string.result_textView, 0.0)
            }
        } else {
            side_textFieldLayout.error = "Enter a number value!"
        }

    }

}
