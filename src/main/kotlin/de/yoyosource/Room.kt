package de.yoyosource

import de.yoyosource.entity.Entity

class Room(val name: String) {

    private val connectingRooms: MutableMap<Room, String> = HashMap()
    private val entities: MutableList<Entity> = ArrayList()
}