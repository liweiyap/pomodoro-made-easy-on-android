package com.liweiyap.pomodoro

import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Spinner
import androidx.appcompat.app.AppCompatActivity
import com.liweiyap.pomodoro.utils.SpinnerManager

class TimerSettingsActivity : AppCompatActivity()
{
    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val settingsSetNumberSpinner: Spinner = findViewById(R.id.settingsSetNumberSpinner)
        settingsSetNumberSpinner.adapter = ArrayAdapter(this, R.layout.spinner_item_textview, resources.getStringArray(R.array.setNumberArray))
        settingsSetNumberSpinner.onItemSelectedListener = object: AdapterView.OnItemSelectedListener
        {
            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long)
            {
                setNumber = parent?.getItemAtPosition(position).toString().toInt()
            }

            override fun onNothingSelected(parent: AdapterView<*>?)
            {}
        }

        val settingsCycleNumberPerSetSpinner: Spinner = findViewById(R.id.settingsCycleNumberPerSetSpinner)
        settingsCycleNumberPerSetSpinner.adapter = ArrayAdapter(this, R.layout.spinner_item_textview, resources.getStringArray(R.array.cycleNumberPerSetArray))
        settingsCycleNumberPerSetSpinner.onItemSelectedListener = object: AdapterView.OnItemSelectedListener
        {
            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long)
            {
                cycleNumberPerSet = parent?.getItemAtPosition(position).toString().toInt()
            }

            override fun onNothingSelected(parent: AdapterView<*>?)
            {}
        }

        settingsSetNumberSpinner.setSelection(SpinnerManager.getIndex(settingsSetNumberSpinner, setNumber.toString()))
        settingsCycleNumberPerSetSpinner.setSelection(SpinnerManager.getIndex(settingsCycleNumberPerSetSpinner, cycleNumberPerSet.toString()))
    }

    private var setNumber: Int = 2
    private var cycleNumberPerSet: Int = 4
}