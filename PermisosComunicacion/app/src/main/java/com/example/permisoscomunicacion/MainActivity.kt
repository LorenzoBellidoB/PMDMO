package com.example.permisoscomunicacion

import android.annotation.SuppressLint
import android.content.Context
import android.net.NetworkCapabilities
import android.net.wifi.WifiManager
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import com.example.permisoscomunicacion.ui.theme.PermisosComunicacionTheme
import android.net.ConnectivityManager as ConnectivityManager1

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            PermisosComunicacionTheme {
                var context: Context = LocalContext.current.applicationContext



                Inicio(context)

            }
        }

    }

    @Composable
    fun Inicio(context: Context){
        Column {
            Wifi(context)
            Red(context)
            Ubicacion(context)
            Nfc(context)
            Bluetooth(context)
        }
    }

    fun WifiActivo(context: Context): Boolean {
        val wifiManager = context.getSystemService(Context.WIFI_SERVICE) as WifiManager
        return wifiManager.isWifiEnabled
    }

    fun RedActivo(context: Context): Boolean {
        val wifiManager = context.getSystemService(Context.WIFI_SERVICE) as WifiManager
        return wifiManager.isWifiEnabled
    }

    fun UbicacionActivo(context: Context): Boolean {
        val wifiManager = context.getSystemService(Context.WIFI_SERVICE) as WifiManager
        return wifiManager.isWifiEnabled
    }

    fun NfcActivo(context: Context): Boolean {
        val wifiManager = context.getSystemService(Context.WIFI_SERVICE) as WifiManager
        return wifiManager.isWifiEnabled
    }

    fun BluetoothActivo(context: Context): Boolean {
        val wifiManager = context.getSystemService(Context.WIFI_SERVICE) as WifiManager
        return wifiManager.isWifiEnabled
    }

    @Composable
    fun Wifi(context: Context){

        if(WifiActivo(context)){
            Text(text = "WIFI",
                Modifier.background(Color.Green))
        }else{
            Text(text = "WIFI",
                Modifier.background(Color.Red))
        }

    }
    @Composable
    fun Red(context: Context){
        if(RedActivo(context)){
            Text(text = "WIFI",
                Modifier.background(Color.Green))
        }else{
            Text(text = "WIFI",
                Modifier.background(Color.Red))
        }
    }
    @Composable
    fun Ubicacion(context: Context){
        Text(text = "GPS")
    }
    @Composable
    fun Nfc(context: Context){
        Text(text = "NFC")
    }
    @Composable
    fun Bluetooth(context: Context){
        Text(text = "Bluetooth")
    }
}

