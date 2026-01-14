package pixelcell

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application

fun main() = application {
    Window(
        onCloseRequest = ::exitApplication,
        title = "Pixel Cell"
    ) {
        MaterialTheme {
            EditorLayout()
        }
    }
}

/* ---------- ROOT LAYOUT ---------- */

@Composable
fun EditorLayout() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFF1E1E1E))
    ) {

        // Main editor area
        Row(
            modifier = Modifier.weight(1f)
        ) {
            CanvasArea(
                modifier = Modifier.weight(1f)
            )

            PropertiesPanel()
        }

        // Status bar
        StatusBar()
    }
}

/* ---------- CENTER CANVAS ---------- */

@Composable
fun CanvasArea(
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier
            .fillMaxHeight()
            .padding(8.dp)
            .background(Color(0xFF1B1B1B))
            .border(1.dp, Color(0xFF3C7DD9)),
        contentAlignment = Alignment.Center
    ) {
        Text("Canvas", color = Color.Gray)
    }
}

/* ---------- RIGHT PANEL ---------- */

@Composable
fun PropertiesPanel() {
    Column(
        modifier = Modifier
            .width(260.dp)
            .fillMaxHeight()
            .background(Color(0xFF2A2A2A))
            .padding(12.dp)
    ) {
        Text(
            text = "Properties",
            style = MaterialTheme.typography.titleMedium,
            color = Color.White
        )

        Spacer(Modifier.height(12.dp))

        PropertyItem("Width", "1920")
        PropertyItem("Height", "1080")
        PropertyItem("FPS", "60")
    }
}

@Composable
fun PropertyItem(
    label: String,
    value: String
) {
    Column(
        modifier = Modifier.padding(vertical = 6.dp)
    ) {
        Text(
            text = label,
            color = Color.LightGray,
            style = MaterialTheme.typography.labelSmall
        )

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(28.dp)
                .background(Color(0xFF3A3A3A)),
            contentAlignment = Alignment.CenterStart
        ) {
            Text(
                text = value,
                modifier = Modifier.padding(start = 8.dp),
                color = Color.White
            )
        }
    }
}

/* ---------- STATUS BAR ---------- */

@Composable
fun StatusBar() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(28.dp)
            .background(Color(0xFF007ACC))
            .padding(horizontal = 12.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text("Ready", color = Color.White)
        Spacer(Modifier.weight(1f))
        Text("Zoom: 100%", color = Color.White)
    }
}
