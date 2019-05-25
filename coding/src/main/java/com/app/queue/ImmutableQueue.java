package com.app.queue;

import java.util.ArrayDeque;
import java.util.Deque;

public final class ImmutableQueue<T> implements Queue<T> {

    private final Deque<T> deque;

    public ImmutableQueue(Deque<T> deque) {
        this.deque = deque;
    }

    @Override
    public Queue<T> enQueue(T t) {
      var newDequeue = new ArrayDeque<>(deque);
      newDequeue.add(t);
      return new ImmutableQueue<>(newDequeue);
    }

    @Override
    public Queue<T> deQueue() {
      var newDequeue = new ArrayDeque<>(deque);
      newDequeue.removeFirst();
      return new ImmutableQueue<>(newDequeue);
    }

    @Override
    public T head() {
      return deque.getFirst();
    }

    @Override
    public boolean isEmpty() {
      return deque.isEmpty();
    }
}
