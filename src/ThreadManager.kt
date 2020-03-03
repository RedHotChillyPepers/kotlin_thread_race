import java.io.FileWriter
import java.util.*
import kotlin.collections.ArrayList

class ThreadManager(fileWriter: FileWriter) {
    private val threads: ArrayList<MyThread> = arrayListOf()

    init {
        for(i in 0 until Config.THREADS_COUNT) {
            threads.add(MyThread("Поток ${UUID.randomUUID()}", fileWriter))
        }
    }

    fun start() {
        for (thread in threads) {
            thread.start()
        }
    }

    fun waitForAllComplete() {
        for (thread in threads) {
            thread.join()
        }
    }
}