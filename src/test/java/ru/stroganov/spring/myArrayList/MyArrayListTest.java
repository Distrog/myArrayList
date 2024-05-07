package ru.stroganov.spring.myArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.stroganov.spring.myArrayList.exception.ArrayDoesNotContainsElementException;
import ru.stroganov.spring.myArrayList.exception.ArrayOverFlowException;
import ru.stroganov.spring.myArrayList.exception.IndexIsGreaterThanArraySizeException;

import static org.junit.jupiter.api.Assertions.*;

class MyArrayListTest {
    StringList stringList;

    @BeforeEach
    void setUp() {
        stringList = new MyArrayList();
    }

    @Test
    public void shouldAddSimpleString() {
        assertEquals("String", stringList.add("String"));
    }

    @Test
    public void shouldAddOverFlowElement() {
        for (int i = 0; i < 100; i++) {
            stringList.add("String " + i);
        }
        assertThrows(ArrayOverFlowException.class,
                () -> stringList.add("String"));
    }

    @Test
    public void shouldAddOnIndex() {
        stringList.add("String");
        stringList.add("String2");
        stringList.add("String3");
        assertEquals("String4", stringList.add(2, "String4"));
        assertEquals("String4", stringList.get(2));
        assertEquals("String3",stringList.get(3));
    }
    @Test
    public void shouldAddOverFlowElementOnIndex(){
        stringList.add("String");
        assertThrows(IndexIsGreaterThanArraySizeException.class,
                ()->stringList.add(5,"String"));
    }

    @Test
    public void shouldSetElement(){
        stringList.add("String");
        assertEquals("String2",stringList.set(0,"String2"));
        assertEquals("String2",stringList.get(0));
    }

    @Test
    public void shouldSetOverFlowElement(){
        stringList.add("String");
        assertThrows(IndexIsGreaterThanArraySizeException.class,
                ()->stringList.set(2,"String"));
    }

    @Test
    public void shouldRemoveElement(){
        stringList.add("String");
        assertEquals("String",stringList.remove("String"));
    }

    @Test
    public void shouldRemoveElementThatArrayDoesNotContains(){
        stringList.add("String");
        assertThrows(ArrayDoesNotContainsElementException.class,
                ()->stringList.remove("String2"));
    }
    @Test
    public void shouldRemoveElementByIndex(){
        stringList.add("String");
        assertEquals("String",stringList.remove(0));
    }

    @Test
    public void shouldRemoveElementThatArrayDoesNotContainsByIndex(){
        stringList.add("String");
        assertThrows(IndexIsGreaterThanArraySizeException.class,
                ()->stringList.remove(1));
    }

    @Test
    public void shouldArrayContainsElement(){
        stringList.add("String");
        assertTrue(stringList.contains("String"));
    }

    @Test
    public void shouldArrayDoesNotContainsElement(){
        stringList.add("String");
        assertFalse(stringList.contains("String2"));
    }

    @Test
    public void shouldIndexOfElement(){
        stringList.add("String");
        stringList.add("String2");
        stringList.add("String3");
        stringList.add("String2");
        assertEquals(stringList.indexOf("String2"),1);
    }

    @Test
    public void shouldIndexOfNonExistingElement(){
        stringList.add("String");
        stringList.add("String2");
        stringList.add("String3");
        stringList.add("String2");
        assertEquals(-1,stringList.indexOf("String4"));
    }
    @Test
    public void shouldLastIndexOfElement(){
        stringList.add("String");
        stringList.add("String2");
        stringList.add("String3");
        stringList.add("String2");
        assertEquals(stringList.lastIndexOf("String2"),3);
    }

    @Test
    public void shouldLastIndexOfNonExistingElement(){
        stringList.add("String");
        stringList.add("String2");
        stringList.add("String3");
        stringList.add("String2");
        assertEquals(stringList.lastIndexOf("String4"),-1);
    }

    @Test
    public void shouldGetElement(){
        stringList.add("String");
        stringList.add("String2");
        stringList.add("String3");
        assertEquals("String2",stringList.get(1));
    }
@Test
    public void shouldGetElementWithIndexWithGreaterThanSizeOfArray(){
        stringList.add("String");
        stringList.add("String2");
        stringList.add("String3");
        assertThrows(IndexIsGreaterThanArraySizeException.class,
                ()->stringList.get(5));
    }

    @Test
    public void shouldGetSize(){
        stringList.add("String");
        stringList.add("String2");
        stringList.add("String3");
        assertEquals(3,stringList.size());
        stringList.remove(2);
        assertEquals(2,stringList.size());
    }

    @Test
    public void shouldIsEmpty(){
        assertTrue(stringList.isEmpty());
        stringList.add("String");
        assertFalse(stringList.isEmpty());
    }

    @Test
    public void shouldClear(){
        stringList.add("String");
        stringList.add("String2");
        stringList.add("String3");
        stringList.clear();
        assertTrue(stringList.isEmpty());
        assertThrows(IndexIsGreaterThanArraySizeException.class,
                ()->stringList.get(0));
    }

    @Test
    public void shouldToArray(){
        stringList.add("String");
        stringList.add("String2");
        stringList.add("String3");
        String[] newArray = stringList.toArray();
        assertEquals("String",newArray[0]);
        assertEquals("String2",newArray[1]);
        assertEquals("String3",newArray[2]);
        assertEquals(3,newArray.length);
    }
}