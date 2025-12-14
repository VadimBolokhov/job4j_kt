package ru.job4j.oop

class StartUI {

    companion object {

        private const val MENU_ADD = "0"
        private const val MENU_SHOW_ALL = "1"
        private const val MENU_EXIT = "2"

        private val tracker = Tracker()

        fun init() {
            var exit = false;
            while (!exit) {
                showMenu()
                println("Выберите пункт меню: ")
                val menuItem = readln()
                when (menuItem) {
                    MENU_ADD -> createItem()
                    MENU_SHOW_ALL -> showAllItems()
                    MENU_EXIT -> exit = true
                }
            }
        }

        private fun showMenu() {
            val menu = """
            Меню
            0. Добавить заявку
            1. Показать все заявки
            2. Выйти
        """.trimIndent()
            println(menu)
        }

        private fun createItem() {
            println("Добавление новой заявки")
            println("Введите название заявки : ")
            val name = readln()
            println("Введите описание заявки : ")
            val description = readln()
            val newItem = Item(name = name, desc = description, created = System.currentTimeMillis())
            tracker.add(newItem)
            println("Создана заявка ID = ${newItem.id}")
        }

        private fun showAllItems() {
            val items = tracker.getAll()
            if (items.isEmpty()) {
                println("Заявок нет")
                return
            }
            println("Список заявок:")
            for ((i, item) in items.withIndex()) {
                println("""
                $i. ID=${item.id}
                name=${item.name}
                desc=${item.desc}
                created=${item.created}
                
                """.trimIndent())
            }
        }
    }
}
