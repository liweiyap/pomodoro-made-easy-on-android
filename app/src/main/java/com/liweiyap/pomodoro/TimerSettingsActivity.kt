package com.liweiyap.pomodoro

import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import androidx.appcompat.app.AppCompatActivity
import com.liweiyap.pomodoro.ui.SettingsConstraintLayout
import com.liweiyap.pomodoro.utils.SpinnerManager

class TimerSettingsActivity : AppCompatActivity()
{
    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val settingsSetNumberConstraintLayout: SettingsConstraintLayout = findViewById(R.id.settingsSetNumberConstraintLayout)
        settingsSetNumberConstraintLayout.setName(resources.getString(R.string.settingsSetNumberText))
        settingsSetNumberConstraintLayout.setSpinnerValues(resources.getStringArray(R.array.setNumberArray))
        settingsSetNumberConstraintLayout.setSpinnerOnItemSelectedCallback(object: SpinnerManager.SpinnerOnItemSelectedCallback
        {
            override fun run(parent: AdapterView<*>?, view: View?, position: Int, id: Long)
            {
                setNumber = parent?.getItemAtPosition(position).toString().toInt()
            }
        })
        settingsSetNumberConstraintLayout.setSelection(setNumber)

        val settingsCycleNumberPerSetConstraintLayout: SettingsConstraintLayout = findViewById(R.id.settingsCycleNumberPerSetConstraintLayout)
        settingsCycleNumberPerSetConstraintLayout.setName(resources.getString(R.string.settingsCycleNumberPerSetText))
        settingsCycleNumberPerSetConstraintLayout.setSpinnerValues(resources.getStringArray(R.array.cycleNumberPerSetArray))
        settingsCycleNumberPerSetConstraintLayout.setSpinnerOnItemSelectedCallback(object: SpinnerManager.SpinnerOnItemSelectedCallback
        {
            override fun run(parent: AdapterView<*>?, view: View?, position: Int, id: Long)
            {
                cycleNumberPerSet = parent?.getItemAtPosition(position).toString().toInt()
            }
        })
        settingsCycleNumberPerSetConstraintLayout.setSelection(cycleNumberPerSet)
    }

    private var setNumber: Int = 2
    private var cycleNumberPerSet: Int = 4
}