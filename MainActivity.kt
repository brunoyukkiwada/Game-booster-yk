class TurboMode(private val context: Context) {

    fun boost() {

        val am = context.getSystemService(Context.ACTIVITY_SERVICE) as ActivityManager

        val processos = am.runningAppProcesses

        processos?.forEach {

            if(it.importance != ActivityManager.RunningAppProcessInfo.IMPORTANCE_FOREGROUND){

                android.os.Process.killProcess(it.pid)
            }

        }

    }
}
