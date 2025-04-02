package org.example

fun main() {
    println("Guten Tag!");
    val list = LinkedListCustom<Int>();
    list.add(10);
    list.add(20);
    list.add(30);
    list.add(40);

    list.display();
}