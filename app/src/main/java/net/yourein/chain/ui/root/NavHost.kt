package net.yourein.chain.ui.root

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import net.yourein.chain.navigation.IdolTalk
import net.yourein.chain.navigation.Playground
import net.yourein.chain.navigation.Top
import net.yourein.chain.navigation.UnitTalk

@Composable
fun ChainNavHost(
    navController: NavHostController,
) {
    NavHost(
        navController = navController,
        startDestination = Top
    ) {
        composable<Top> {

        }
        composable<IdolTalk> {

        }
        composable<UnitTalk> {

        }
        composable<Playground> {
            // 大体はここのスコープの中でデバッグ用コードを書く
        }
    }
}