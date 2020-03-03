class MyThread(name: String, private val spectator: Spectator, private val fileWriter: FileWriter) : Thread(name) {
    override fun run() {
        var counter = Config.START_COUNTER_VALUE
        while(++counter <= Config.WIN_COUNTER_VALUE && !spectator.haveWinner) {
            fileWriter.writelnToFile("$name $counter")
        }
        spectator.iWin(name)
    }
}