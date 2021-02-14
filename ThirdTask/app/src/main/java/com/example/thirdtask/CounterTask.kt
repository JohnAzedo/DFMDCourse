package com.example.thirdtask

import android.os.AsyncTask
import android.os.SystemClock
import android.widget.Button
import android.widget.TextView
import java.util.concurrent.Callable

class CounterTask(val button: Button, val txt: TextView): AsyncTask<Int, Int, Unit>(){

    override fun onPostExecute(result: Unit?) {
        super.onPostExecute(result)
        button.isEnabled = true
    }

    override fun onProgressUpdate(vararg values: Int?) {
        super.onProgressUpdate(*values)
        txt.text = values[0].toString()
    }

    override fun onPreExecute() {
        super.onPreExecute()
        button.isEnabled = false
    }

    override fun doInBackground(vararg params: Int?) {
        val max = params[0] as Int

        for (i in 0..max) {
            SystemClock.sleep(500)
            publishProgress(i)
        }
    }


}