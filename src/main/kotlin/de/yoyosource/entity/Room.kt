package de.yoyosource.entity

import de.yoyosource.component.impl.Inventory
import de.yoyosource.component.impl.Traverseable

class Room(val name: String): Entity() {

    init {
        addComponent(Traverseable(name))
        addComponent(Inventory())
    }

    fun add(entity: Entity) {
        if (entity is Room) {
            getComponent(Traverseable::class.java).addConnectingRoom(entity)
        } else {
            getComponent(Inventory::class.java).add(entity)
        }
    }
}