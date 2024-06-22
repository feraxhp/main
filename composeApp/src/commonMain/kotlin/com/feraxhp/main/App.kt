package com.feraxhp.main

import androidx.compose.animation.core.*
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import compose.icons.FeatherIcons
import compose.icons.feathericons.Github
import feraxhp.nestodo.app.theme.AppTheme
import feraxhp.nestodo.app.theme.LocalThemeIsDark
import main.composeapp.generated.resources.*
import org.jetbrains.compose.resources.Font
import org.jetbrains.compose.resources.stringResource
import org.jetbrains.compose.resources.vectorResource

@Composable
internal fun App() = AppTheme {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center,
    ) {
        var isDark by LocalThemeIsDark.current
        val icon = remember(isDark) {
            if (isDark) Res.drawable.ic_light_mode
            else Res.drawable.ic_dark_mode
        }

        ElevatedButton(
            modifier = Modifier
                .padding(horizontal = 8.dp, vertical = 4.dp)
                .wrapContentWidth(align = Alignment.CenterHorizontally)
                .align(Alignment.TopEnd)
            ,
            onClick = { isDark = !isDark },
            content = {
                Icon(vectorResource(icon), contentDescription = null)
                Spacer(Modifier.size(ButtonDefaults.IconSpacing))
                Text(stringResource(Res.string.theme))
            }
        )
        Column (
            modifier = Modifier.padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally

        ) {
            Text(
                text = "Hello!",
                style = MaterialTheme.typography.titleLarge,
                fontSize = 56.sp,
                textAlign = TextAlign.Center
            )

            Text(
                text = "This web is under construction.\n Please check it back later.",
                textAlign = TextAlign.Center
            )

            Spacer(Modifier.size(48.dp))

            ElevatedButton(
                onClick = { openUrl("https://www.github.com/feraxhp") },
                content = {
                    Icon(
                        imageVector = FeatherIcons.Github,
                        tint = MaterialTheme.colorScheme.primary,
                        contentDescription = null,
                        modifier = Modifier.size(24.dp)
                    )
                    Spacer(Modifier.size(ButtonDefaults.IconSpacing))
                    Text("GitHub")
                }
            )
        }

    }
}

internal expect fun openUrl(url: String?)