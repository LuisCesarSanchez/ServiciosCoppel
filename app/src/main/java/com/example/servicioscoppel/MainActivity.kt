package com.example.servicioscoppel

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast


class MainActivity : AppCompatActivity() {


    @SuppressLint("SuspiciousIndentation")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val txtUsuario = findViewById<EditText>(R.id.txtUsuario)
        val Ingresar = findViewById<Button>(R.id.btnIngresar)

        //Boton de Validacion con Numero de Empleado

        Ingresar.setOnClickListener {

            if (txtUsuario.text.toString() == "96554780") {
                val i = Intent(this, Menu::class.java)
                    startActivity(i)
                txtUsuario.setText("")
            }else
                Toast.makeText(this, "Numero de Empleado Incorrecto", Toast.LENGTH_LONG).show()
            }



        }



}


