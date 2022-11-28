package de.yoyosource.component.impl

import de.yoyosource.entity.Room
import de.yoyosource.component.Component

class Traverseable(val name: String): Component {

    private val connectingRooms: MutableList<Room> = ArrayList()

    fun addConnectingRoom(room: Room) {
        connectingRooms.add(room)
    }
}