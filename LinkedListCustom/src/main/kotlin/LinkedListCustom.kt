package org.example

class LinkedListCustom<T> {

    private var head: T? = null;
    private var headNext: LinkedListCustom<T>? = null;

    fun isEmpty(): Boolean {
        return head == null;
    }

    fun add(value: T) {
        if (head == null) {
            head = value
        } else {
            var current: LinkedListCustom<T> = this
            while (current.headNext != null) {
                current = current.headNext!!
            }
            current.headNext = LinkedListCustom<T>().apply { head = value }
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
}