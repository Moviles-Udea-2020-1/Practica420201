package com.edwinacubillos.practica420201.fragments

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.edwinacubillos.practica420201.R
import kotlinx.android.synthetic.main.fragment_perimetro_rectangulo.*

class PerimetroRectanguloFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_perimetro_rectangulo, container, false)
    }

    @SuppressLint("SetTextI18n")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        calcularbutton.setOnClickListener {
            val altura = altura_TextInputEditText.text.toString()
            val base = base_TextInputEditText.text.toString()
            val resultado: Double

            when {
                altura.isEmpty() -> {
                    altura_TextInputEditText.error =
                        getString(R.string.error_altura_rectangulo)
                    valorResultante_textView.text = null
                }
                base.isEmpty() -> {
                    base_TextInputEditText.error =
                        getString(R.string.error_base_rectangulo)
                    valorResultante_textView.text = null
                }


                else -> {
                    val resultado = 2 * (base.toDouble() + altura.toDouble())
                    valorResultante_textView.text = resultado.toString() + getString(R.string.cm)
                }
            }


        }

    }
}