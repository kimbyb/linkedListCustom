package org.example

class LinkedListCustom<T> {

    private var head: Node<T>? = null

    fun isEmpty(): Boolean {
        return head == null;
    }

    fun add(value: T) {
        val newNode = Node(value)
        if (head == null) {
            head = newNode
        } else {
            var current = head
            while (current?.next != null) {
                current = current.next
            }
            current?.next = newNode
        }
    }

    fun push(value: T) {
        val temp = LinkedListCustom<T>().apply {
            head = this@LinkedListCustom.head
            headNext = this@LinkedListCustom.headNext
        }
        head = value
        headNext = temp
    }

    fun insert(value: T, index: Int) {
        if (index == 0) {
            push(value)
        } else {
            var current: LinkedListCustom<T>? = this
            for (i in 0 until index - 1) {
                current = current?.headNext
            }
            val temp = LinkedListCustom<T>().apply { head = value }
            temp.headNext = current?.headNext
            current?.headNext = temp
        }
    }

    fun display() {
        var current: LinkedListCustom<T>? = this;
        while (current?.head != null) {
            print("${current.head} -> " );
            current = current.headNext;
        }
        println("Done");
    }

    fun delete(value: T) {
        if (head == value) {
            head = headNext?.head
            headNext = headNext?.headNext
        } else {
            var current: LinkedListCustom<T>? = this
            while (current?.headNext != null) {
                if (current.headNext?.head == value) {
                    current.headNext = current.headNext?.headNext
                    break
                }
                current = current.headNext
                }
            }
        }

    fun size() {
        var counter: Int = 0
        var current: LinkedListCustom<T>? = this

        while (current?.head != null) {
            counter++
            current = current.headNext
        }
        println("Size: $counter")
    }
}