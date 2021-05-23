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
            setNumber = parent?.getItemAtPosition(position).toString().toInt()
        }
        settingsSetNumberConstraintLayout.setSelection(setNumber)

        val settingsCycleNumberPerSetConstraintLayout: SettingsConstraintLayout = findViewById(R.id.settingsCycleNumberPerSetConstraintLayout)
        settingsCycleNumberPerSetConstraintLayout.setName(resources.getString(R.string.settingsCycleNumberPerSetText))
        settingsCycleNumberPerSetConstraintLayout.setSpinnerValues(resources.getStringArray(R.array.cycleNumberPerSetArray))
        settingsCycleNumberPerSetConstraintLayout.setSpinnerOnItemSelectedCallback { parent, _, position, _ ->
            cycleNumberPerSet = parent?.getItemAtPosition(position).toString().toInt()
        }
        settingsCycleNumberPerSetConstraintLayout.setSelection(cycleNumberPerSet)
    }

    private var setNumber: Int = 2
    private var cycleNumberPerSet: Int = 4
}