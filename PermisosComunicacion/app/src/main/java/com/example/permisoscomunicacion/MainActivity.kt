package com.example.permisoscomunicacion

import android.annotation.SuppressLint
import android.bluetooth.BluetoothManager
import android.content.Context
import android.location.LocationManager
import android.net.NetworkCapabilities
import android.net.wifi.WifiManager
import android.nfc.NfcAdapter
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
            /*Red(context)
            Ubicacion(context)
            Nfc(context)
            Bluetooth(context)*/
        }
    }

    fun WifiActivo(context: Context): Boolean {
        val wifiManager = context.getSystemService(Context.WIFI_SERVICE) as WifiManager
        return wifiManager.isWifiEnabled
    }

    /*fun RedActivo(context: Context): Boolean {
        val redManager = context.getSystemService(Context.CONNECTIVITY_SERVICE) as WifiManager
        return redManager.isWifiEnabled
    }

    fun UbicacionActivo(context: Context): Boolean {
        val locationManager = context.getSystemService(Context.LOCATION_SERVICE) as LocationManager
        val isGPSEnabled = locationManager.isProviderEnabled(LocationManager.GPS_PROVIDER)
        return isGPSEnabled
    }

    fun NfcActivo(context: Context): Boolean {
        val nfcAdapter: NfcAdapter? = NfcAdapter.getDefaultAdapter(context)
        return nfcAdapter != null && nfcAdapter.isEnabled

    }

    fun BluetoothActivo(context: Context): Boolean {
        val bluetoothManager = context.getSystemService(Context.BLUETOOTH_SERVICE) as BluetoothManager
        val bluetoothAdapter = bluetoothManager.adapter
        return bluetoothAdapter != null && bluetoothAdapter.isEnabled

    }*/

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
    /*@Composable
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
        if(UbicacionActivo(context)){
            Text(text = "GPS",
                Modifier.background(Color.Green))
        }else{
            Text(text = "GPS",
                Modifier.background(Color.Red))
        }
    }
    @Composable
    fun Nfc(context: Context){
        if(NfcActivo(context)){
            Text(text = "NFC",
                Modifier.background(Color.Green))
        }else{
            Text(text = "NFC",
                Modifier.background(Color.Red))
        }
    }
    @Composable
    fun Bluetooth(context: Context){
        if(BluetoothActivo(context)){
            Text(text = "Bluetooth",
                Modifier.background(Color.Green))
        }else{
            Text(text = "Bluetooth",
                Modifier.background(Color.Red))
        }
    }*/
}

