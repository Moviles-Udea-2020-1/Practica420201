package com.edwinacubillos.practica420201

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_perimetro_cuadro.*

class PerimetroCuadroFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_perimetro_cuadro, container, false)


    }



    @SuppressLint("SetTextI18n")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        super.onViewCreated(view, savedInstanceState)

        calcular_btn.setOnClickListener{
            val perimetro= valor_a_edit_text.text.toString()
            val peri:Double= perimetro.toDouble()
            val resultado:Double = 4*peri
            resultado_text_view.text= "Perímetro del Cuadro es:   ${resultado.toString()}"
        }
    }

    companion object {

    }
}