package de.yoyosource.component.impl

import de.yoyosource.component.Component
import de.yoyosource.entity.Entity
import de.yoyosource.entity.Player
import de.yoyosource.entity.Room

class Traverseable(val name: String): Component {

    private val connectingRooms: MutableList<Room> = ArrayList()

    fun addConnectingRoom(room: Room) {
        connectingRooms.add(room)
    }

    override fun command(player: Player, entity: Entity, command: String, args: Array<String>) {
        if (command != "enter") return
        if (args.size != 1) return
        val roomName = args[0]
        val room = connectingRooms.find { it.name == roomName }
        if (room == null) {
            player.sendMessage("There is no room with the name %s", roomName)
            return
        }
        player.room = room
    }

    override fun commandList(commands: MutableSet<String>) {
        commands.add("enter [room]")
    }
}