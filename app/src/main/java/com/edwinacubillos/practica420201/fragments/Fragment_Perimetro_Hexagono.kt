package com.edwinacubillos.practica420201.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.edwinacubillos.practica420201.R
import kotlinx.android.synthetic.main.nav_perimetro_hexagono.*


class Fragment_Perimetro_Hexagono : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.nav_perimetro_hexagono, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        button_calculo.setOnClickListener {

            if (editTex_lados.text.toString()=="" || editTex_longitud.text.toString()=="" ){
                editTex_perimetro.setText("0")
            }else{
                val lados= editTex_lados.text.toString().toInt()
                val longitud = editTex_longitud.text.toString().toDouble()
                val resultado: Double = lados * longitud
                editTex_perimetro.setText(resultado.toString())
            }
        //hello

        }

    }

    companion object
}