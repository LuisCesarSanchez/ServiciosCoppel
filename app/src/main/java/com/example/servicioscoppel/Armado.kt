package com.example.servicioscoppel


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import java.sql.PreparedStatement
import java.sql.SQLException

class Armado : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_armado)

        val connectSql = ConnectSql()

        // --- Boton de registro de Servicio de Armado¡´`

        val Registrar_Armado = findViewById<Button>(R.id.btnRegistrarArm)
        val editTextFactura2 = findViewById<EditText>(R.id.editTextFactura2)
        val editTextServicio = findViewById<EditText>(R.id.editTextServicio)
        val editTextIncentivo2 = findViewById<EditText>(R.id.editTextIncentivo2)

        Registrar_Armado.setOnClickListener{

            try {
                val addRegistro: PreparedStatement = connectSql.dbConn()?.prepareStatement("insert into Registro_De_Servicios values (?,?,?)")!!

                addRegistro.setString(1,editTextFactura2.text.toString())
                addRegistro.setString(2,editTextServicio.text.toString())
                addRegistro.setString(3,editTextIncentivo2.text.toString())
                addRegistro.executeUpdate()

                editTextFactura2.setText("")
                editTextServicio.setText("")
                editTextIncentivo2.setText("")

                Toast.makeText(this,"Registro Ingresado", Toast.LENGTH_SHORT).show()
            }catch (ex: SQLException){
                Toast.makeText(this,"Error", Toast.LENGTH_SHORT).show()
            }

        }


    }
    }
