package storage

import model.Data
import utils.KeywordsAndConstants
import utils.Utils

class Storage<T>() : Utils<T> {

    private val storageSize = KeywordsAndConstants.STORAGE_SIZE
    private var counter = 0
    private val storage: ArrayList<Data<T>> = ArrayList()

    override fun save(data: T) {

        if (!isContains(data)) {
            storage.add(
                Data(element = data, count = 1)
            )
        } else {
            updateCount(data)
        }
    }

    override fun getRecent(): T {
        if (storage.size == 0) {
            println("memory is empty,add element")
        }
        val data = storage[size() - 1].element
        updateCount(data)
        return data
    }

    override fun delete() {
        deleteLowestUsedElement()
    }

    override fun size(): Int {
        return storage.size
    }

    override fun isContains(data: T): Boolean {
        for (element in storage) {
            if (element.element == data) {
                updateCount(data)
                return true
            }
        }
        return false
    }

    override fun addAll(data: ArrayList<Int>) {

    }

    private fun deleteLowestUsedElement() {
        try {
            storage.remove(
                findLowestUsedElement()
            )
        } catch (e: Exception) {
            throw RuntimeException(e.message)
        }

    }

    private fun findLowestUsedElement(): Data<T> {
        if (storage.size == 0) {
            println("memory is empty,add element")
        }
        var count = storage[0].count
        var data: Data<T> = storage[0]

        for (element in storage) {
            if (element.count < count) {
                count = element.count
                data = element
            }
        }
        return data
    }

    private fun updateCount(data: T) {
        for (element in storage) {
            if (element.element == data) {
                element.count += 1
            }
        }
    }

    override fun showAll() {
        if (storage.size == 0) {
            println("memory is empty,add element")
            return
        }
        for (data in storage) {
            println(data.element)
        }
    }

    override fun deleteRecent() {
        if (storage.size == 0) {
            println("memory is empty,add element")
            return
        }
        storage.remove(Data(element = getRecent(), count = getRecentCount()))
    }

    override fun getRecentCount(): Int {
        for (data in storage) {
            if (data.element == getRecent()) {
                return data.count
            }
        }
        return 0
    }
}