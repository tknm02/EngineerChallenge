package com.app.queue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;

class ImmutableQueueTest {

    private ImmutableQueue<Integer> integerQueue;

    private ImmutableQueue<String> stringQueue;

    private ImmutableQueue emptyQueue;

    @BeforeEach
    private void init() {
        integerQueue = new ImmutableQueue<>(new ArrayDeque<>(Arrays.asList(1, 2, 3, 4, 5, 6)));
        stringQueue = new ImmutableQueue<>(new ArrayDeque<>(Arrays.asList("Alice", "Bob", "Charlie")));
        emptyQueue = new ImmutableQueue<>(new ArrayDeque<>());
    }

    @Test
    void testIsEmpty() {
        assertTrue(emptyQueue.isEmpty());
        assertFalse(integerQueue.isEmpty());
        assertFalse(stringQueue.isEmpty());
    }

    @Test
    void testHeadExpectedValue() {
        assertThrows(NoSuchElementException.class, () -> emptyQueue.head());
        assertEquals(1, integerQueue.head().intValue());
        assertEquals("Alice", stringQueue.head());
    }

    @Test
    void testDequeueExpectedValue() {
        assertThrows(NoSuchElementException.class, () -> emptyQueue.deQueue());
        integerQueue.deQueue();
        assertEquals(1, integerQueue.head().intValue());
        stringQueue.deQueue();
        assertEquals("Alice", stringQueue.head());
    }

    @Test
    void testImmutableQueue() {
        stringQueue.enQueue("Dave");
        assertEquals("Alice", stringQueue.head());
        stringQueue.deQueue();
        assertEquals("Alice", stringQueue.head());
        stringQueue.deQueue();
        stringQueue.deQueue();
        assertEquals("Alice", stringQueue.head());
    }
}
