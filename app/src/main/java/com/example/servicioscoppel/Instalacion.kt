package com.example.servicioscoppel

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import java.sql.PreparedStatement
import java.sql.SQLException

class Instalacion : AppCompatActivity() {

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_instalacion)

        val connectSql = ConnectSql()

        // --- Boton de registro de Servicio de Instalacion¡´`

        val Registrar_Instalacion = findViewById<Button>(R.id.btnRegistrarIns)
        val editTextFactura3 = findViewById<EditText>(R.id.editTextFactura3)
        val editTextServicio1 = findViewById<EditText>(R.id.editTextServicio1)
        val editTextIncentivo3 = findViewById<EditText>(R.id.editTextIncentivo3)

        Registrar_Instalacion.setOnClickListener{

            try {
                val addRegistro: PreparedStatement = connectSql.dbConn()?.prepareStatement("insert into Registro_De_Servicios values (?,?,?)")!!

                addRegistro.setString(1,editTextFactura3.text.toString())
                addRegistro.setString(2,editTextServicio1.text.toString())
                addRegistro.setString(3,editTextIncentivo3.text.toString())
                addRegistro.executeUpdate()

                editTextFactura3.setText("")
                editTextServicio1.setText("")
                editTextIncentivo3.setText("")

                Toast.makeText(this,"Registro Ingresado", Toast.LENGTH_SHORT).show()
            }catch (ex: SQLException){
                Toast.makeText(this,"Error", Toast.LENGTH_SHORT).show()
            }

        }


    }
}