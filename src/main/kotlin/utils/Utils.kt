package utils

interface Utils<T> {
    fun save(data: T)
    fun getRecent(): T
    fun delete()
    fun size(): Int
    fun isContains(data: T): Boolean
    fun addAll(data: ArrayList<Int>)
    fun deleteRecent()
    fun getRecentCount(): Int
    fun showAll()
}