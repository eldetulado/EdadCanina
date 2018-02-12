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
            calcularTotal()
        }

        Toast.makeText(this,"onCreate",Toast.LENGTH_SHORT).show();

    }

    override fun onPause() {
        super.onPause()
        Toast.makeText(this,"onPause",Toast.LENGTH_SHORT).show();
    }

    override fun onStop() {
        super.onStop()
        Toast.makeText(this,"onStop",Toast.LENGTH_SHORT).show();
    }

    override fun onResume() {
        super.onResume()
        accion.setOnClickListener {
            calcularTotal()
        }
    }

    override fun onRestart() {
        super.onRestart()
        Toast.makeText(this,"onRestart",Toast.LENGTH_SHORT).show();
    }

    override fun onDestroy() {
        super.onDestroy()
        Toast.makeText(this,"onDestroy",Toast.LENGTH_SHORT).show();
    }

    private fun calcularTotal() {
        if (edad.text.isNotEmpty()) {
            res = edad.text.toString().toInt() * 4
            resultado.text = res.toString()
            textView5.visibility = View.VISIBLE
        }
        /*else
            Toast.makeText(this, resources.getText(R.string.alerta), Toast.LENGTH_SHORT).show()*/
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putInt("DATO",res)
        Log.e("ERROR",res.toString())
        Toast.makeText(this,"onSaveInstanceState",Toast.LENGTH_SHORT).show();
    }
}
