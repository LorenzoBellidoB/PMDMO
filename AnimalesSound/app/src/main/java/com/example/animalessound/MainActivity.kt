package com.example.animalessound

import android.hardware.Sensor
import android.hardware.SensorEvent
import android.hardware.SensorEventListener
import android.hardware.SensorManager
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.media3.common.MediaItem
import androidx.media3.exoplayer.ExoPlayer
import com.example.animalessound.ui.theme.AnimalesSoundTheme
import java.lang.Thread.sleep

class MainActivity : ComponentActivity(), SensorEventListener {

    private lateinit var sensorManager: SensorManager
    private var accelerometer: Sensor? = null
    private lateinit var glassBreakPlayer: ExoPlayer

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        // Configura el acelerómetro
        sensorManager = getSystemService(SENSOR_SERVICE) as SensorManager
        accelerometer = sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER)

        // Inicializa el reproductor para el sonido de cristal roto
        glassBreakPlayer = ExoPlayer.Builder(this).build().apply {
            val resourceId = resources.getIdentifier("cristal_roto", "raw", packageName)
            setMediaItem(MediaItem.fromUri("android.resource://${packageName}/${resourceId}"))
            prepare()
        }

        setContent {
            AnimalesSoundTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.primary
                ) {
                    AnimalesGrid()
                }
            }
        }
    }

    override fun onResume() {
        super.onResume()
        // Registra el listener del sensor
        accelerometer?.let {
            sensorManager.registerListener(this, it, SensorManager.SENSOR_DELAY_UI)
        }
    }

    override fun onPause() {
        super.onPause()
        // Desregistra el listener del sensor para ahorrar batería
        sensorManager.unregisterListener(this)
    }

    override fun onDestroy() {
        super.onDestroy()
        // Libera el reproductor de sonido
        glassBreakPlayer.release()
    }

    /**
     * Detecta cambios en el sensor de acelerómetro.
     */
    override fun onSensorChanged(event: SensorEvent?) {
        event?.let {
            val x = it.values[0]
            val y = it.values[1]
            val z = it.values[2]

            // Calcula la magnitud del movimiento
            val magnitude = Math.sqrt((x * x + y * y + z * z).toDouble()).toFloat()

            // Si el movimiento supera el umbral, reproduce el sonido
            if (magnitude > 15) { // Umbral ajustable
                if (!glassBreakPlayer.isPlaying) {
                    glassBreakPlayer.seekTo(0) // Reinicia el sonido si ya se estaba reproduciendo
                    glassBreakPlayer.play()
                }
            }
        }
    }

    override fun onAccuracyChanged(sensor: Sensor?, accuracy: Int) {
        // No es necesario manejar cambios de precisión en este caso
    }
}

/**
 * Muestra una cuadrícula de imágenes de animales que reproducen sonidos al hacer clic.
 */
@Composable
fun AnimalesGrid() {
    val listaAnimales = listOf("buho", "cerdo", "gallina", "gato", "oveja", "pajaro", "perro")

    LazyVerticalGrid(
        columns = GridCells.Fixed(2),
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
            .background(Color(0xFFFCE4EC)), // Fondo rosado claro
        verticalArrangement = Arrangement.SpaceEvenly
    ) {
        items(listaAnimales.size) { index ->
            AnimalCard(animal = listaAnimales[index])
        }
    }
}

/**
 * Muestra la tarjeta de un animal con su imagen y nombre, y reproduce su sonido al hacer clic.
 */
@Composable
fun AnimalCard(animal: String) {
    val context = LocalContext.current
    val resourceId = context.resources.getIdentifier(animal, "drawable", context.packageName)
    val resourceAu = context.resources.getIdentifier(animal, "raw", context.packageName)
    val player = ExoPlayerView()

    Box(
        modifier = Modifier
            .padding(8.dp)
            .background(Color(0xFFFFF59D), shape = MaterialTheme.shapes.medium) // Fondo amarillo pastel
            .clickable {
                val mediaItem = MediaItem.fromUri("android.resource://${context.packageName}/${resourceAu}")
                player.setMediaItem(mediaItem)
                player.prepare()
                player.play()
            }
            .padding(8.dp),
        contentAlignment = Alignment.Center
    ) {
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Image(
                painter = painterResource(resourceId),
                contentDescription = animal,
                modifier = Modifier
                    .width(120.dp)
                    .height(120.dp),
                contentScale = ContentScale.Crop
            )
            Text(
                text = animal.replaceFirstChar { it.uppercase() }, // Nombre capitalizado
                fontSize = 18.sp,
                color = Color(0xFF5D4037), // Marrón amigable
                modifier = Modifier.padding(top = 8.dp)
            )
        }
    }
}

/**
 * Crea y administra un ExoPlayer para reproducir un sonido de animal.
 */
@Composable
fun ExoPlayerView(): ExoPlayer {
    val context = LocalContext.current
    val player = remember {
        ExoPlayer.Builder(context).build()

    }
    DisposableEffect(Unit) {
        onDispose { player.release() }
    }

    return player
}
