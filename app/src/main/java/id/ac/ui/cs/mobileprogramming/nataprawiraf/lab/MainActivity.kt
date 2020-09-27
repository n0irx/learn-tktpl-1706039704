
package id.ac.ui.cs.mobileprogramming.nataprawiraf.lab

import android.app.Activity
import android.content.SharedPreferences
import android.os.Bundle
import android.preference.PreferenceManager
import android.util.Log
import android.view.View
import android.widget.DatePicker
import android.widget.EditText
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

import java.util.Calendar

/**
 * An [Activity] that represents an input form page where the user can provide their name, date
 * of birth, and email address. The personal information can be saved to [SharedPreferences]
 * by clicking a button.
 */
class MainActivity : Activity() {

    private val TAG = "MainActivity"

    // The helper that manages writing to SharedPreferences.
    private lateinit var sharedPreferencesHelper: SharedPreferencesHelper

    // The input field where the user enters their name.
    private lateinit var nameText: EditText

    // The date picker where the user enters their date of birth.
    private lateinit var dobPicker: DatePicker

    // The input field where the user enters their email.
    private lateinit var emailText: EditText

    // The input field where the user enters their phone number.
    private lateinit var phoneNumberText: EditText

    // The validator for the email input field.
    private var emailValidator = EmailValidator()

    // The validator for the phone number input field.
    private var phoneNumberValidator = PhoneNumberValidator()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Shortcuts to input fields.
        nameText = findViewById(R.id.userNameInput)
        dobPicker = findViewById(R.id.dateOfBirthInput)
        emailText = findViewById(R.id.emailInput)
        phoneNumberText = findViewById(R.id.phoneNumberInput)

        // Setup email and phone number field validator.
        emailText.addTextChangedListener(emailValidator)
        phoneNumberText.addTextChangedListener(phoneNumberValidator)

        // Instantiate a SharedPreferencesHelper.
        val sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this)
        sharedPreferencesHelper = SharedPreferencesHelper(sharedPreferences)

        // Fill input fields from data retrieved from the SharedPreferences.
        populateUi()
    }

    /**
     * Initialize all fields from the personal info saved in the SharedPreferences.
     */
    private fun populateUi() {
        val sharedPreferenceEntry = sharedPreferencesHelper.getPersonalInfo()
        nameText.setText(sharedPreferenceEntry.name)
        val dateOfBirth = sharedPreferenceEntry.dateOfBirth
        dobPicker.init(dateOfBirth.get(Calendar.YEAR), dateOfBirth.get(Calendar.MONTH),
            dateOfBirth.get(Calendar.DAY_OF_MONTH), null)
        emailText.setText(sharedPreferenceEntry.email)
    }

    /**
     * Called when the "Save" button is clicked.
     */
    fun onSaveClick(@Suppress("UNUSED_PARAMETER") view: View) {
        // Don't save if the fields do not validate.
        if (!emailValidator.isValid) {
            emailText.error = "Invalid email"
            Log.w(TAG, "Not saving personal information: Invalid email")
            return
        }

        if (!phoneNumberValidator.isValid) {
            phoneNumberText.error = "Invalid phone number"
            Log.w(TAG, "Not saving personal information: Invalid phone number")
            return
        }

        // Get the text from the input fields.
        val name = nameText.text.toString()
        val dateOfBirth = Calendar.getInstance()
        dateOfBirth.set(dobPicker.year, dobPicker.month, dobPicker.dayOfMonth)
        val email = emailText.text.toString()
        val phoneNumber = phoneNumberText.text.toString()

        // Create a Setting model class to persist.
        val sharedPreferenceEntry = SharedPreferenceEntry(name, dateOfBirth, email, phoneNumber)

        // Persist the personal information.
        val isSuccess = sharedPreferencesHelper.savePersonalInfo(sharedPreferenceEntry)
        if (isSuccess) {
            Toast.makeText(this, "Personal information saved", Toast.LENGTH_LONG).show()
            Log.i(TAG, "Personal information saved")
        } else {
            Log.e(TAG, "Failed to write personal information to SharedPreferences")
        }
    }

    /**
     * Called when the "Revert" button is clicked.
     */
    fun onRevertClick(@Suppress("UNUSED_PARAMETER") view: View) {
        populateUi()
        Toast.makeText(this, "Personal information reverted", Toast.LENGTH_LONG).show()
        Log.i(TAG, "Personal information reverted")
    }

}
