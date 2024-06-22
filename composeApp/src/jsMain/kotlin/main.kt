import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.window.CanvasBasedWindow
import com.feraxhp.main.App
import org.jetbrains.skiko.wasm.onWasmReady

@OptIn(ExperimentalComposeUiApi::class)
private fun main() {
    onWasmReady {
        CanvasBasedWindow("feraxhp") {
            App()
        }
    }
}
