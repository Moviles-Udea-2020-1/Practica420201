package com.edwinacubillos.practica420201.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.edwinacubillos.practica420201.R
import kotlinx.android.synthetic.main.fragment_area_paralelogramo.*
import kotlin.math.PI
import kotlin.math.sin


class AreaParalelogramoFragment : Fragment() {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setup()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        return inflater.inflate(R.layout.fragment_area_paralelogramo, container, false)
    }


    private fun setup() {
        calcular_button.setOnClickListener {
            val lado1 = lado1_edit_text.text.toString().toDouble()
            val lado2 = lado2_edit_text.text.toString().toDouble()
            val angulo = angulo_edit_text.text.toString().toDouble()
            val anguloRad = (PI / 180) * angulo

            val resultadoArea = lado1 * lado2 * sin(anguloRad)
            resultado_text_view.text = getString(R.string.result_textView, resultadoArea)
        }
    }

    companion object
}