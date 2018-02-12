package com.example.oso.miedadcaninna

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private var res = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if (savedInstanceState != null){
            res = savedInstanceState.getInt("DATO")
            calcularTotal(res)
        }
    }

    override fun onResume() {
        super.onResume()
        accion.setOnClickListener{
            if (edad.text.isNotEmpty()) {
                res = edad.text.toString().toInt() * 4
                calcularTotal(res)
            }else
                Toast.makeText(this, resources.getText(R.string.alerta), Toast.LENGTH_SHORT).show()
        }
    }

    private fun calcularTotal(res: Int) {
        resultado.text = res.toString()
        textView5.visibility = View.VISIBLE
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putInt("DATO",res)
    }
}
