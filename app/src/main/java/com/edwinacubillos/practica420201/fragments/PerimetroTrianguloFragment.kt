package com.edwinacubillos.practica420201.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.edwinacubillos.practica420201.R
import kotlinx.android.synthetic.main.fragment_perimetro_triangulo.*


class PerimetroTrianguloFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?

    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_perimetro_triangulo, container, false)

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        perimetro_triangulo_button.setOnClickListener {
            lado_uno_textInputLayout.error = null
            lado_dos_textInputLayout.error = null
            lado_tres_textInputLayout.error = null
            if (validar()) {
                val lado1 = lado_uno_text_view.text.toString().toFloat()
                val lado2 = lado_dos_text_view.text.toString().toFloat()
                val lado3 = lado_tres_text_view.text.toString().toFloat()
                val perimetro = lado1 + lado2 + lado3
                resultado_text_view.text = perimetro.toString()
            } else {
                resultado_text_view.text = "0"

            }
        }
    }

    private fun validar(): Boolean {
        var valido = true

        if (lado_uno_text_view.text!!.isBlank()) {
            lado_uno_textInputLayout.error = getString(R.string.mensaje_errorl1_perimetro_triangulo)
            valido = false
        }
        if (lado_dos_text_view.text!!.isBlank()) {
            lado_dos_textInputLayout.error = getString(R.string.mensaje_errorl2_perimetro_triangulo)
            valido = false
        }
        if (lado_tres_text_view.text!!.isBlank()) {
            lado_tres_textInputLayout.error =
                getString(R.string.mensaje_errorl3_perimetro_triangulo)
            valido = false
        }
        return valido
    }
}