package com.edwinacubillos.practica420201.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.edwinacubillos.practica420201.R
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
            var a = lado_a.text.toString()
            var b = lado_b.text.toString()

            if (a.isNotEmpty() && b.isNotEmpty()) {
                var c = lado_a.text.toString().toInt()
                var d = lado_b.text.toString().toInt()
                var respuesta = c * d
                resultado.text = respuesta.toString()

            }

        }
        return root


    }
}