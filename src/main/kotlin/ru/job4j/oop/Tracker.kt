package ru.job4j.oop

import java.util.UUID

/**
 * Хранение заявок.
 */
class Tracker {

    /** Массив заявок */
    private val items = HashMap<UUID, Item>()

    /**
     * Добавляет заявку в список и присваивает ей иднетификатор
     * @param item заявка
     * @return true - если заявка успешно добавлена
     */
    fun add(item: Item): Boolean {
        var result = false
        if (!items.containsKey(item.id)) {
            items[item.id] = item
            result = true
        }
        return result
    }

    /**
     * Заменяет заявку с заданным идентификатором
     * @param id идентификатор
     * @param replace замена
     */
    fun replace(replace: Item) {
        items[replace.id] = replace
    }

    /**
     * Удаляет из списка заявку с заданным Id
     * @param id идентификатор заявки
     */
    fun delete(id: UUID) {
        items.remove(id)
    }

    /**
     * Возвращает список всех заявок
     * @return все заявки
     */
    fun getAll(): List<Item> = items.values.toList()

    /**
     * Находит все заявки с заданным именем
     * @param key имя для поиска
     * @return список всех найденных заявок
     */
    fun findByName(key: String): List<Item> = items.values.filter { item -> key == item.name }

    /**
     * Поиск заявки по идентификатору
     * @param id идентификатор
     * @return результат поиска
     */
    fun findById(id: UUID): Item? = items[id]
}
