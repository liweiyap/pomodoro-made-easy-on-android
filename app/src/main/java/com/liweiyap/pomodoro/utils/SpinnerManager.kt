package com.liweiyap.pomodoro.utils

import android.view.View
import android.widget.AdapterView
import android.widget.Spinner

class SpinnerManager
{
    companion object
    {
        @JvmStatic
        fun getIndex(spinner: Spinner, query: String): Int
        {
            for (idx in 0 until spinner.count)
            {
                if (spinner.getItemAtPosition(idx).toString() == query)
                {
                    return idx
                }
            }

            return 0
        }
    }

    interface SpinnerOnItemSelectedCallback
    {
        fun run(parent: AdapterView<*>?, view: View?, position: Int, id: Long)
    }
}