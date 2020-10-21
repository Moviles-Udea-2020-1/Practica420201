package com.edwinacubillos.practica420201

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.fragment_area_triangulo.*

class AreaTrianguloFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_area_triangulo, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        calcular_area_triangulo_button.setOnClickListener {
            val basestr = base_triangulo_edit_text.text.toString()
            val alturastr = altura_triangulo_edit_text.text.toString()

            if (basestr.isEmpty()) {
                resultado_area_triangulo_text_view.text = "Ingrese la base del triángulo!"
                return@setOnClickListener
            }
            if (alturastr.isEmpty()) {
                resultado_area_triangulo_text_view.text = "Ingrese la altura del triángulo!"
                return@setOnClickListener
            }

            val base = basestr.toDouble()
            val altura = alturastr.toDouble()

            val area = (base * altura) / 2.0

            resultado_area_triangulo_text_view.text = "El área del triángulo es: $area"
        }

    }
}