package org.example

fun main() {
    println("Guten Tag!");
    val list = LinkedListCustom<Int>();
    list.add(10);
    list.add(20);
    list.add(30);
    list.add(40);
    list.display();

    list.delete(30)
    list.display();

    list.push(30)
    list.display()

    list.insert(25,3)
    list.display()

    list.size()
}