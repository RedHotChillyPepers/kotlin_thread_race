import java.io.FileWriter

lateinit var fileWriter: FileWriter
lateinit var threadManager: ThreadManager

fun main() {
    try {
        fileWriter = FileWriter(Config.FILE_OUTPUT)
    } catch (e: Exception) {
        println("Упс... Что-то пошло не так")
        e.printStackTrace()
        readLine()
        return
    }

    threadManager = ThreadManager(fileWriter)
    println("Нажмите любую клавишу...")
    readLine()
    threadManager.start()
    threadManager.waitForAllComplete()
    fileWriter.close()
}