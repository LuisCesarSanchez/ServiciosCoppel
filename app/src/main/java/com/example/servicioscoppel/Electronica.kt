package com.example.servicioscoppel


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import java.sql.PreparedStatement
import java.sql.SQLException

class Electronica : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_electronica)

        val connectSql = ConnectSql()

        // --- Boton de registro de Garantia de Electronica¡´`

        val Registrar_Electronica = findViewById<Button>(R.id.btnRegistrar)
        val editTextFactura1 = findViewById<EditText>(R.id.editTextFactura1)
        val editTextGarantia1 = findViewById<EditText>(R.id.editTextGarantia1)
        val editTextIncentivo1 = findViewById<EditText>(R.id.editTextIncentivo1)



        Registrar_Electronica.setOnClickListener{

            try {
                val addRegistro: PreparedStatement = connectSql.dbConn()?.prepareStatement("insert into Registro_De_Garantias values (?,?,?)")!!

                addRegistro.setString(1,editTextFactura1.text.toString())
                addRegistro.setString(2,editTextGarantia1.text.toString())
                addRegistro.setString(3,editTextIncentivo1.text.toString())
                addRegistro.executeUpdate()

                editTextFactura1.setText("")
                editTextGarantia1.setText("")
                editTextIncentivo1.setText("")

                Toast.makeText(this,"Registro Ingresado", Toast.LENGTH_SHORT).show()
            }catch (ex: SQLException){
                Toast.makeText(this,"Error", Toast.LENGTH_SHORT).show()
            }

        }


    }
    }
