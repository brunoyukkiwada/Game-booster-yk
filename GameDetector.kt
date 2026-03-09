class GameDetector(private val context: Context){

    fun detectar(): List<String>{

        val pm = context.packageManager

        val apps = pm.getInstalledApplications(0)

        val jogos = mutableListOf<String>()

        for(app in apps){

            val nome = pm.getApplicationLabel(app).toString()

            if(nome.contains("game",true)){
                jogos.add(app.packageName)
            }
        }

        return jogos
    }

}
