import org.example.LinkedListCustom
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class Tests {

    @Test
    fun addElementToEmptyList() {
        val list = LinkedListCustom<Int>()
        list.add(10)
        assert(!list.isEmpty())
        assertEquals(1, list.head)
    }

    @Test
    fun addElementToNonEmptyList() {
        val list = LinkedListCustom<Int>()
        list.add(1)
        list.add(2)
        assertEquals(2, list.headNext?.head)
    }

    @Test
    fun addMultipleElements() {
        val list = LinkedListCustom<Int>()
        list.add(1)
        list.add(2)
        list.add(3)
        assertEquals(3, list.headNext?.headNext?.head)
    }

    @Test
    fun displayList() {
        val list = LinkedListCustom<Int>()
        list.add(1)
        list.add(2)
        list.add(3)
        val outputStream = java.io.ByteArrayOutputStream()
        System.setOut(java.io.PrintStream(outputStream))
        list.display()
        assertEquals("1 -> 2 -> 3 -> Done\n", outputStream.toString())
    }

    @Test
    fun deleteElementFromList() {
        val list = LinkedListCustom<Int>()
        list.add(1)
        list.add(2)
        list.add(3)
        list.delete(2)
        assertEquals(1, list.head)
        assertEquals(3, list.headNext?.head)
    }

    @Test
    fun insertElementAtMiddle() {
        val list = LinkedListCustom<Int>()
        list.add(1)
        list.add(3)
        list.insert(2, 1)
        assertEquals(1, list.head)
        assertEquals(2, list.headNext?.head)
        assertEquals(3, list.headNext?.headNext?.head)
    }

    @Test
    fun insertElementAtEnd() {
        val list = LinkedListCustom<Int>()
        list.add(1)
        list.add(2)
        list.insert(3, 2)
        assertEquals(1, list.head)
        assertEquals(2, list.headNext?.head)
        assertEquals(3, list.headNext?.headNext?.head)
    }
}