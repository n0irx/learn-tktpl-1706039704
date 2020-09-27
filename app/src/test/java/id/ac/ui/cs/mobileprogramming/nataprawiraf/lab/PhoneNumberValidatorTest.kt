package id.ac.ui.cs.mobileprogramming.nataprawiraf.lab

import org.junit.Assert.assertFalse
import org.junit.Assert.assertTrue
import org.junit.Test

/**
 * Unit tests for the PhoneNumberValidator logic.
 */
class PhoneNumberValidatorTest {

    @Test fun `phone number validator with zero return true`() {
        assertTrue(PhoneNumberValidator.isValidPhoneNumber("089890672812"))
    }

    @Test fun `phone number validator without zero return true`() {
        assertTrue(PhoneNumberValidator.isValidPhoneNumber("6289890672812"))
    }

    @Test fun `phone number validator with plus return true`() {
        assertTrue(PhoneNumberValidator.isValidPhoneNumber("+6289890672812"))
    }

    @Test fun `phone number validator contains letter return false`() {
        assertFalse(PhoneNumberValidator.isValidPhoneNumber("fulan232113"))
    }

    @Test fun `phone number validator with special symbol return false`() {
        assertFalse(PhoneNumberValidator.isValidPhoneNumber("310283&237!"))
    }

    @Test fun `phone number validator with dash return false`() {
        assertFalse(PhoneNumberValidator.isValidPhoneNumber("08223-231-2324"))
    }

}
