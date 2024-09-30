import Screen.nav.Contact
import Screen.nav.ScreenA
import Screen.nav.ScreenB
import androidx.compose.ui.test.*
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.navigation.compose.rememberNavController
import androidx.navigation.testing.TestNavHostController
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import junit.framework.TestCase.assertEquals
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith


@RunWith(AndroidJUnit4::class)
class ScreenATest {

    @get:Rule
    val composeTestRule = createComposeRule()

    @Test
    fun testEmptyFieldsShowErrors() {
        composeTestRule.setContent {
            val navController = rememberNavController()
            ScreenA(navController = navController, onSaveContact = {})
        }

        composeTestRule.onNodeWithText("Save Contact").performClick()

        composeTestRule.onNodeWithText("First name is required").assertIsDisplayed()
        composeTestRule.onNodeWithText("Last name is required").assertIsDisplayed()
        composeTestRule.onNodeWithText("Phone is required").assertIsDisplayed()
        composeTestRule.onNodeWithText("Hobby is required").assertIsDisplayed()
    }

    @Test
    fun testValidInputSavesContact() {
        var savedContact: Contact? = null
        composeTestRule.setContent {
            val navController = rememberNavController()
            ScreenA(navController = navController, onSaveContact = { contact ->
                savedContact = contact
            })
        }

        composeTestRule.onNodeWithText("First Name").performTextInput("John")
        composeTestRule.onNodeWithText("Last Name").performTextInput("Doe")
        composeTestRule.onNodeWithText("Phone").performTextInput("1234567890")
        composeTestRule.onNodeWithText("Hobby").performTextInput("Reading")

        composeTestRule.onNodeWithText("Save Contact").performClick()

        assert(savedContact != null)
        assert(savedContact?.firstName == "John")
        assert(savedContact?.lastName == "Doe")
        assert(savedContact?.phone == "1234567890")
        assert(savedContact?.hobby == "Reading")
    }
}