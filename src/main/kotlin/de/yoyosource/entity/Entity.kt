package de.yoyosource.entity

import de.yoyosource.component.Component

open class Entity(val name: String) {

    var components: MutableMap<Class<Component>, Component> = mutableMapOf()

    fun forEachComponent(action: (Component) -> Unit) {
        components.values.forEach(action)
    }

    fun addComponent(component: Component) {
        components[component.javaClass] = component
    }

    fun deleteComponent(componentType: Class<Component>) {
        components.remove(componentType)
    }

    fun <T: Component> getComponent(componentType: Class<T>): T {
        return components[componentType as Class<Component>] as T
    }

    inline fun <reified T : Component> getComponent(): T {
        return components[T::class.java as Class<Component>] as T
    }
}