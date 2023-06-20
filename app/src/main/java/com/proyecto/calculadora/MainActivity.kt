package com.proyecto.calculadora

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView


class MainActivity : AppCompatActivity() {
    //0->nada, 1->suma, 2->resta, 3->mult, 4->div
    var oper: Int = 0
    var numero1: Float = 0F
    lateinit var resultado1: TextView
    lateinit var resultado2: TextView
    var contador: Int =0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        resultado1 = findViewById(R.id.resultado1)
        resultado2 = findViewById(R.id.resultado2)
        val btnborrar = findViewById<Button>(R.id.btnborrar)
        val btnigual = findViewById<Button>(R.id.btnigual)
        val btndecimal = findViewById<Button>(R.id.btndecimal)

        btndecimal.setOnClickListener{
            if(contador ==0){
                val num2: String = resultado2.text.toString()
                resultado2.setText(num2+".")
                contador = 1
            }
        }
        btnigual.setOnClickListener{
            var numero2: Float = resultado2.text.toString().toFloat()
            var resp: Float = 0F
            when(oper){
                1-> resp = numero1 + numero2
                2-> resp = numero1 - numero2
                3-> resp = numero1 * numero2
                4-> resp = numero1 / numero2
            }
            resultado2.setText(resp.toString())
            resultado1.setText("")
            contador=0
        }
        btnborrar.setOnClickListener{
            resultado1.setText("")
            resultado2.setText("")
            numero1 = 0F
            oper = 0
        }
    }

    fun presionarDigito(view:View){
        //val resultado2: TextView = findViewById(R.id.resultado2)
        val num2: String = resultado2.text.toString()
        when(view.id){
            R.id.btncero -> resultado2.setText(num2 + "0")
            R.id.btnuno -> resultado2.setText(num2 + "1")
            R.id.btndos -> resultado2.setText(num2 + "2")
            R.id.btntres -> resultado2.setText(num2 + "3")
            R.id.btncuatro -> resultado2.setText(num2 + "4")
            R.id.btncinco -> resultado2.setText(num2 + "5")
            R.id.btnseis -> resultado2.setText(num2 + "6")
            R.id.btnsiete -> resultado2.setText(num2 + "7")
            R.id.btnocho -> resultado2.setText(num2 + "8")
            R.id.btnnueve -> resultado2.setText(num2 + "9")
        }
    }

    fun clickOperacion(view: View){
        numero1 = resultado2.text.toString().toFloat()
        var num2:String = resultado2.text.toString()
        resultado2.setText("")
        when(view.id){
            R.id.btnsuma ->{
                resultado1.setText(num2 + "+")
                oper = 1
            }
            R.id.btnresta ->{
                resultado1.setText(num2 + "-")
                oper = 2
            }
            R.id.btnmultiplicacion ->{
                resultado1.setText(num2 + "*")
                oper = 3
            }
            R.id.btndividir ->{
                resultado1.setText(num2 + "/")
                oper = 4
            }
        }
    }

}