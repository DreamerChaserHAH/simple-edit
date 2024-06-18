import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.Image
import androidx.compose.foundation.VerticalScrollbar
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.material.TopAppBar
import androidx.compose.material.lightColors
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawWithCache
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.Density
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.TextUnitType
import androidx.compose.ui.unit.dp
import com.mikepenz.markdown.coil2.Coil2ImageTransformerImpl
import com.mikepenz.markdown.compose.LocalMarkdownColors
import com.mikepenz.markdown.compose.Markdown
import com.mikepenz.markdown.model.DefaultMarkdownColors
import com.mikepenz.markdown.model.DefaultMarkdownTypography
import com.mikepenz.markdown.model.MarkdownColors
import com.mikepenz.markdown.model.MarkdownTypography
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.ui.tooling.preview.Preview

import simpleedit.composeapp.generated.resources.Res
import simpleedit.composeapp.generated.resources.compose_multiplatform
import java.awt.Menu
import java.awt.MenuBar

@Composable
@Preview
fun App(content: MutableState<String>) {
    MaterialTheme {
        Box(
            modifier = Modifier.fillMaxSize()
        ){
            Row {
                val scrollState = rememberScrollState()

                TextField(
                    modifier = Modifier.fillMaxHeight().weight(1f),
                    value = content.value,
                    onValueChange = { content.value = it }
                )

                Markdown(
                    content.value,
                    modifier = Modifier.weight(1f).verticalScroll(scrollState),
                    imageTransformer = Coil2ImageTransformerImpl,
                    colors = DefaultMarkdownColors(text = Color.Black, codeText = Color.Black, inlineCodeText = Color.Black, linkText = Color.Blue, codeBackground = Color.LightGray, inlineCodeBackground = Color.LightGray, dividerColor = Color.Black),
                    typography = DefaultMarkdownTypography(
                        h1 = TextStyle(fontSize = TextUnit(32f, TextUnitType.Sp)),
                        h2 = TextStyle(fontSize = TextUnit(28f, TextUnitType.Sp)),
                        h3 = TextStyle(fontSize = TextUnit(24f, TextUnitType.Sp)),
                        h4 = TextStyle(fontSize = TextUnit(20f, TextUnitType.Sp)),
                        h5 = TextStyle(fontSize = TextUnit(18f, TextUnitType.Sp)),
                        h6 = TextStyle(fontSize = TextUnit(16f, TextUnitType.Sp)),
                        text = TextStyle(fontSize = TextUnit(12f, TextUnitType.Sp)),
                        code = TextStyle(fontSize = TextUnit(12f, TextUnitType.Sp)),
                        quote = TextStyle(fontSize = TextUnit(12f, TextUnitType.Sp)),
                        paragraph = TextStyle(fontSize = TextUnit(12f, TextUnitType.Sp)),
                        ordered = TextStyle(fontSize = TextUnit(12f, TextUnitType.Sp)),
                        bullet = TextStyle(fontSize = TextUnit(12f, TextUnitType.Sp)),
                        list =  TextStyle(fontSize = TextUnit(12f, TextUnitType.Sp))
                    )
                )
            }
        }
    }
}