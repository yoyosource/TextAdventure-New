package de.yoyosource

import java.io.File
import java.util.zip.ZipInputStream

class GameInfo(val file: File) {

    init {
        val inputStream = ZipInputStream(file.inputStream())
        var entry = inputStream.nextEntry
        while (entry != null) {
            if (entry.name.endsWith(".class") && entry.name.startsWith("${file.nameWithoutExtension}/components/")) {
                println(entry.name)
            }
            if (entry.name.startsWith("${file.nameWithoutExtension}/texts/") && entry.name.endsWith(".yapion")) {
                println(entry.name)
            }
            if (entry.name == "${file.nameWithoutExtension}/init.yapion") {
                println(entry.name)
            }
            entry = inputStream.nextEntry
        }
    }
}