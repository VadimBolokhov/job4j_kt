package ru.job4j.oop

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class TrackerTest {

    @Test
    fun whenAddNewItemThenTrackerHasSameItem() {
        val tracker = Tracker()
        val item = Item("test1", "testDescription", 123)

        tracker.add(item)

        val items = tracker.getAll()
        assertThat(items.size).isEqualTo(1)
        assertThat(items[0]).isEqualTo(item)
        assertThat(items[0]?.id).isNotNull()
    }

    @Test
    fun whenDeleteItemThenTrackerHasNoSameItem() {
        val tracker = Tracker()
        val item = Item("test1", "testDescription", 123)
        tracker.add(item)

        tracker.delete(item.id!!)

        assertThat(tracker.getAll().size).isEqualTo(0)
    }

    @Test
    fun whenFindByIdExistingItemThenReturnItem() {
        val tracker = Tracker()
        val item = Item("test1", "testDescription", 123)
        tracker.add(item)

        val result = tracker.findById(item.id!!)

        assertThat(result).isEqualTo(item)
    }

    @Test
    fun whenFindByIdUnexistingItemThenReturnNull() {
        val tracker = Tracker()

        val result = tracker.findById("test")

        assertThat(result).isNull()
    }

    @Test
    fun whenReplaceItemThenItemIsReplaced() {
        val tracker = Tracker()
        val item = Item("test1", "testDescription1", 123)
        val replacement = Item("test2", "testDescription2", 456)
        tracker.add(item)

        tracker.replace(item.id!!, replacement)

        assertThat(tracker.getAll()[0]).isEqualTo(replacement)
    }

    @Test
    fun whenGetAllItemsThenReturnAllItems() {
        val tracker = Tracker()
        val item = Item("test1", "testDescription1", 123)
        tracker.add(item)

        val result = tracker.getAll()

        assertThat(result.size).isEqualTo(1)
        assertThat(result[0]).isEqualTo(item)
    }

    @Test
    fun whenFindByNameExistingItemThenReturnItem() {
        val tracker = Tracker()
        val item = Item("test1", "testDescription1", 123)
        tracker.add(item)

        val result = tracker.findByName(item.name!!)

        assertThat(result.size).isEqualTo(1)
        assertThat(result[0]).isEqualTo(item)
    }

    @Test
    fun whenFindByNameUnexistingItemThenReturnEmptyArray() {
        val tracker = Tracker()
        val item = Item("test1", "testDescription1", 123)
        tracker.add(item)

        val result = tracker.findByName("test2")

        assertThat(result.size).isEqualTo(0)
    }
}
