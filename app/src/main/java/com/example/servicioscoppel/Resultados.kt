package com.example.servicioscoppel
import android.annotation.SuppressLint
import android.os.Bundle
import android.os.StrictMode
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.Spinner
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import java.sql.Connection
import java.sql.DriverManager
import java.sql.SQLException



class Resultados : AppCompatActivity() {

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_resultados)

        // --- Realizamos la conexión a la base de datos¡´`

        val ip = "192.168.1.11:1433"
        val db = "Servicios_Coppel"
        val username = "servicio"
        val password = "1234"

        val policy = StrictMode.ThreadPolicy.Builder().permitAll().build()
        StrictMode.setThreadPolicy(policy)
        val conn: Connection?

        Class.forName("net.sourceforge.jtds.jdbc.Driver").newInstance()
        val connString = "jdbc:jtds:sqlserver://$ip;databaseName=$db;user=$username;password=$password"
        conn = DriverManager.getConnection(connString)

        // --- Botones de busqueda de registros¡´`

        val Registro_Garantia = findViewById<Button>(R.id.btnBuscarGarantia)
        val Registro_Servicio = findViewById<Button>(R.id.btnBuscarServicio)

        // --- Spinners para mostrar registros de consultas de las tablas¡´`

        val SpinnerFactura = findViewById<Spinner>(R.id.spinnerFactura)
        val SpinnerGarantia = findViewById<Spinner>(R.id.spinnerGarantia)
        val SpinnerIncentivo = findViewById<Spinner>(R.id.spinnerIncentivo)

        val SpinnerFacturaSer = findViewById<Spinner>(R.id.spinnerFacturaSer)
        val SpinnerGarantiaSer = findViewById<Spinner>(R.id.spinnerGarantiaSer)
        val SpinnerIncentivoSer = findViewById<Spinner>(R.id.spinnerIncentivoSer)

        // --- Boton de busqueda de registros de Garantias¡´`

        Registro_Garantia.setOnClickListener {

            try {

                // --- Realizamos la consulta a la tabla Registro_De_Garantias¡´`

                val Resultado = "SELECT * FROM Registro_De_Garantias Order by Factura "

                val PreparedStatement = conn.prepareStatement(Resultado)
                val  ResultSet = PreparedStatement.executeQuery()

                val Listado_Factura = arrayListOf<Int>()
                val Listado_Garantia = arrayListOf<Int>()
                val Listado_Incentivos = arrayListOf<Int>()

                while (ResultSet.next()){

                        val Factura = ResultSet.getInt("Factura")
                        Listado_Factura.add(Factura)
                        val adaptador1 = ArrayAdapter(this, android.R.layout.simple_spinner_item, Listado_Factura )
                        SpinnerFactura.adapter = adaptador1

                        val Garantia = ResultSet.getInt("Garantia")
                        Listado_Garantia.add(Garantia)
                        val adaptador2 = ArrayAdapter(this, android.R.layout.simple_spinner_item, Listado_Garantia )
                        SpinnerGarantia.adapter = adaptador2

                        val Incentivos = ResultSet.getInt("Incentivos")
                        Listado_Incentivos.add(Incentivos)
                        val adaptador3 = ArrayAdapter(this, android.R.layout.simple_spinner_item, Listado_Incentivos )
                        SpinnerIncentivo.adapter = adaptador3

                    }

                Toast.makeText(this, "Busqueda Completada", Toast.LENGTH_SHORT).show()

            }catch (ex: SQLException){
                Toast.makeText(this,"Error", Toast.LENGTH_SHORT).show()
            }

            return@setOnClickListener

            }

        // --- Boton de busqueda de registros de Servicios¡´`

        Registro_Servicio.setOnClickListener {

            try {

                // --- Realizamos la consulta a la tabla Registro_De_Servicios¡´`

                val Resultado = "SELECT * FROM Registro_De_Servicios Order by Facturas"

                val PreparedStatement = conn.prepareStatement(Resultado)
                val  ResultSet = PreparedStatement.executeQuery()

                val Listado_Facturas = arrayListOf<Int>()
                val Listado_Servicio = arrayListOf<Int>()
                val Listado_Incentivo = arrayListOf<Int>()


                while (ResultSet.next()){

                    val Facturas = ResultSet.getInt("Facturas")
                    Listado_Facturas.add(Facturas)
                    val adaptador4 = ArrayAdapter(this, android.R.layout.simple_spinner_item, Listado_Facturas)
                    SpinnerFacturaSer.adapter = adaptador4

                    val Servicio = ResultSet.getInt("Servicio")
                    Listado_Servicio.add(Servicio)
                    val adaptador5 = ArrayAdapter(this, android.R.layout.simple_spinner_item, Listado_Servicio)
                    SpinnerGarantiaSer.adapter = adaptador5

                    val IncentivoSer = ResultSet.getInt("Incentivo")
                    Listado_Incentivo.add(IncentivoSer)
                    val adaptador6 = ArrayAdapter(this, android.R.layout.simple_spinner_item, Listado_Incentivo)
                    SpinnerIncentivoSer.adapter = adaptador6

                }

                Toast.makeText(this, "Busqueda Completada", Toast.LENGTH_SHORT).show()

            }catch (ex: SQLException){
                Toast.makeText(this,"Error", Toast.LENGTH_SHORT).show()
            }
        }
        }
    }
