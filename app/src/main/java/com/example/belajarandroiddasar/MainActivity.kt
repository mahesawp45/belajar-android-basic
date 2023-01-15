package com.example.belajarandroiddasar

import android.content.pm.PackageManager
import android.os.Build
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
    private lateinit var sayBabyMahesa : String

    private fun initComp() {
        nameEditText = findViewById(R.id.nameEditText)
        sayBabyButton = findViewById(R.id.sayBabyButton)
        sayBabyTextView = findViewById(R.id.sayBabyTextView)
        sayBabyMahesa = SayBaby().sayBaby("Mahesa")
    }

    private fun checkFingerPrint() {
//buat check fitur yang ada di hp tanpa declaratve/langsung di manifest
        if (packageManager.hasSystemFeature(PackageManager.FEATURE_FINGERPRINT)) {
            Log.e("FP", "FINGERPRINT ON")
        } else {
            Log.w("FP", "FINGERPRINT OFF")
        }
    }


    private fun checkSDKVersion() {
        Log.i("SDK", Build.VERSION.SDK_INT.toString())

//        Check SDK HP
        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.S_V2) {
            Log.e("SDK", "Disabled feature!, SDK < 32")
        }
    }

//    Ini method buat bkin tampilannya/activity tampil
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

//        ini buat ngeset view mana yang di tampilin
        setContentView(R.layout.hello_world)

        initComp()

        checkFingerPrint()

        checkSDKVersion()


        sayBabyTextView.text = resources.getString(R.string.sayBaby)

        sayBabyButton.setOnClickListener {
            Log.e("SAYBABY", sayBabyMahesa)

            Log.i("MWP", "SAY BABY CLICK OWH")
            val name = nameEditText.text.toString()
            sayBabyTextView.text = resources.getString(R.string.sayBabyTextView, name)

            Log.e("DEBUG", name)
            Log.e("MWP", resources.getIntArray(R.array.numbers).joinToString(","))

//            ganti warna di button
            sayBabyButton.setBackgroundColor(resources.getColor(R.color.melodrama))

            resources.getStringArray(R.array.names).forEach {
                Log.e("MWP", it)
            }

//            membaca file di assets
            val people = assets.open("people.json").bufferedReader().use { it.readText() }

            Log.e("ASSETS MWP", people)

//            raw resource pengganti asset menager
            val people1 = resources.openRawResource(R.raw.people).bufferedReader().use { it.readText() }

            Log.i("RAW MWP", people1)
        }


    }
}