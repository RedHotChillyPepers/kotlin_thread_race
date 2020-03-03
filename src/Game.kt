class Game {
    private val fileWriter: FileWriter
    private val spectator: Spectator
    private var threadA: MyThread
    private var threadB: MyThread

    init {
        this.fileWriter = FileWriter(Config.FILE_OUTPUT)
        this.spectator = Spectator(this.fileWriter)
        this.threadA = MyThread("Поток А", spectator, fileWriter)
        this.threadB = MyThread("Поток Б", spectator, fileWriter)
    }

    fun start() {
        threadA.start()
        threadB.start()
    }
}