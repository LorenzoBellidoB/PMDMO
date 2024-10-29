package com.example.permisoscomunicacion

import android.bluetooth.BluetoothManager
import android.content.Context
import android.content.Context.CONNECTIVITY_SERVICE
import android.location.LocationManager
import android.net.ConnectivityManager
import android.net.NetworkCapabilities
import android.net.wifi.WifiManager
import android.nfc.NfcAdapter
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import com.example.permisoscomunicacion.ui.theme.PermisosComunicacionTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            PermisosComunicacionTheme {

                var context: Context = LocalContext.current.applicationContext



                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Inicio(
                        modifier = Modifier.padding(innerPadding).height(50.dp).size(50.dp),
                        context
                    )
                }
            }
        }
    }
}

fun wifiFunciona(context: Context){

    val connectivityManager = context.getSystemService(CONNECTIVITY_SERVICE) as ConnectivityManager
    val networkCapabilities = connectivityManager.getNetworkCapabilities(
        connectivityManager.activeNetwork
    )
    val isConnected = networkCapabilities?.hasCapability(
        NetworkCapabilities.NET_CAPABILITY_INTERNET
    ) == true
}

fun wifiActivo(context: Context): Boolean {
    val wifiManager = context.getSystemService(Context.WIFI_SERVICE) as WifiManager
    return wifiManager.isWifiEnabled
}

fun bluetoothActivo(context: Context): Boolean {
    val bluetoothManager = context.getSystemService(Context.BLUETOOTH_SERVICE) as BluetoothManager
    val bluetoothAdapter = bluetoothManager.adapter

    return bluetoothAdapter != null && bluetoothAdapter.isEnabled
}

fun NFCActivo(context: Context): Boolean {
    val nfcAdapter: NfcAdapter? = NfcAdapter.getDefaultAdapter(context)
    return nfcAdapter != null && nfcAdapter.isEnabled
}

fun GPSActivo(context: Context): Boolean {
    val locationManager = context.getSystemService(Context.LOCATION_SERVICE) as LocationManager
    return locationManager.isProviderEnabled(LocationManager.GPS_PROVIDER)
}

@Composable
fun Inicio(modifier: Modifier = Modifier, context: Context) {
    Column(horizontalAlignment = Alignment.CenterHorizontally){

        Spacer(Modifier.size(10.dp))

        Row(){
            Text(
                text = "Wifi:"
            )
            if(wifiActivo(context)) {
                Box(
                    modifier.background(Color.Green)
                )
            }else{
                Box(
                    modifier.background(Color.Red)
                )
            }
        }

        Spacer(Modifier.size(10.dp))

        Row(){
            Text(
                text = "Bluetooth:"
            )
            if(bluetoothActivo(context)) {
                Box(
                    modifier.background(Color.Green)
                )
            }else{
                Box(
                    modifier.background(Color.Red)
                )
            }
        }

        Spacer(Modifier.size(10.dp))

        Row(){
            Text(
                text = "NFC:"
            )
            if(NFCActivo(context)) {
                Box(
                    modifier.background(Color.Green)
                )
            }else{
                Box(
                    modifier.background(Color.Red)
                )
            }
        }

        Spacer(Modifier.size(10.dp))

        Row(){
            Text(
                text = "GPS:"
            )
            if(GPSActivo(context)) {
                Box(
                    modifier.background(Color.Green)
                )
            }else{
                Box(
                    modifier.background(Color.Red)
                )
            }
        }
    }
}

