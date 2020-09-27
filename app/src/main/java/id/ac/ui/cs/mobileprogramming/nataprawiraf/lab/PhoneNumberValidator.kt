package id.ac.ui.cs.mobileprogramming.nataprawiraf.lab

import android.text.Editable
import android.text.TextWatcher

import java.util.regex.Pattern

/**
 * An Email format validator for [android.widget.EditText].
 */
class PhoneNumberValidator : TextWatcher {

    internal var isValid = false

    override fun afterTextChanged(editableText: Editable) {
        isValid = isValidPhoneNumber(editableText)
    }

    override fun beforeTextChanged(s: CharSequence, start: Int, count: Int, after: Int) = Unit

    override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) = Unit

    companion object {

        /**
         * Email validation pattern.
         */
        private val PHONE_NUMBER_PATTERN = Pattern.compile(
            "^[+]?[0-9]{10,13}$"
        )

        /**
         * Validates if the given input is a valid phone_number address.
         *
         * @param phone_number    The phone_number to validate.
         * @return `true`  if the input is a valid phone_number, `false` otherwise.
         */
        fun isValidPhoneNumber(phone_number: CharSequence?): Boolean {
            TODO("Implement Phone Number Validation")
            return phone_number != null && PHONE_NUMBER_PATTERN.matcher(phone_number).matches()
        }
    }
}
