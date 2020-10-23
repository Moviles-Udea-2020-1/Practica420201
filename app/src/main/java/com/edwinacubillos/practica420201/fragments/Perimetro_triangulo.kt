package com.edwinacubillos.practica420201.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.edwinacubillos.practica420201.R
import kotlinx.android.synthetic.main.fragment_perimetro_triangulo.*


class perimetro_triangulo : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


    }

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
            val ladouno = lado_uno_text_view.text.toString().toFloat()
            val ladodos = lado_dos_text_view.text.toString().toFloat()
            val ladotres = lado_tres_edit_text.text.toString().toFloat()
            val perimetro = ladouno + ladodos + ladotres
            resultado_text_view.text = perimetro.toString()
        }
    }


}