fun main() {
    try {
        val game = Game()
        println("Нажмите любую клавишу...")
        readLine()
        game.start()
    } catch(e: Exception) {
        e.printStackTrace()
        readLine()
    }
}