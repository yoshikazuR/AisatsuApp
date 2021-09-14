package jp.techacademy.yoshikazu.takahashi.aisatsuapp

import android.app.TimePickerDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), View.OnClickListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        button.setOnClickListener(this)
    }

    override fun onClick(v: View) {
        val timePickerDialog = TimePickerDialog(
            this,
            TimePickerDialog.OnTimeSetListener {
                    view, hour, minute ->
                var min: Int = hour*60+minute
                if (min >= 2*60 && min < 10*60) {
                    textView.text = "おはよう"
                }else if (min >= 10*60 && min < 18*60) {
                    textView.text = "こんにちは"
                }else if (min >= 18*60 || min < 2*60) {
                    textView.text = "こんばんは"
                }
                Log.d("UI_PARTS", "$hour.$minute")
            },
            13, 0, true)
        timePickerDialog.show()
    }
}