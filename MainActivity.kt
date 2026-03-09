package com.gamebooster

import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    lateinit var booster: TurboMode
    lateinit var tempMonitor: TemperatureMonitor
    lateinit var fpsMonitor: FPSMonitor

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        booster = TurboMode(this)
        tempMonitor = TemperatureMonitor(this)
        fpsMonitor = FPSMonitor()

        val boostBtn = findViewById<Button>(R.id.boostButton)

        boostBtn.setOnClickListener {

            booster.boost()

            val temp = tempMonitor.getTemp()

            Toast.makeText(this, "Temp: $temp °C", Toast.LENGTH_SHORT).show()

            fpsMonitor.start()
        }

    }
}
