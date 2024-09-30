package Screen.nav

import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.platform.LocalContext

@Composable
fun ScreeenA(navController: NavHostController) {
    Button(onClick = { navController.navigate("screenB") }) {
        Text("Go to Screen B")
    }
}

@Composable
fun ScreenA(navController: NavHostController, onSaveContact: (Contact) -> Unit) {
    var firstName by remember { mutableStateOf("") }
    var phone by remember { mutableStateOf("") }
    var hobby by remember { mutableStateOf("") }
    var lastName by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        TextField(
            value = firstName,
            onValueChange = { firstName = it },
            label = { Text("Name") },
            modifier = Modifier
                .fillMaxWidth(0.8f)
                .padding(bottom = 16.dp)
        )
        TextField(
            value = lastName,
            onValueChange = { lastName = it },
            label = { Text("Last Name") },
            modifier = Modifier
                .fillMaxWidth(0.8f)
                .padding(bottom = 16.dp)
        )
        TextField(
            value = phone,
            onValueChange = { phone = it },
            label = { Text("Phone") },
            modifier = Modifier
                .fillMaxWidth(0.8f)
                .padding(bottom = 32.dp)
        )

        TextField(
            value = hobby,
            onValueChange = { hobby = it },
            label = { Text("Hobby") },
            modifier = Modifier
                .fillMaxWidth(0.8f)
                .padding(bottom = 32.dp)
        )
        Button(
            onClick = {
                if (firstName.isNotBlank() && lastName.isNotBlank() && phone.isNotBlank() && hobby.isNotBlank()) {
                    onSaveContact(Contact(firstName, lastName, phone, hobby))
                    navController.navigate("screenB")
                } else {
                    //Validaciones para que no se muestren registros vacios
                }
            },
            modifier = Modifier
                .fillMaxWidth(0.5f)
        ) {
            Text("Save Contact")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ScreenAPreview() {
    val context = LocalContext.current
    ScreenA(navController = NavHostController(context), onSaveContact = {})
}