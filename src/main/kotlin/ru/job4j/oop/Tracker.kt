package ru.job4j.oop

import kotlin.random.Random

/** Максимальное количество заявок */
private const val MAX_ITEMS = 100

/**
 * Хранение заявок.
 */
class Tracker {

    /** Массив заявок */
    private val items: Array<Item?> = arrayOfNulls(MAX_ITEMS)
    /** Индекс ячейки, где будет создана следующая заявка */
    private var position = 0

    /**
     * Добавляет заявку в список и присваивает ей иднетификатор
     * @param item заявка
     * @return добавленная заявка
     */
    fun add(item: Item): Item {
        item.id = generateId()
        items[position++] = item
        return item
    }

    /**
     * Генерирует id заявки
     * @return идентификатор
     */
    private fun generateId() = "${System.currentTimeMillis() + Random.nextInt()}"

    /**
     * Заменяет заявку с заданным идентификатором
     * @param id идентификатор
     * @param replace замена
     */
    fun replace(id: String, replace: Item) {
        for (i in 0 until position) {
            if (items[i]?.id == id) {
                replace.id = id
                items[i] = replace
                break
            }
        }
    }

    /**
     * Удаляет из списка заявку с заданным Id
     * @param id идентификатор заявки
     */
    fun delete(id:String) {
        for ((index, element) in items.withIndex()) {
            if (element?.id == id) {
                System.arraycopy(items, index + 1, items, index, position - index - 1)
                items[--position] = null
            }
        }
    }

    /**
     * Возвращает список всех заявок
     * @return все заявки
     */
    fun getAll(): Array<Item?> = items.copyOf(position)

    /**
     * Находит все заявки с заданным именем
     * @param key имя для поиска
     * @return список всех найденных заявок
     */
    fun findByName(key: String): Array<Item?> {
        var counter = 0
        val result = arrayOfNulls<Item>(MAX_ITEMS)
        for (i in 0 until position) {
            if (items[i]?.name == key) {
                result[counter++] = items[i]
            }
        }
        return result.copyOf(counter)
    }

    /**
     * Поиск заявки по идентификатору
     * @param id идентификатор
     * @return результат поиска
     */
    fun findById(id: String): Item? {
        var result: Item? = null
        for (i in 0 until position) {
            if (items[i]?.id == id) {
                result = items[i]
                break
            }
        }
        return result
    }
}
