package com.iesnervion.cursoandroid_07

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        variablesYconstantes()  // Mostrará 4, 32, 7 y un texto
        tiposNumericos()    // Mostrará 20 y 20.345669
        operadores()    // Usar Debug para visualizar valores
        valoresNulos()  // Mostrará si el valor es Nulo o No es Nulo
        var resultado:Int=realizaSuma(12,48)    // 60
        Log.d(":::Tag",resultado.toString())
    }

    private fun variablesYconstantes() {
        var numero: Int     // Declaración de variable tipo entero
        numero = 4          // Asignación de valor
        // var numero:Int = 4  // Unión de ambas líneas
        muestraMensaje(numero.toString())

        numero *= 8         // Operación
        muestraMensaje(numero.toString())

        val otroNumero: Int = 7     // Declaración de constante con inicialización a 7
        // otroNumero = 1   // Esto provoca un error ya que las constantes no se pueden modificar
        muestraMensaje(otroNumero.toString())

        val texto: String = "Esto es un texto"  // Declaración de variable tipo texto
        muestraMensaje(texto)
    }

    private fun tiposNumericos() {
        var decimal: Int = 8
        var otroDecimal: Float = 12.34567F
        // decimal += otroDecimal No pueden sumarse
        var sumaEntera=decimal+otroDecimal.toInt()    // Sumará su parte entera = 20
        var sumaDecimal=otroDecimal+decimal.toFloat()    // Sumará la parte entera y la decimal
        val verdadero: Boolean = true
        val falso: Boolean = false
        Log.d(":::Tag",sumaEntera.toString())
        Log.d(":::Tag",sumaDecimal.toString())
    }

    private fun operadores() {
        val num1: Int = 3
        val num2: Int = 8
        var suma: Int = num1 + num2
        var resta: Int = num2 - num1
        var multiplicacion: Int = num1 * num2
        var division: Int = num2 / num1
        var resto:Int = num2 % num1
        var igualdad:Boolean = num1 == num2     // Toma el valor false
        var diferente:Boolean = num1 != num2    // Toma el valor true
        var menor:Boolean = num1 < num2 || num1 > num2
    }
    private fun valoresNulos(){
        //val nullString: String = null       // Los Strings no pueden ser nulos
        val nullString: String? = null      // Se indica que podría ser nulo
        nullString?.let {   // El código se ejecuta cuando no sea nulo
            Log.d(":::Tag", "El valor no es nulo")
        }?:run{
            Log.e(":::Tag", "El valor es nulo")
        }
    }

    private fun muestraMensaje(mensaje: String) {
        Log.d(":::Tag", "El dato introducido es $mensaje")
    }
    
    // Funcion Inline
    private fun realizaSuma(num1: Int, num2: Int): Int = num1 + num2
}