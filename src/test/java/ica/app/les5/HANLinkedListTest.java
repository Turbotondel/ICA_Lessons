package ica.app.les5;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class HANLinkedListTest {
    HANLinkedList linkedList;

    @Before
    public void setup() {
        linkedList = new HANLinkedList();
    }

    @Test
    public void addFirst() throws Exception {
        String string = "Test";
        linkedList.add(string);
        assertEquals(string, linkedList.get(0));
        String string2 = "Test2";
        linkedList.add(string2);
        assertEquals(string2, linkedList.get(0));
    }

    @Test
    public void add() throws Exception {

    }

    @Test
    public void delete() throws Exception {
    }

    @Test
    public void get() throws Exception {
    }

    @Test
    public void removeFirst() throws Exception {
    }

}