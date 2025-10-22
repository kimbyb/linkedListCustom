package org.example

class LinkedListCustom<T> : LinkedListInterface<T> {

    private var head: Node<T>? = null
    private var tail: Node<T>? = null;
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
            tail = newNode
        } else {
            tail?.next = newNode
            tail = newNode
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
        if (head == null) return

        if (head?.data == value) {
            head = head?.next
            if (head == null) tail = null  // list became empty
            listSize--
            return
        }

        var current = head
        while (current?.next != null) {
            if (current.next?.data == value) {
                if (current.next == tail) {
                    tail = current
                }
                current.next = current.next?.next
                listSize--
                return
            }
            current = current.next
        }
    }

    fun deleteLast() {
        if (head == null) return

        if (head?.next == null) {
            head = null
            tail = null
            listSize--
            return
        }

        var current = head
        while (current?.next?.next != null) {
            current = current.next
        }
        current?.next = null
        tail = current
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