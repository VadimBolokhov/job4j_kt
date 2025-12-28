package ru.job4j.oop

class Student(
    var name: String = "",
    var surname: String = "",
    var phone: String = "",
    var email: String = ""
) {

    constructor(name: String) : this(name, "", "", "")

    constructor(name: String, surname: String) : this(name, surname, "", "")

    constructor(name: String, surname: String, phone: String) : this(name, surname, phone, "")
}
