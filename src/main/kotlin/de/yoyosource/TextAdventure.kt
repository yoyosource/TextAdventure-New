package de.yoyosource

import de.yoyosource.entity.Player
import yapion.hierarchy.output.SystemOutput
import yapion.hierarchy.output.flavours.YAPIONFlavour
import yapion.hierarchy.types.YAPIONObject
import yapion.serializing.YAPIONSerializer

fun main() {
    var player = Player()
    player.command("help")

    YAPIONSerializer.serialize<YAPIONObject>(player).output(SystemOutput(), YAPIONFlavour())
}