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
            val base = base_triangulo_edit_text.text.toString().toFloat()
            val altura = altura_triangulo_edit_text.text.toString().toFloat()

            var area = base * altura / 2

            resultado_area_triangulo_text_view.text = "El área del triángulo es: $area"
        }

    }

    companion object
}