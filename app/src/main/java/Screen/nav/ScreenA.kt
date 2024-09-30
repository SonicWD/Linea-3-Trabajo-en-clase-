package Screen.nav

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ScreenA(navController: NavHostController, onSaveContact: (Contact) -> Unit) {
    var firstName by remember { mutableStateOf("") }
    var lastName by remember { mutableStateOf("") }
    var phone by remember { mutableStateOf("") }
    var hobby by remember { mutableStateOf("") }
    var showErrors by remember { mutableStateOf(false) }

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Add New Contact") },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primaryContainer,
                    titleContentColor = MaterialTheme.colorScheme.onPrimaryContainer
                )
            )
        }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .padding(horizontal = 16.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            OutlinedTextField(
                value = firstName,
                onValueChange = { firstName = it },
                label = { Text("First Name") },
                isError = showErrors && firstName.isBlank(),
                modifier = Modifier.fillMaxWidth()
            )
            if (showErrors && firstName.isBlank()) {
                Text("First name is required", color = Color.Red, textAlign = TextAlign.Start, modifier = Modifier.fillMaxWidth())
            }

            OutlinedTextField(
                value = lastName,
                onValueChange = { lastName = it },
                label = { Text("Last Name") },
                isError = showErrors && lastName.isBlank(),
                modifier = Modifier.fillMaxWidth()
            )
            if (showErrors && lastName.isBlank()) {
                Text("Last name is required", color = Color.Red, textAlign = TextAlign.Start, modifier = Modifier.fillMaxWidth())
            }

            OutlinedTextField(
                value = phone,
                onValueChange = { phone = it },
                label = { Text("Phone") },
                isError = showErrors && phone.isBlank(),
                modifier = Modifier.fillMaxWidth()
            )
            if (showErrors && phone.isBlank()) {
                Text("Phone is required", color = Color.Red, textAlign = TextAlign.Start, modifier = Modifier.fillMaxWidth())
            }

            OutlinedTextField(
                value = hobby,
                onValueChange = { hobby = it },
                label = { Text("Hobby") },
                isError = showErrors && hobby.isBlank(),
                modifier = Modifier.fillMaxWidth()
            )
            if (showErrors && hobby.isBlank()) {
                Text("Hobby is required", color = Color.Red, textAlign = TextAlign.Start, modifier = Modifier.fillMaxWidth())
            }

            Spacer(modifier = Modifier.weight(1f))

            Button(
                onClick = {
                    if (firstName.isNotBlank() && lastName.isNotBlank() && phone.isNotBlank() && hobby.isNotBlank()) {
                        onSaveContact(Contact(firstName, lastName, phone, hobby))
                        navController.navigate("screenB")
                    } else {
                        showErrors = true
                    }
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 16.dp)
            ) {
                Text("Save Contact")
            }
        }
    }
}

@Composable
fun ScreenAPreview() {
    MaterialTheme {
        ScreenA(navController = rememberNavController(), onSaveContact = {})
    }
}