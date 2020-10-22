package com.edwinacubillos.practica420201

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_area_cuadro.*

class AreaCuadroFragment : Fragment() {

    private val unidades = " cm²"
    private val empty= "Vacio"

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_area_cuadro, container, false)
    }

    @SuppressLint("SetTextI18n")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


    button_calcular.setOnClickListener{

        if(editText_LongitudLado.text.toString().isNotEmpty()){
            val lado = editText_LongitudLado.text.toString()
            val area = lado.toInt()*lado.toInt()
            textView_RtaArea.text = area.toString() + unidades
            textView2.text = ""

        }else{
            textView2.text = empty
        }
    }

    }

    companion object
}