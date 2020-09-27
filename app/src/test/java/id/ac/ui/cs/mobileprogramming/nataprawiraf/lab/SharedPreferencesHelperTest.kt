package id.ac.ui.cs.mobileprogramming.nataprawiraf.lab

import android.content.SharedPreferences
import org.junit.Assert.assertEquals
import org.junit.Assert.assertFalse
import org.junit.Assert.assertTrue
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.ArgumentMatchers.anyLong
import org.mockito.ArgumentMatchers.anyString
import org.mockito.ArgumentMatchers.eq
import org.mockito.BDDMockito.given
import org.mockito.Mock
import org.mockito.junit.MockitoJUnitRunner
import java.util.Calendar

/**
 * Unit tests for the [SharedPreferencesHelper] that mocks [SharedPreferences].
 */
@RunWith(MockitoJUnitRunner::class)
class SharedPreferencesHelperTest {

    private val TEST_NAME = "Test name"
    private val TEST_EMAIL = "test@email.com"
    private val TEST_PHONE_NUMBER = "08123456789"
    private val TEST_DATE_OF_BIRTH = Calendar.getInstance().apply { set(1980, 1, 1) }

    private lateinit var sharedPreferenceEntry: SharedPreferenceEntry
    private lateinit var mockSharedPreferencesHelper: SharedPreferencesHelper
    private lateinit var mockBrokenSharedPreferencesHelper: SharedPreferencesHelper

    @Mock private lateinit var mockSharedPreferences: SharedPreferences
    @Mock private lateinit var mockBrokenSharedPreferences: SharedPreferences
    @Mock private lateinit var mockEditor: SharedPreferences.Editor
    @Mock private lateinit var mockBrokenEditor: SharedPreferences.Editor

    @Before fun initMocks() {
        // Create SharedPreferenceEntry to persist.
        sharedPreferenceEntry = SharedPreferenceEntry(TEST_NAME, TEST_DATE_OF_BIRTH, TEST_EMAIL, TEST_PHONE_NUMBER)

        // Create a mocked SharedPreferences.
        mockSharedPreferencesHelper = createMockSharedPreference()

        // Create a mocked SharedPreferences that fails at saving data.
        mockBrokenSharedPreferencesHelper = createBrokenMockSharedPreference()
    }

    @Test fun sharedPreferencesHelper_SaveAndReadPersonalInformation() {
        // Save the personal information to SharedPreferences
        assertTrue(mockSharedPreferencesHelper.savePersonalInfo(sharedPreferenceEntry))

        // Read personal information from SharedPreferences
        val savedEntry = mockSharedPreferencesHelper.getPersonalInfo()

        // Make sure both written and retrieved personal information are equal.
        assertEquals(sharedPreferenceEntry.name, savedEntry.name)
        assertEquals(sharedPreferenceEntry.dateOfBirth, savedEntry.dateOfBirth)
        assertEquals(sharedPreferenceEntry.email, savedEntry.email)
    }

    @Test fun sharedPreferencesHelper_SavePersonalInformationFailed_ReturnsFalse() {
        // Read personal information from a broken SharedPreferencesHelper
        assertFalse(mockBrokenSharedPreferencesHelper.savePersonalInfo(sharedPreferenceEntry))
    }

    /**
     * Creates a mocked SharedPreferences.
     */
    private fun createMockSharedPreference(): SharedPreferencesHelper {
        // Mocking reading the SharedPreferences as if mockSharedPreferences was previously written
        // correctly.
        given(mockSharedPreferences.getString(eq(SharedPreferencesHelper.KEY_NAME), anyString()))
                .willReturn(sharedPreferenceEntry.name)
        given(mockSharedPreferences.getString(eq(SharedPreferencesHelper.KEY_EMAIL), anyString()))
                .willReturn(sharedPreferenceEntry.email)
        given(mockSharedPreferences.getLong(eq(SharedPreferencesHelper.KEY_DOB), anyLong()))
                .willReturn(sharedPreferenceEntry.dateOfBirth.timeInMillis)

        // Mocking a successful commit.
        given(mockEditor.commit()).willReturn(true)

        // Return the MockEditor when requesting it.
        given(mockSharedPreferences.edit()).willReturn(mockEditor)
        return SharedPreferencesHelper(mockSharedPreferences)
    }

    /**
     * Creates a mocked SharedPreferences that fails when writing.
     */
    private fun createBrokenMockSharedPreference(): SharedPreferencesHelper {
        // Mocking a commit that fails.
        given(mockBrokenEditor.commit()).willReturn(false)

        // Return the broken MockEditor when requesting it.
        given(mockBrokenSharedPreferences.edit()).willReturn(mockBrokenEditor)
        return SharedPreferencesHelper(mockBrokenSharedPreferences)
    }

}
