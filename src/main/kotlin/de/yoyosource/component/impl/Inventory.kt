package de.yoyosource.component.impl

import de.yoyosource.component.Component
import de.yoyosource.entity.Entity

class Inventory(val canHold: (Entity) -> Boolean = { true }): Component {

    private val entities: MutableList<Entity> = ArrayList()

    fun add(e: Entity) {
        if (canHold(e)) {
            entities.add(e)
        }
    }

    fun remove(e: Entity) {
        entities.remove(e)
    }
}