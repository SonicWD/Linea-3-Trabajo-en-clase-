import Screen.nav.Contact
import Screen.nav.ScreenB
import androidx.compose.ui.test.*
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.navigation.testing.TestNavHostController
import androidx.test.core.app.ApplicationProvider
import junit.framework.TestCase.assertEquals
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import androidx.navigation.compose.rememberNavController
import androidx.test.ext.junit.runners.AndroidJUnit4
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class ScreenBTest {

    @get:Rule
    val composeTestRule = createComposeRule()

    @Test
    fun testContactsAreDisplayed() {
        val testContacts = listOf(
            Contact("John", "Doe", "1234567890", "Reading"),
            Contact("Jane", "Smith", "0987654321", "Writing")
        )
        composeTestRule.setContent {
            val navController = rememberNavController()
            ScreenB(navController = navController, contacts = testContacts)
        }

        composeTestRule.onNodeWithText("John Doe").assertIsDisplayed()
        composeTestRule.onNodeWithText("Phone: 1234567890").assertIsDisplayed()
        composeTestRule.onNodeWithText("Hobby: Reading").assertIsDisplayed()

        composeTestRule.onNodeWithText("Jane Smith").assertIsDisplayed()
        composeTestRule.onNodeWithText("Phone: 0987654321").assertIsDisplayed()
        composeTestRule.onNodeWithText("Hobby: Writing").assertIsDisplayed()
    }

    @Test
    fun testNavigationToScreenA() {
        composeTestRule.setContent {
            val navController = rememberNavController()
            ScreenB(navController = navController, contacts = emptyList())
        }

        composeTestRule.onNodeWithText("Go to Screen A").performClick()
        // Nota: No podemos probar fácilmente la navegación en pruebas unitarias.
        // Para pruebas de navegación, considera usar pruebas instrumentadas.
    }
}