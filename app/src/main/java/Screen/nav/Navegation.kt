import Screen.nav.Contact
import Screen.nav.ScreenA
import Screen.nav.ScreenB
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController


@Composable
fun Navegation() {
    val navController = rememberNavController()
    val contacts = remember { mutableStateListOf<Contact>() }

    NavHost(navController = navController, startDestination = "screenA") {
        composable("screenA") {
            ScreenA(navController) { contact ->
                contacts.add(contact)
            }
        }
        composable("screenB") {
            ScreenB(navController, contacts)
        }
    }
}