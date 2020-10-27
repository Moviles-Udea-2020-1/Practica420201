package com.edwinacubillos.practica420201.fragments

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.edwinacubillos.practica420201.R
import kotlinx.android.synthetic.main.fragment_perimetro_cuadrado.*

class PerimetroCuadradoFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_perimetro_cuadrado, container, false)


    }



    @SuppressLint("SetTextI18n")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        super.onViewCreated(view, savedInstanceState)

        calcular_btn.setOnClickListener{
            val perimetro = valor_a_edit_text.text.toString()
            if (perimetro.isEmpty()) {
                valor_mensaje_text_view.text = "Ingrese valor"
                valor_a_edit_text.requestFocus()
            } else {
                val peri: Double = perimetro.toDouble()
                val resultado: Double = 4 * peri
                valor_mensaje_text_view.text = ""
                resultado_text_view.text = "Perímetro del Cuadro es:   $resultado"
            }
        }
    }

    companion object
}