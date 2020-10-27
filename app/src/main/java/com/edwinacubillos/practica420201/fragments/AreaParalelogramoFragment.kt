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
            val lado1 = lado1_edit_text.text.toString()
            val lado2 = lado2_edit_text.text.toString()
            val angulo = angulo_edit_text.text.toString()


            when {
                lado1.isEmpty() -> {
                    resultado_text_view.text = getString(R.string.ingrese_lado_a)
                    return@setOnClickListener
                }
                lado2.isEmpty() -> {
                    resultado_text_view.text = getString(R.string.ingrese_lado_b)
                    return@setOnClickListener
                }
                angulo.isEmpty() -> {
                    resultado_text_view.text = getString(R.string.ingrese_angulo)
                    return@setOnClickListener
                }
                else -> {
                    val ladoA = lado1.toFloat()
                    val ladoB = lado2.toFloat()
                    val ang = angulo.toFloat()
                    val anguloRad = (PI / 180) * ang
                    val resultadoArea = ladoA * ladoB * sin(anguloRad)
                    resultado_text_view.text = getString(R.string.result_textView, resultadoArea)
                }
            }
        }
    }

    companion object
}


