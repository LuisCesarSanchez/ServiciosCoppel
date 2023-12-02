package com.example.servicioscoppel

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageButton
import androidx.appcompat.app.AlertDialog


class Menu : AppCompatActivity() {
    @SuppressLint("SuspiciousIndentation")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu)


        val ir_a_Ele = findViewById<ImageButton>(R.id.imageBtnElect)
        val ir_a_Electronica = findViewById<ImageButton>(R.id.imagebtnElectronica)
        val ir_a_Armado = findViewById<ImageButton>(R.id.imagebtnArmado)
        val ir_a_Instalacion = findViewById<ImageButton>(R.id.imagebtnInstalacion)
        val ir_a_Resultados = findViewById<ImageButton>(R.id.imagebtnResultados)
        val Regresar = findViewById<ImageButton>(R.id.imageBtnSalir)




        //Boton para ir al menu de la Garantia Extendida de Electrodomesticos

          ir_a_Ele.setOnClickListener{
              val a = Intent(this,Electrodomesticos::class.java)
              startActivity(a)
        }

        //Boton para ir al menu la Garantia Extendida de Electronica

        ir_a_Electronica.setOnClickListener{
            val b = Intent(this,Electronica::class.java)
            startActivity(b)
        }

        //Boton para ir al menu del servicio de Armado

        ir_a_Armado.setOnClickListener{
            val c = Intent(this,Armado::class.java)
            startActivity(c)

        }

        //Boton para ir al menu de Servicio de Instalacion

        ir_a_Instalacion.setOnClickListener{
            val d = Intent(this,Instalacion::class.java)
            startActivity(d)
        }
        //Boton para ir al menu de Resultados

        ir_a_Resultados.setOnClickListener{
            val e = Intent(this,Resultados::class.java)
            startActivity(e)
        }
        //Boton para salir de la aplicacion
        Regresar.setOnClickListener{
           val f = AlertDialog.Builder(this)
            f.apply {
                setTitle("Cerrar Sesión")
                setMessage(" ¿Seguro que quieres salir? ")
                setNegativeButton("NO"){negative,_->
                    negative.dismiss()
                }
                setPositiveButton("SI"){positive,_->
                startActivity(Intent(this@Menu,MainActivity::class.java))
                    positive.dismiss()
                    finish()
                }
            }
           f.create()
            f.show()

        }



    }
}