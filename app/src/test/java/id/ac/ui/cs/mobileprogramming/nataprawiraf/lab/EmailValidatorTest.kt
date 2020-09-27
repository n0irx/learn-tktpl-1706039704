package id.ac.ui.cs.mobileprogramming.nataprawiraf.lab

import org.junit.Assert.assertFalse
import org.junit.Assert.assertTrue
import org.junit.Test

/**
 * Unit tests for the EmailValidator logic.
 */
class EmailValidatorTest {

    @Test fun `email validator correct email simple returns true`() {
        assertTrue(EmailValidator.isValidEmail("name@email.com"))
    }

    @Test fun `email validator correct email subDomain returns true`() {
        assertTrue(EmailValidator.isValidEmail("name@email.co.id"))
    }

    @Test fun `email validator invalid email no tld returns false`() {
        assertFalse(EmailValidator.isValidEmail("name@email"))
    }

    @Test fun `email validator invalid email double dot returns false`() {
        assertFalse(EmailValidator.isValidEmail("name@email..com"))
    }

    @Test fun `email validator invalid email no username returns false`() {
        assertFalse(EmailValidator.isValidEmail("@email.com"))
    }

    @Test fun `email validator empty string returns false`() {
        assertFalse(EmailValidator.isValidEmail(""))
    }

    @Test fun `email validator null email returns false`() {
        assertFalse(EmailValidator.isValidEmail(null))
    }

}
