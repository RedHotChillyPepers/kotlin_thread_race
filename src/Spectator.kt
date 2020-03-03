class Spectator(private val fileWriter: FileWriter) {
    var haveWinner = false
        private set

    @Synchronized fun iWin(name: String) {
        if(!haveWinner) {
            haveWinner = true
            fileWriter.writelnToFile("$name выиграл!")
        }
    }
}