package ru.job4j.oop

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import java.util.UUID

private val UUID_0 = UUID.fromString("00000000-0000-0000-0000-000000000000")

class TrackerTest {

    @Test
    fun whenAddNewItemThenTrackerHasSameItem() {
        val tracker = Tracker()
        val item = Item(id = UUID_0, "test1", desc = "desc1")

        tracker.add(item)

        val items = tracker.getAll()
        assertThat(items.size).isEqualTo(1)
        assertThat(items[0]).isEqualTo(item)
        assertThat(items[0].id).isNotNull()
    }

    @Test
    fun whenDeleteItemThenTrackerHasNoSameItem() {
        val tracker = Tracker()
        val item = Item(id = UUID_0, "test1", desc = "desc1")
        tracker.add(item)

        tracker.delete(item.id)

        assertThat(tracker.getAll().size).isEqualTo(0)
    }

    @Test
    fun whenFindByIdExistingItemThenReturnItem() {
        val tracker = Tracker()
        val item = Item(id = UUID_0, "test1", desc = "desc1")
        tracker.add(item)

        val result = tracker.findById(item.id)

        assertThat(result).isEqualTo(item)
    }

    @Test
    fun whenFindByIdUnexistingItemThenReturnNull() {
        val tracker = Tracker()

        val result = tracker.findById(UUID_0)

        assertThat(result).isNull()
    }

    @Test
    fun whenReplaceItemThenItemIsReplaced() {
        val tracker = Tracker()
        val item = Item(id = UUID_0, "test1", desc = "desc1")
        val replacement = Item(id = UUID_0, "test2", desc = "desc2")
        tracker.add(item)

        tracker.replace(replacement)

        assertThat(tracker.findById(UUID_0)).isEqualTo(replacement)
    }

    @Test
    fun whenGetAllItemsThenReturnAllItems() {
        val tracker = Tracker()
        val item = Item(id = UUID_0, "test1", desc = "desc1")
        tracker.add(item)

        val result = tracker.getAll()

        assertThat(result.size).isEqualTo(1)
        assertThat(result[0]).isEqualTo(item)
    }

    @Test
    fun whenFindByNameExistingItemThenReturnItem() {
        val tracker = Tracker()
        val item = Item(id = UUID_0, "test1", desc = "desc1")
        tracker.add(item)

        val result = tracker.findByName(item.name)

        assertThat(result.size).isEqualTo(1)
        assertThat(result[0]).isEqualTo(item)
    }

    @Test
    fun whenFindByNameUnexistingItemThenReturnEmptyArray() {
        val tracker = Tracker()
        val item = Item(id = UUID_0, "test1", desc = "desc1")
        tracker.add(item)

        val result = tracker.findByName("test2")

        assertThat(result.size).isEqualTo(0)
    }
}
