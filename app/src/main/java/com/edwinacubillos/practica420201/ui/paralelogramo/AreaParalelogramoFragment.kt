package com.edwinacubillos.practica420201.ui.paralelogramo

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


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_area_paralelogramo, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        //.

        calcular_button.setOnClickListener {
            val lado1 = lado1_edit_text.text.toString().toInt()
            val lado2 = lado2_edit_text.text.toString().toInt()
            val angulo = angulo_edit_text.text.toString().toInt()
            val anguloRad = (PI / 180) * angulo

            val resultado = lado1 * lado2 * sin(anguloRad.toDouble())
            resultado_text_view.text = resultado.toString()
        }
    }

    companion object {

    }
}