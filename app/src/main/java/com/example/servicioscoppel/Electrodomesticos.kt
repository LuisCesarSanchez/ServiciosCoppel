package com.example.servicioscoppel


import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import java.sql.PreparedStatement

import java.sql.SQLException

class Electrodomesticos : AppCompatActivity() {

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_electrodomesticos)

        val connectSql = ConnectSql()

        // --- Boton de registro de Garantia de Electrodomesticos¡´`

        val Registrar_Electrodomesticos = findViewById<Button>(R.id.btnRegistrarEle)
        val editTextFactura = findViewById<EditText>(R.id.editTextFactura)
        val editTextGarantia = findViewById<EditText>(R.id.editTextGarantia)
        val editTextIncentivo = findViewById<EditText>(R.id.editTextIncentivo)

        Registrar_Electrodomesticos.setOnClickListener{

            try {
                val addRegistro:PreparedStatement = connectSql.dbConn()?.prepareStatement("insert into Registro_De_Garantias values (?,?,?)")!!
                addRegistro.setString(1,editTextFactura.text.toString())
                addRegistro.setString(2,editTextGarantia.text.toString())
                addRegistro.setString(3,editTextIncentivo.text.toString())
                addRegistro.executeUpdate()


                editTextFactura.setText("")
                editTextGarantia.setText("")
                editTextIncentivo.setText("")



                Toast.makeText(this,"Registro Ingresado",Toast.LENGTH_SHORT).show()
            }catch (ex: SQLException){
                Toast.makeText(this,"Error",Toast.LENGTH_SHORT).show()
            }

        }


    }
}