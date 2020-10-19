package com.edwinacubillos.practica420201.fragments

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

    //@SuppressLint("SetTextI18n")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        calcularbutton.setOnClickListener {

            val base = base_editTextNumberDecimal.text.toString().toDouble()
            val altura = altura_editTextNumberDecimal.text.toString().toDouble()
            val resultado = 2 * (base + altura)

            valorResultante_textView.text = resultado.toString() + getString(R.string.cm)
        }

    }
}