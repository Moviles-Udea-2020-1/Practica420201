package com.edwinacubillos.practica420201.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.edwinacubillos.practica420201.R
import kotlinx.android.synthetic.main.fragment_perimetrocirculo.*

class PerimetrocirculoFragment : Fragment() {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        calcularPerimetroCir_button.setOnClickListener{
            val radio = valorRadio.text.toString().toFloat()
            val perimetro = (2)*(3.1416)*radio
            resultado_textView.text = "El perímetro del círculo es: " + perimetro
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_perimetrocirculo, container, false)
    }

    companion object
}