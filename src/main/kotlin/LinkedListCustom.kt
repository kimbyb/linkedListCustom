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

    //Adds to beginning
    fun push(value: T) {
        val newNode = Node(value)
        newNode.next = head
        head = newNode
    }

    //Adds on index
    fun insert(value: T, index: Int) {

        if (index > size()) {
            throw IndexOutOfBoundsException("Index out of bounds")
        }

        if (index == 0) {
            push(value)
        } else {
            var current = head
            for (i in 0 until index - 1) {
                if (current == null) {
                    throw IndexOutOfBoundsException("Index out of bounds")
                }
                current = current.next
            }
            val newNode = Node(value)
            newNode.next = current?.next
            current?.next = newNode
        }
    }

    //Display the list
    fun display() {
        var current = head
        while (current != null) {
            print("${current.data} -> " );
            current = current.next;
        }
        println("Done");
    }

    //Deletes value from list
    fun delete(value: T) {
        if (head?.data == value) {
            head = head?.next
            return
        }

        var current = head
        while (current?.next != null) {
            if (current.next?.data == value) {
                current.next = current.next?.next
                return
            }
            current = current.next
        }
    }

    //Size of the list
    fun size(): Int {
        var counter: Int = 0
        var current = head

        while (current != null) {
            counter++
            current = current.next
        }
        println("Size: $counter")
        return counter
    }

    override fun toString(): String {
        val stringBuilder = StringBuilder()
        var current = head
        while (current != null) {
            stringBuilder.append("${current.data} -> ")
            current = current.next
        }
        stringBuilder.append("Done")
        return stringBuilder.toString()
    }
}