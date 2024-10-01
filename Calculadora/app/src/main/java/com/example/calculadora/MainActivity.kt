package com.example.calculadora

import android.content.Intent
import android.content.pm.PackageManager
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat
import com.example.calculadora.R


class MainActivity : AppCompatActivity() {

    companion object{
        lateinit var nombre: EditText
        lateinit var boton: Button
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        nombre = findViewById<EditText>(R.id.usuario)
        boton = findViewById<Button>(R.id.botonId)

        boton.setOnClickListener{
            val intent = Intent(this, Calculadora::class.java)		// this es el contexto
            intent.putExtra("usuario", nombre.text.toString())
            startActivity(intent)
        }

        Log.d(":::Vida", "He creado el onCreate()")

    }

    override fun onStart() {
        super.onStart()
        Log.d(":::Vida", "He creado el onStart()")
    }

    override fun onResume() {
        super.onResume()
        val saludo = Toast.makeText(this, "Bienvenido de nuevo, " + nombre.text, Toast.LENGTH_SHORT)
        saludo.show()
        Log.d(":::Vida" , "He creado el onResume()")
    }

    override fun onPause() {
        super.onPause()
        setContentView(R.layout.pausa)
        Log.d(":::Vida" , "He creado el onPause()")
    }

    override fun onStop() {
        super.onStop()
//        var noti = NotificationCompat.Builder(this)
//        .setContentTitle("CLOSED")
//        .setContentText("Se ha cerrado la aplicacion")
//        .setPriority(NotificationCompat.PRIORITY_DEFAULT)
//
//    with(NotificationManagerCompat.from(this)) {
//        if (ActivityCompat.checkSelfPermission(
//                this@MainActivity,
//                Manifest.permission.POST_NOTIFICATIONS
//            ) != PackageManager.PERMISSION_GRANTED
//        ) {
//            // TODO: Consider calling
//            // ActivityCompat#requestPermissions
//            // here to request the missing permissions, and then overriding
//            // public fun onRequestPermissionsResult(requestCode: Int, permissions: Array<out String>,
//            //                                        grantResults: IntArray)
//            // to handle the case where the user grants the permission. See the documentation
//            // for ActivityCompat#requestPermissions for more details.
//
//            return@with
//        }
//        // notificationId is a unique int for each notification that you must define.
//        notify(1, noti.build())
//    }

        Log.d(":::Vida" , "He creado el onStop()")
    }
//
//    override fun onDestroy() {
//        super.onDestroy()
//        Log.d(":::Vida" , "He creado el onDestroy()")
//    }
//
//    override fun onRestart() {
//        super.onRestart()
//        Log.d(":::Vida" , "He creado el onRestart()")
//    }
}