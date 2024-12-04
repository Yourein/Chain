package net.yourein.chain

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.navigation.compose.rememberNavController
import net.yourein.chain.ui.root.ChainNavHost
import net.yourein.chain.ui.theme.ChainTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ChainTheme {
                ChainNavHost(
                    navController = rememberNavController()
                )
            }
        }
    }
}