package de.yoyosource.entity

import de.yoyosource.component.impl.Inventory
import yapion.annotations.`object`.YAPIONData

@YAPIONData(cascading = true)
class Player: Inventory() {
    var room: Room? = null

    fun sendMessage(message: String, vararg args: Any) {
        println(message.format(*args))
    }

    fun command(command: String) {
        val args = command.split(" ")
        val commandName = args[0]
        val commandArgs = args.subList(1, args.size).toTypedArray()
        command(commandName, commandArgs)
        invCommand(this, commandName, commandArgs)
        room?.forEachComponent { it.command(this, room!!, commandName, commandArgs) }
    }

    fun command(command: String, args: Array<String>) {
        when (command) {
            "help" -> {
                val commands = mutableSetOf<String>()
                commandList(commands)
                room?.forEachComponent { it.commandList(commands) }
                commands.add("help")
                if (room != null) commands.add("drop [item]")
                if (room != null) commands.add("look")
                if (room != null) commands.add("info")
                commands.forEach { println(it) }
            }
            "look", "info" -> {
                if (room == null) return
                TODO()
            }
            "drop" -> {
                if (room == null) return
                TODO()
            }
        }
    }
}