package net.yourein.chain.ui.root

import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import net.yourein.chain.navigation.GroupMembers
import net.yourein.chain.navigation.IdolProfile
import net.yourein.chain.navigation.IdolTalk
import net.yourein.chain.navigation.Playground
import net.yourein.chain.navigation.Top
import net.yourein.chain.navigation.UnitTalk
import net.yourein.chain.ui.top.TopScreen
import net.yourein.chain.ui.top.TopScreenViewModel

@Composable
fun ChainNavHost(
    navController: NavHostController,
) {
    NavHost(
        navController = navController,
        startDestination = Top
    ) {
        composable<Top> {
            val topScreenViewModel: TopScreenViewModel = viewModel()
            TopScreen(
                viewModel = topScreenViewModel,
            )
        }
        composable<IdolTalk> {

        }
        composable<UnitTalk> {

        }
        composable<IdolProfile> {

        }
        composable<GroupMembers> {

        }
        composable<Playground> {
            // 大体はここのスコープの中でデバッグ用コードを書く
        }
    }
}