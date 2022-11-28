package de.yoyosource.component

import de.yoyosource.entity.Entity
import de.yoyosource.entity.Player

interface Component {
    fun tick(entity: Entity) {}
    fun command(player: Player, entity: Entity, command: String, args: Array<String>) {}
    fun commandList(commands: MutableSet<String>) {}
}