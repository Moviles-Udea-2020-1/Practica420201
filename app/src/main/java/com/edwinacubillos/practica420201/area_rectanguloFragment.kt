package com.edwinacubillos.practica420201

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.fragment_area_rectangulo.*
import kotlinx.android.synthetic.main.fragment_area_rectangulo.view.*

class area_rectanguloFragment: Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val root = inflater.inflate(R.layout.fragment_area_rectangulo, container, false)


        root.boton.setOnClickListener {
            val a = lado_a.text.toString()
            val b = lado_b.text.toString()

            if (a.isNotEmpty() && b.isNotEmpty()) {
                val c = lado_a.text.toString().toInt()
                val d = lado_b.text.toString().toInt()
                val respuesta = c * d
                resultado.text = respuesta.toString()

            }

        }
        return root
    }
}