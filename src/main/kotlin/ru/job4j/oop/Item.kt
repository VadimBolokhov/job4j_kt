package ru.job4j.oop

import java.util.UUID

data class Item(
    /** Id заявки */
    var id: UUID,
    /** Имя */
    var name: String = "",
    /** Описание */
    var desc: String = "",
    /** Дата создания */
    var created: Long = 0,
    /** Список комментариев */
    var comments: Array<String> = arrayOf()
)
