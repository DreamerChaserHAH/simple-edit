import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.input.key.Key
import androidx.compose.ui.input.key.KeyShortcut
import androidx.compose.ui.window.DialogWindow
import androidx.compose.ui.window.MenuBar
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import com.darkrockstudios.libraries.mpfilepicker.FilePicker
import java.io.File

var filename by mutableStateOf("Untitled.md")
val defaultContent = "# This is a simple Markdown Editor!"
var content by  mutableStateOf(defaultContent)

fun main() = application {

    val contentState = remember { mutableStateOf(content) }

    Window(
        onCloseRequest = ::exitApplication,
        title = filename,
        resizable = true,
    ) {
        var showFilePicker by remember { mutableStateOf(false) }
        MenuBar {
            Menu("File") {
                Item(
                    "New",
                    onClick = {
                        contentState.value = defaultContent
                        filename = "Untitled.md"
                    },
                    shortcut = KeyShortcut(Key.N, ctrl = true)
                )
                Item(
                    "Open",
                    onClick = {
                        showFilePicker = true
                    },
                    shortcut = KeyShortcut(Key.O, ctrl = true)
                )
            }
        }
        App(contentState)
        FilePicker(show = showFilePicker, fileExtensions = listOf("md", "MD")) { platformFile ->
            showFilePicker = false
            if (platformFile != null) {
                filename = platformFile.path
                File(platformFile.path).readText().also {
                    contentState.value = it
                }
            }
        }

    }
}