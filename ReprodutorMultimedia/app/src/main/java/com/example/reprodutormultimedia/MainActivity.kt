package com.example.reprodutormultimedia
import android.os.Bundle
import android.view.ViewGroup
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.*
import androidx.compose.ui.viewinterop.AndroidView
import androidx.compose.ui.Modifier
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.media3.common.MediaItem
import androidx.media3.exoplayer.ExoPlayer
import androidx.media3.ui.PlayerView

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MaterialTheme {
                var localContext = LocalContext.current
                Column(Modifier.padding(20.dp)) {
                    Text(text = "Reproductor de Video")
                    VideoPlayerScreen(videoUrl = "https://cdn.pixabay.com/video/2024/02/09/199958-911694865_large.mp4")
                    Text(text = "Reproductor de Audio")
                    AudioPlayer(audioUrl = "android.resource://${localContext.packageName}/${R.raw.vermelho}")
                }

            }
        }
    }
}

@Composable
fun VideoPlayerScreen(videoUrl: String) {
    val context = LocalContext.current

    // Remember the player instance to manage its lifecycle
    val exoPlayer = remember {
        ExoPlayer.Builder(context).build().apply {
            val mediaItem = MediaItem.fromUri(videoUrl)
            setMediaItem(mediaItem)
            prepare()
        }
    }

    // Release the player when the Composable is disposed
    DisposableEffect(Unit) {
        onDispose { exoPlayer.release() }
    }

    Column(modifier = Modifier.fillMaxWidth()) {

        Spacer(modifier = Modifier.height(16.dp))
        AndroidView(
            factory = { ctx ->
                PlayerView(ctx).apply {
                    player = exoPlayer
                    layoutParams = ViewGroup.LayoutParams(
                        ViewGroup.LayoutParams.MATCH_PARENT,
                        ViewGroup.LayoutParams.WRAP_CONTENT
                    )
                }
            },
            modifier = Modifier.fillMaxWidth()
        )
    }
}

@Composable
fun AudioPlayer(audioUrl: String){
    val context = LocalContext.current
    val exoPlayer = remember {
        ExoPlayer.Builder(context).build().apply {
            setMediaItem(MediaItem.fromUri(audioUrl))
            prepare()
        }
    }

    DisposableEffect(Unit) {
        onDispose { exoPlayer.release() }
    }

    Column(modifier = Modifier.fillMaxWidth()) {

        Spacer(modifier = Modifier.height(16.dp))
        AndroidView(
            factory = { ctx ->
                PlayerView(ctx).apply {
                    player = exoPlayer
                    layoutParams = ViewGroup.LayoutParams(
                        ViewGroup.LayoutParams.MATCH_PARENT,
                        ViewGroup.LayoutParams.WRAP_CONTENT
                    )
                }
            },
            modifier = Modifier.fillMaxWidth()
        )
    }

}

@Preview(showBackground = true)
@Composable
fun PreviewVideoPlayerScreen() {
    MaterialTheme {
        VideoPlayerScreen(videoUrl = "https://youtu.be/6Uu2mpXE-mQ?feature=shared")
    }
}
