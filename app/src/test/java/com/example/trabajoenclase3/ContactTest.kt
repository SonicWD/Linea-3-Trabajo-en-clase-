import Screen.nav.Contact
import org.junit.Test
import org.junit.Assert.*

class ContactTest {

    @Test
    fun testContactCreation() {
        val contact = Contact("John", "Doe", "1234567890", "Reading")
        assertEquals("John", contact.firstName)
        assertEquals("Doe", contact.lastName)
        assertEquals("1234567890", contact.phone)
        assertEquals("Reading", contact.hobby)
    }

    @Test
    fun testContactEquality() {
        val contact1 = Contact("John", "Doe", "1234567890", "Reading")
        val contact2 = Contact("John", "Doe", "1234567890", "Reading")
        val contact3 = Contact("Jane", "Doe", "0987654321", "Writing")

        assertEquals(contact1, contact2)
        assertNotEquals(contact1, contact3)
    }
}