package com.example.queuedemo;

public interface Queue<T> {

	T head();

	boolean isEmpty();

	Queue<T> enQueue(T t);

	//Remove the element at the beginning of the immutable queue, and returns the new queue.
	Queue<T> deQueue();
}
