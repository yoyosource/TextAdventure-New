package de.yoyosource.component.impl

import de.yoyosource.component.Component
import de.yoyosource.entity.Entity
import de.yoyosource.entity.Player

open class Inventory(val canHold: (List<Entity>, Entity) -> Boolean = { _, _ -> true }): Component {

    private val entities: MutableList<Entity> = ArrayList()

    fun add(e: Entity): Boolean {
        if (!canHold(entities, e)) return false
        entities.add(e)
        return true
    }

    fun remove(e: Entity) = entities.remove(e)

    fun invCommand(player: Player, command: String, args: Array<String>) {
        entities.forEach {e ->
            e.forEachComponent {
                it.command(player, e, command, args)
            }
        }
    }

    override fun commandList(commands: MutableSet<String>) {
        entities.forEach { e ->
            e.forEachComponent {
                it.commandList(commands)
            }
        }
    }
}