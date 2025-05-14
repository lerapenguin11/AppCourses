import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.designsystem.theme.AppTheme
import com.example.navigation.BottomBarRoute
import com.example.navigation.BottomNavigationItems

@Composable
fun BottomAppBar(
    navController: NavController,
    modifier: Modifier = Modifier,
    onNavigationSelected: (String) -> Unit,
) {
    var selectedItemRoute: String? by rememberSaveable { mutableStateOf(BottomNavigationItems[0].route.route) }

    DisposableEffect(navController) {
        val listener = NavController.OnDestinationChangedListener { _, destination, _ ->
            when (destination.route) {
                BottomBarRoute.Home.route,
                BottomBarRoute.Favorite.route,
                BottomBarRoute.Profile.route -> {
                    selectedItemRoute = destination.route
                }
            }
        }
        navController.addOnDestinationChangedListener(listener)
        onDispose {
            navController.removeOnDestinationChangedListener(listener)
        }
    }

    BottomBarContainer {
        NavigationBar(
            containerColor = AppTheme.colors.darkGray,
        ) {
            BottomNavigationItems.forEach { destination ->
                NavigationBarItem(
                    selected = selectedItemRoute == destination.route.route,
                    onClick = {
                        onNavigationSelected(destination.route.route)
                    },
                    icon = {
                        Icon(
                            painter = painterResource(destination.icon),
                            contentDescription = stringResource(destination.title),
                        )
                    },
                    label = {
                        Text(
                            text = stringResource(destination.title),
                            style = AppTheme.typography.buttonSmall
                        )
                    },
                    colors = NavigationBarItemDefaults.colors(
                        indicatorColor = AppTheme.colors.lightGray,
                        unselectedIconColor = AppTheme.colors.white,
                        unselectedTextColor = AppTheme.colors.white,
                        selectedIconColor = AppTheme.colors.green,
                        selectedTextColor = AppTheme.colors.green
                    ),
                )
            }
        }
    }
}

@Composable
private fun BottomBarContainer(
    modifier: Modifier = Modifier,
    content: @Composable () -> Unit,
) {
    Box(
        modifier = modifier.fillMaxWidth(),
        contentAlignment = Alignment.TopStart
    ) {
        content()
        HorizontalDivider(
            color = AppTheme.colors.stroke,
            thickness = (1.5).dp
        )
    }
}

@Preview
@Composable
private fun BottomBarPreview() {
    BottomAppBar(
        navController = rememberNavController(),
        onNavigationSelected = {}
    )
}