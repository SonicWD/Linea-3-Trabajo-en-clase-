package Screen.nav

import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun ScreeenB(navController: NavHostController) {
    Button(onClick = { navController.navigate("screenA") }) {
        Text("Go to Screen A")
    }
}

@Composable
fun ScreenB(navController: NavHostController, contacts: List<Contact>) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        contacts.forEach { contact ->
            Text(
                text = "Name: ${contact.firstName}, lastName: ${contact.lastName}, Phone: ${contact.phone}, hobby: ${contact.hobby}",
                modifier = Modifier.padding(vertical = 8.dp)
            )
        }
        Spacer(modifier = Modifier.height(24.dp))
        Button(
            onClick = { navController.navigate("screenA") },
            modifier = Modifier
                .fillMaxWidth(0.5f)
                .padding(vertical = 8.dp)
        ) {
            Text("Go to Screen A")
        }
    }
}
