import java.io.FileWriter
import java.util.concurrent.CyclicBarrier
import java.util.concurrent.atomic.AtomicBoolean

class MyThread(name: String, private val fileWriter: FileWriter) : Thread(name) {
    companion object{
        private var haveWinner: AtomicBoolean = AtomicBoolean(false)
        private val cyclicBarrier: CyclicBarrier = CyclicBarrier(Config.THREADS_COUNT)
    }

    override fun run() {
        cyclicBarrier.await()
        var counter = Config.START_COUNTER_VALUE
        while(++counter <= Config.WIN_COUNTER_VALUE) {
            fileWriter.append("$name $counter\r\n").flush()
        }
        iWin(name)
    }

    private fun iWin(name: String) {
        if(haveWinner.compareAndSet(false, true)) {
            fileWriter.append("$name выиграл!\r\n").flush()
        } else {
            fileWriter.append("$name проиграл!\r\n").flush()
        }
    }
}