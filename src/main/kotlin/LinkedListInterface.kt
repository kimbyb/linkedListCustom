package org.example

interface LinkedListInterface<T> {
    fun isEmpty(): Boolean
    fun add(value: T)
    fun push(value: T)
    fun insert(value: T, index: Int)
    fun delete(value: T)
    fun size(): Int
    fun display()
}