package id.ac.ui.cs.mobileprogramming.nataprawiraf.lab.util

import android.content.Context
import androidx.preference.PreferenceManager
import id.ac.ui.cs.mobileprogramming.nataprawiraf.lab.MainActivity

class PrefUtil {

    companion object {
        fun getTimerLength(context: Context): Int {
            // placeholder
            return 1
        }

        private const val PREVIOUS_TIMER_LENGTH_SECONDS_ID =
            "id.ac.ui.cs.mobileprogramming.nataprawiraf.previous_timer_length"

        fun getPreviousTimerLengthSeconds(context: Context): Long {
            val preferences = PreferenceManager.getDefaultSharedPreferences(context)
            return preferences.getLong(PREVIOUS_TIMER_LENGTH_SECONDS_ID, 0)
        }

        fun setPreviousTimerLengthSeconds(seconds: Long, context: Context) {
            val prefEditor = PreferenceManager.getDefaultSharedPreferences(
                context
            ).edit()
            prefEditor.putLong(PREVIOUS_TIMER_LENGTH_SECONDS_ID, seconds)
            prefEditor.apply()
        }


        private const val SECONDS_REMAINING_ID =
            "id.ac.ui.cs.mobileprogramming.nataprawiraf.seconds_remaining"

        fun getSecondsRemaining(context: Context): Long {
            val preferences = PreferenceManager.getDefaultSharedPreferences(context)
            return preferences.getLong(SECONDS_REMAINING_ID, 0)
        }

        fun setSecondsRemaining(seconds: Long, context: Context) {
            val prefEditor = PreferenceManager.getDefaultSharedPreferences(
                context
            ).edit()
            prefEditor.putLong(SECONDS_REMAINING_ID, seconds)
            prefEditor.apply()
        }


        private const val TIMER_STATE_ID = "id.ac.ui.cs.mobileprogramming.nataprawiraf.timer_state"

        fun getTimerState(context: Context): MainActivity.TimerState {
            val preferences = PreferenceManager.getDefaultSharedPreferences(context)
            val ordinal = preferences.getInt(TIMER_STATE_ID, 0)
            return MainActivity.TimerState.values()[ordinal]
        }

        fun setTimerState(state: MainActivity.TimerState, context: Context) {
            val prefEditor = PreferenceManager.getDefaultSharedPreferences(
                context
            ).edit()
            val ordinal = state.ordinal
            prefEditor.putInt(TIMER_STATE_ID, ordinal)
            prefEditor.apply()
        }


        private const val ALARM_SET_TIME_ID =
            "id.ac.ui.cs.mobileprogramming.nataprawiraf.background_time"

        fun getAlarmSetTime(context: Context): Long {
            val preferences = PreferenceManager.getDefaultSharedPreferences(context)
            return preferences.getLong(ALARM_SET_TIME_ID, 0)
        }

        fun setAlarmSetTime(time: Long, context: Context) {
            val prefEditor = PreferenceManager.getDefaultSharedPreferences(
                context
            ).edit()
            prefEditor.putLong(ALARM_SET_TIME_ID, time)
            prefEditor.apply()
        }
    }
}