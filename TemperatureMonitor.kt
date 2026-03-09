class TemperatureMonitor(private val context: Context){

    fun getTemp(): Float{

        val intent = context.registerReceiver(
            null,
            IntentFilter(Intent.ACTION_BATTERY_CHANGED)
        )

        val temp = intent?.getIntExtra("temperature",0) ?: 0

        return temp / 10f
    }

}
