package com.liweiyap.pomodoro

import android.os.Bundle
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
            mSetNumber = parent?.getItemAtPosition(position).toString().toInt()
        }
        settingsSetNumberConstraintLayout.setSelection(mSetNumber)

        val settingsCycleNumberPerSetConstraintLayout: SettingsConstraintLayout = findViewById(R.id.settingsCycleNumberPerSetConstraintLayout)
        settingsCycleNumberPerSetConstraintLayout.setName(resources.getString(R.string.settingsCycleNumberPerSetText))
        settingsCycleNumberPerSetConstraintLayout.setSpinnerValues(resources.getStringArray(R.array.cycleNumberPerSetArray))
        settingsCycleNumberPerSetConstraintLayout.setSpinnerOnItemSelectedCallback { parent, _, position, _ ->
            mCycleNumberPerSet = parent?.getItemAtPosition(position).toString().toInt()
        }
        settingsCycleNumberPerSetConstraintLayout.setSelection(mCycleNumberPerSet)

        val settingsWorkOrStudyDurationConstraintLayout: SettingsConstraintLayout = findViewById(R.id.settingsWorkOrStudyDurationConstraintLayout)
        settingsWorkOrStudyDurationConstraintLayout.setName(resources.getString(R.string.settingsWorkOrStudyDurationText))
        settingsWorkOrStudyDurationConstraintLayout.setSpinnerValues(resources.getStringArray(R.array.workOrStudyDurationArray))
        settingsWorkOrStudyDurationConstraintLayout.setSpinnerOnItemSelectedCallback { parent, _, position, _ ->
            mWorkOrStudyDuration = parent?.getItemAtPosition(position)
                .toString()
                .filter { it.isDigit() }
                .toInt()
        }
        settingsWorkOrStudyDurationConstraintLayout.setSelection("$mWorkOrStudyDuration min")

        val settingsShortBreakDurationConstraintLayout: SettingsConstraintLayout = findViewById(R.id.settingsShortBreakDurationConstraintLayout)
        settingsShortBreakDurationConstraintLayout.setName(resources.getString(R.string.settingsShortBreakDurationText))
        settingsShortBreakDurationConstraintLayout.setSpinnerValues(resources.getStringArray(R.array.shortBreakDurationArray))
        settingsShortBreakDurationConstraintLayout.setSpinnerOnItemSelectedCallback { parent, _, position, _ ->
            mShortBreakDuration = parent?.getItemAtPosition(position)
                .toString()
                .filter { it.isDigit() }
                .toInt()
        }
        settingsShortBreakDurationConstraintLayout.setSelection("$mShortBreakDuration min")
    }

    private var mSetNumber: Int = 2
    private var mCycleNumberPerSet: Int = 4
    private var mWorkOrStudyDuration: Int = 50
    private var mShortBreakDuration: Int = 10
}