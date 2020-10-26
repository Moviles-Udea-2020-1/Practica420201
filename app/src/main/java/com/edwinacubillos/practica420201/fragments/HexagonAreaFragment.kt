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
import kotlin.math.abs
import kotlin.math.sqrt


class HexagonAreaFragment : Fragment() {

    private var regularRadioButtonChecked: Boolean = false
    private var irregularRadioButtonChecked: Boolean = false
    private var regularEditTextSetNull: Boolean = false
    private var irregularEditTextSetNull: Boolean = false

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
        vertexA_editText.addTextChangedListener(textWatcher)
        vertexB_editText.addTextChangedListener(textWatcher)
        vertexC_editText.addTextChangedListener(textWatcher)
        vertexD_editText.addTextChangedListener(textWatcher)
        vertexE_editText.addTextChangedListener(textWatcher)
        vertexF_editText.addTextChangedListener(textWatcher)

        regular_radioButton.setOnClickListener {
            side_textFieldLayout.visibility = View.VISIBLE
            inputVertexIrregularHexagon_layout.visibility = View.GONE
            if (!regularRadioButtonChecked) {
                vertexA_editText.text = null
                vertexB_editText.text = null
                vertexC_editText.text = null
                vertexD_editText.text = null
                vertexE_editText.text = null
                vertexF_editText.text = null
                regularEditTextSetNull = false
                irregularEditTextSetNull = true
                result_textView.text = getString(R.string.result_textView, 0.0)
            }
            hexagonImageView.setImageResource(R.drawable.ic_regular_hexagon_area)
            regularRadioButtonChecked = true
            irregularRadioButtonChecked = false
        }

        irregular_radioButton.setOnClickListener {
            inputVertexIrregularHexagon_layout.visibility = View.VISIBLE
            side_textFieldLayout.visibility = View.GONE
            if (!irregularRadioButtonChecked) {
                side_editText.text = null
                irregularEditTextSetNull = false
                regularEditTextSetNull = true
                result_textView.text = getString(R.string.result_textView, 0.0)
            }
            hexagonImageView.setImageResource(R.drawable.ic_irregular_hexagon_area_vertex)
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
            if (regular_radioButton.isChecked) {
                isValidSideEditText()
            } else if (irregular_radioButton.isChecked) {
                isValidaVerticesEditTex()
            }
        }
    }

    private fun calculateArea() {
        val area: Double
        if (regular_radioButton.isChecked) {
            if (isValidSideEditText()) {
                side_textFieldLayout.error = null
                val side = side_editText.text.toString().toDouble() // meters units
                area = (3 * sqrt(3.0) * side * side) / 2
                result_textView.text = getString(R.string.result_textView, area)
            } else {
                result_textView.text = getString(R.string.result_textView, 0.0)
            }
        } else if (irregular_radioButton.isChecked) {
            if (isValidaVerticesEditTex()) {
                val vertexA = vertexA_editText.text.toString().split(".")
                val vertexB = vertexB_editText.text.toString().split(".")
                val vertexC = vertexC_editText.text.toString().split(".")
                val vertexD = vertexD_editText.text.toString().split(".")
                val vertexE = vertexE_editText.text.toString().split(".")
                val vertexF = vertexF_editText.text.toString().split(".")

                val vertexX = arrayListOf(
                    getXValue(vertexA), getXValue(vertexB), getXValue(vertexC),
                    getXValue(vertexD), getXValue(vertexE), getXValue(vertexF)
                )

                val vertexY = arrayListOf(
                    getYValue(vertexA), getYValue(vertexB), getYValue(vertexC),
                    getYValue(vertexD), getYValue(vertexE), getYValue(vertexF)
                )
                area = abs(getSum(vertexX, vertexY) - getSum(vertexY, vertexX)) / 2
                result_textView.text = getString(R.string.result_textView, area)
            } else {

                result_textView.text = getString(R.string.result_textView, 0.0)
            }
        }
    }

    private fun isValidSideEditText(): Boolean {
        return if (side_editText.text?.isBlank()!! && !regularEditTextSetNull) {
            side_textFieldLayout.error = "Enter a number value!"
            regularEditTextSetNull = false
            false
        } else {
            side_textFieldLayout.error = null
            true
        }

    }

    private fun isValidaVerticesEditTex(): Boolean {
        var validVertices = true

        if (!irregularEditTextSetNull) {
            if (vertexA_editText.text?.isBlank()!!) {
                vertexA_editText.error = "Enter a vertex (x.y) format"
                validVertices = false
            } else if (vertexA_editText.text?.isNotBlank()!!) {
                vertexA_editText.error = null
            }

            if (vertexB_editText.text?.isBlank()!!) {
                vertexB_editText.error = "Enter a vertex (x.y) format"
                validVertices = false
            } else if (vertexB_editText.text?.isNotBlank()!!) {
                vertexB_editText.error = null

            }

            if (vertexC_editText.text?.isBlank()!!) {
                vertexC_editText.error = "Enter a vertex (x.y) format"
                validVertices = false
            } else if (vertexC_editText.text?.isNotBlank()!!) {
                vertexC_editText.error = null
            }

            if (vertexD_editText.text?.isBlank()!!) {
                vertexD_editText.error = "Enter a vertex (x.y) format"
                validVertices = false
            } else if (vertexD_editText.text?.isNotBlank()!!) {
                vertexD_editText.error = null
            }

            if (vertexE_editText.text?.isBlank()!!) {
                vertexE_editText.error = "Enter a vertex (x.y) format"
                validVertices = false
            } else if (vertexE_editText.text?.isNotBlank()!!) {
                vertexE_editText.error = null
            }

            if (vertexF_editText.text?.isBlank()!!) {
                vertexF_editText.error = "Enter a vertex (x.y) format"
                validVertices = false
            } else if (vertexF_editText.text?.isNotBlank()!!) {
                vertexF_editText.error = null
            }
        } else {
            vertexA_editText.error = null
            vertexB_editText.error = null
            vertexC_editText.error = null
            vertexD_editText.error = null
            vertexE_editText.error = null
            vertexF_editText.error = null
        }
        return validVertices
    }

    private fun getXValue(vertex: List<String>): Double {
        return if (vertex[0].isNotBlank()) {
            vertex[0].toDouble()
        } else {
            0.0
        }
    }

    private fun getYValue(vertex: List<String>): Double {
        return if (vertex.size > 1) {
            if (vertex[1].isNotBlank()) {
                vertex[1].toDouble()
            } else {
                0.0
            }
        } else {
            0.0
        }
    }

    private fun getSum(vertexX: ArrayList<Double>, vertexY: ArrayList<Double>): Double {
        var i = 0
        var j: Int
        var sum = 0.0

        do {
            j = if (i + 1 == 6) {
                0
            } else {
                i + 1
            }
            sum += vertexX[i] * vertexY[j]
            i++
        } while (i < 6)
        return sum
    }


}
