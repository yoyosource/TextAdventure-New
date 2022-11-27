package de.yoyosource.component.impl

import de.yoyosource.component.Component
import de.yoyosource.entity.Entity

abstract class Flammable(var flameDuration: Int): Component {
    abstract fun burn()
}

data class Inflammable(var flameDuration: Int): Component

data class Burning(var flameDuration: Int): Component {

    override fun tick(entity: Entity) {
        if (flameDuration < 0) return
        flameDuration--
        if (flameDuration == 0) {
            entity.deleteComponent(this.javaClass)
            entity.getComponent(Flammable::class.java).burn()
        }
    }
}