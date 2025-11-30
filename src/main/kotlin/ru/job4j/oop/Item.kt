package ru.job4j.oop

class Item{

    /** Id заявки */
    var id: String? = null
    /** Имя */
    var name: String? = null
    /** Описание */
    var desc: String? = null
    /** Дата создания */
    var created: Long? = null
    /** Список комментариев */
    var comments: Array<String>? = null

    constructor() : this(name = "DefaultItem", desc = "Default description", created = System.currentTimeMillis())

    constructor(name: String, desc: String, created: Long) {
        this.name = name
        this.desc = desc
        this.created = created
    }
}
