package de.yoyosource.component

import de.yoyosource.entity.Entity

interface Component {
    fun tick(entity: Entity) {}
}