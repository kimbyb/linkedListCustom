package org.example

class LinkedListCustom<T> : LinkedListInterface<T> {

    private var head: Node<T>? = null
    private var listSize: Int = 0

    private fun forEach(action: (Node<T>) -> Unit) {
        var current = head
        while (current != null) {
            action(current)
            current = current.next
        }
    }

    override fun isEmpty(): Boolean {
        return head == null;
    }

    override fun add(value: T) {
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
        listSize++
    }

    //Adds to beginning
    override fun push(value: T) {
        val newNode = Node(value)
        newNode.next = head
        head = newNode
        listSize++
    }

    //Adds on index
    override fun insert(value: T, index: Int) {
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
        listSize++
    }

    //Display the list
    override fun display() {
        var current = head
        forEach { print("${it.data} -> ") }
        println("Done");
    }

    //Deletes value from list
    override fun delete(value: T) {
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
        listSize--
    }

    fun deleteLast() {
        if (head == null) {
            return
        }

        if (head?.next == null) {
            head = null
            return
        }

        var current = head
        while (current?.next?.next != null) {
            current = current.next
        }
        current?.next = null
        listSize--
    }


    //Size of the list
    override fun size(): Int {
        println("Size: $listSize")
        return listSize
    }

    override fun toString(): String {
        val stringBuilder = StringBuilder()
        forEach { stringBuilder.append("${it.data} -> ") }
        stringBuilder.append("Done")
        return stringBuilder.toString()
    }

}