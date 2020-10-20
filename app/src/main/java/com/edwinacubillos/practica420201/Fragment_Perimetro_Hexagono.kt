package com.edwinacubillos.practica420201

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment__perimetro__hexagono.*


class Fragment_Perimetro_Hexagono : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment__perimetro__hexagono, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        button_calculo.setOnClickListener {
            
            if (editTex_lados.text.toString()=="" || editTex_longitud.text.toString()=="" ){
                editTex_perimetro.setText("0")
            }else{
                val lados= editTex_lados.text.toString().toInt()
                val longitud=editTex_longitud.text.toString().toDouble()
                var resultado:Double= lados*longitud
                editTex_perimetro.setText(resultado.toString())
            }


        }

    }

    companion object {

    }
}