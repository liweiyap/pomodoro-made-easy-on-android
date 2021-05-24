package com.liweiyap.pomodoro

import android.os.Bundle
import android.widget.AdapterView
import androidx.appcompat.app.AppCompatActivity
import com.liweiyap.pomodoro.ui.SettingsConstraintLayout

class TimerSettingsActivity : AppCompatActivity()
{
    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val settingsSetNumberConstraintLayout: SettingsConstraintLayout = findViewById(R.id.settingsSetNumberConstraintLayout)
        settingsSetNumberConstraintLayout.setName(resources.getString(R.string.settingsSetNumberText))
        settingsSetNumberConstraintLayout.setSpinnerValues(resources.getStringArray(R.array.setNumberArray))
        settingsSetNumberConstraintLayout.setSpinnerOnItemSelectedCallback { parent, _, position, _ ->
            mSetNumber = parseSettingsValueSpinner(parent, position)
        }
        settingsSetNumberConstraintLayout.setSelection(mSetNumber)

        val settingsCycleNumberPerSetConstraintLayout: SettingsConstraintLayout = findViewById(R.id.settingsCycleNumberPerSetConstraintLayout)
        settingsCycleNumberPerSetConstraintLayout.setName(resources.getString(R.string.settingsCycleNumberPerSetText))
        settingsCycleNumberPerSetConstraintLayout.setSpinnerValues(resources.getStringArray(R.array.cycleNumberPerSetArray))
        settingsCycleNumberPerSetConstraintLayout.setSpinnerOnItemSelectedCallback { parent, _, position, _ ->
            mCycleNumberPerSet = parseSettingsValueSpinner(parent, position)
        }
        settingsCycleNumberPerSetConstraintLayout.setSelection(mCycleNumberPerSet)

        val settingsWorkOrStudyDurationConstraintLayout: SettingsConstraintLayout = findViewById(R.id.settingsWorkOrStudyDurationConstraintLayout)
        settingsWorkOrStudyDurationConstraintLayout.setName(resources.getString(R.string.settingsWorkOrStudyDurationText))
        settingsWorkOrStudyDurationConstraintLayout.setSpinnerValues(resources.getStringArray(R.array.workOrStudyDurationArray))
        settingsWorkOrStudyDurationConstraintLayout.setSpinnerOnItemSelectedCallback { parent, _, position, _ ->
            mWorkOrStudyDuration = parseSettingsValueSpinner(parent, position)
        }
        settingsWorkOrStudyDurationConstraintLayout.setSelection("$mWorkOrStudyDuration min")

        val settingsShortBreakDurationConstraintLayout: SettingsConstraintLayout = findViewById(R.id.settingsShortBreakDurationConstraintLayout)
        settingsShortBreakDurationConstraintLayout.setName(resources.getString(R.string.settingsShortBreakDurationText))
        settingsShortBreakDurationConstraintLayout.setSpinnerValues(resources.getStringArray(R.array.shortBreakDurationArray))
        settingsShortBreakDurationConstraintLayout.setSpinnerOnItemSelectedCallback { parent, _, position, _ ->
            mShortBreakDuration = parseSettingsValueSpinner(parent, position)
        }
        settingsShortBreakDurationConstraintLayout.setSelection("$mShortBreakDuration min")

        val settingsShortBreakDurationIncreaseConstraintLayout: SettingsConstraintLayout = findViewById(R.id.settingsShortBreakDurationIncreaseConstraintLayout)
        settingsShortBreakDurationIncreaseConstraintLayout.setName(resources.getString(R.string.settingsShortBreakDurationIncreaseText))
        settingsShortBreakDurationIncreaseConstraintLayout.setSpinnerValues(resources.getStringArray(R.array.shortBreakDurationIncreaseArray))
        settingsShortBreakDurationIncreaseConstraintLayout.setSpinnerOnItemSelectedCallback { parent, _, position, _ ->
            mShortBreakDurationIncrease = parseSettingsValueSpinner(parent, position)
        }
        settingsShortBreakDurationIncreaseConstraintLayout.setSelection("$mShortBreakDurationIncrease min")

        val settingsLongBreakDurationConstraintLayout: SettingsConstraintLayout = findViewById(R.id.settingsLongBreakDurationConstraintLayout)
        settingsLongBreakDurationConstraintLayout.setName(resources.getString(R.string.settingsLongBreakDurationText))
        settingsLongBreakDurationConstraintLayout.setSpinnerValues(resources.getStringArray(R.array.longBreakDurationArray))
        settingsLongBreakDurationConstraintLayout.setSpinnerOnItemSelectedCallback { parent, _, position, _ ->
            mLongBreakDuration = parseSettingsValueSpinner(parent, position)
        }
        settingsLongBreakDurationConstraintLayout.setSelection("$mLongBreakDuration min")
    }

    private fun parseSettingsValueSpinner(parent: AdapterView<*>?, position: Int): Int
    {
        return parent?.getItemAtPosition(position)
            .toString()
            .filter { it.isDigit() }
            .toInt()
    }

    private var mSetNumber: Int = 2
    private var mCycleNumberPerSet: Int = 4
    private var mWorkOrStudyDuration: Int = 50
    private var mShortBreakDuration: Int = 10
    private var mShortBreakDurationIncrease: Int = 0
    private var mLongBreakDuration: Int = 60
}