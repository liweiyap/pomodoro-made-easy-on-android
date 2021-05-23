package com.liweiyap.pomodoro.ui

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Spinner
import android.widget.TextView
import androidx.annotation.NonNull
import androidx.constraintlayout.widget.ConstraintLayout
import com.liweiyap.pomodoro.R
import com.liweiyap.pomodoro.utils.SpinnerManager

class SettingsConstraintLayout: ConstraintLayout
{
    constructor(@NonNull context: Context) : super(context)
    {
        mContext = context
        LayoutInflater.from(context).inflate(R.layout.settings_constraintlayout,this)
    }

    constructor(@NonNull context: Context, attrs: AttributeSet?) : super(context, attrs)
    {
        mContext = context
    }

    constructor(@NonNull context: Context, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr)
    {
        mContext = context
    }

    fun setName(name: String)
    {
        val settingsNameTextView: TextView = findViewById(R.id.settingsNameTextView)
        settingsNameTextView.text = name
    }

    fun setSpinnerValues(values: Array<String>)
    {
        val settingsValueSpinner: Spinner = findViewById(R.id.settingsValueSpinner)
        settingsValueSpinner.adapter = ArrayAdapter(mContext, R.layout.spinner_item_textview, values)
    }

    fun setSpinnerOnItemSelectedCallback(callback: SpinnerManager.SpinnerOnItemSelectedCallback)
    {
        val settingsValueSpinner: Spinner = findViewById(R.id.settingsValueSpinner)
        settingsValueSpinner.onItemSelectedListener = object: AdapterView.OnItemSelectedListener
        {
            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long)
            {
                callback.run(parent, view, position, id)
            }

            override fun onNothingSelected(parent: AdapterView<*>?)
            {}
        }
    }

    fun setSelection(selectedValue: Int)
    {
        val settingsValueSpinner: Spinner = findViewById(R.id.settingsValueSpinner)
        settingsValueSpinner.setSelection(SpinnerManager.getIndex(settingsValueSpinner, selectedValue.toString()))
    }

    private var mContext: Context
}