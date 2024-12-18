package net.yourein.chain.ui.common

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.WindowInsetsSides
import androidx.compose.foundation.layout.only
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeDrawing
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarColors
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import net.yourein.chain.ui.theme.ChainPrimary
import net.yourein.chain.ui.theme.ChainWhite

@OptIn(ExperimentalMaterial3Api::class)
private val ChainTopAppBarColors: TopAppBarColors
    @Composable get() {
        return TopAppBarDefaults
            .centerAlignedTopAppBarColors()
            .copy(
                containerColor = ChainPrimary,
                titleContentColor = ChainWhite,
                navigationIconContentColor = ChainWhite,
                actionIconContentColor = ChainWhite,
            )
    }

@Composable
fun ChainTopBar(
    title: @Composable () -> Unit,
    navigationIcon: @Composable () -> Unit = {},
    actions: @Composable (RowScope.() -> Unit) = {},
) {
    @OptIn(ExperimentalMaterial3Api::class)
    CenterAlignedTopAppBar(
        title = title,
        navigationIcon = navigationIcon,
        actions = actions,
        colors = ChainTopAppBarColors,
        windowInsets = WindowInsets.safeDrawing.only(
            WindowInsetsSides.Top + WindowInsetsSides.Horizontal
        )
    )
}

@Composable
fun ChainTitleText() {
    Text(
        text = "CHAIN",
        fontWeight = FontWeight.ExtraBold,
        fontSize = 40.sp
    )
}

@Composable
fun ChainBackArrow(
    onClick: () -> Unit,
) {
    Icon(
        imageVector = Icons.AutoMirrored.Filled.ArrowBack,
        contentDescription = null,
        modifier = Modifier
            .padding(start = 8.dp)
            .clickable(
                onClick = onClick,
            )
    )
}

@Composable
fun ChainActionMenu(
    onClick: () -> Unit,
) {
    Icon(
        imageVector = Icons.Filled.Menu,
        contentDescription = null,
        modifier = Modifier
            .padding(end = 8.dp)
            .clickable(
                onClick = onClick,
            )
    )
}

@Preview(showBackground = true)
@Composable
private fun ChainTopBarPreview() {
    ChainTopBar(
        title = {
            ChainTitleText()
        },
        navigationIcon = {
            ChainBackArrow(
                onClick = {},
            )
        },
        actions = {
            ChainActionMenu(
                onClick = {},
            )
        }
    )
}