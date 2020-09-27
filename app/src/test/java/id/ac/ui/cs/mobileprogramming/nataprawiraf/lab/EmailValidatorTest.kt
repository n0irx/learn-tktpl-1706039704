
/*
 * Copyright (C) 2017 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

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
