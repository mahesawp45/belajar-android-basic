package com.example.belajarandroiddasar

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    private lateinit var nameEditText: EditText
    private lateinit var sayBabyButton: Button
    private lateinit var sayBabyTextView: TextView

    private fun initComp() {
        nameEditText = findViewById(R.id.nameEditText)
        sayBabyButton = findViewById(R.id.sayBabyButton)
        sayBabyTextView = findViewById(R.id.sayBabyTextView)
    }

//    Ini method buat bkin tampilannya/activity tampil
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.hello_world)

        initComp()

        sayBabyTextView.text = resources.getString(R.string.say_baby)

        sayBabyButton.setOnClickListener {
            Log.i("MWP", "SAY BABY CLICK OWH")
            val name = nameEditText.text.toString()
            sayBabyTextView.text = "Hi Baby $name"
        }
    }
}