import java.io.File
import java.io.FileNotFoundException
import java.io.IOException
import java.lang.NullPointerException

class FileWriter @Throws(NullPointerException::class, FileNotFoundException::class, IOException::class) constructor(private val fileName: String) {
    private val file: File

    init {
        this.file = File(this.fileName)

        if (this.file.exists()) {
            if (!this.file.isFile) {
                throw FileNotFoundException("${this.fileName} is not a file.")
            }

            this.file.delete()
        }

        this.file.createNewFile()
    }

    @Synchronized fun writelnToFile(text: String) {
        file.appendText(text + "\r\n")
    }
}