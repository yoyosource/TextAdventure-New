package de.yoyosource.component.impl

import de.yoyosource.component.Component
import de.yoyosource.entity.Entity
import de.yoyosource.entity.Player

object Pickupable: Component {

    override fun command(player: Player, entity: Entity, command: String, args: Array<String>) {
        if (command != "pickup") return
        if (args.size != 1) return
        val itemName = args[0]
        if (itemName != entity.name) return
        if (!player.add(entity)) {
            player.sendMessage("You can't hold more items")
            return
        }
        player.room?.getComponent(Inventory::class.java)?.remove(entity)
    }

    override fun commandList(commands: MutableSet<String>) {
        commands.add("pickup [item]")
    }
}