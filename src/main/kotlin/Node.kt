package org.example

data class Node<T>(
    var data: T,
    var next: Node<T>? = null
)