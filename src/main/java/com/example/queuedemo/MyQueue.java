package com.example.queuedemo;

import com.google.common.collect.ImmutableList;

/**
 * Implementation of an immutable Queue.
 * Empty queue: represented by empty "data" field. head() will return null.
 *
 *
 * @param <T>
 */
public class MyQueue<T> implements Queue<T> {

	private final ImmutableList<T> data;

	private MyQueue(ImmutableList<T> list) {
		this.data = list;
	}

	public MyQueue() {
		this.data = ImmutableList.<T>builder().build();
	}

	public static MyQueue getEmptyQueue() {
		return new MyQueue();
	}

	@Override
	public T head() {
		return isEmpty() ? null : this.data.get(0);
	}

	@Override
	public boolean isEmpty() {
		return !(this.data.size() > 0);
	}

	@Override
	public Queue<T> enQueue(T t) {
		if (isEmpty()) {
			return new MyQueue<>(
					ImmutableList.<T>builder()
							.add(t)
							.build());
		}
		return new MyQueue<>(
				ImmutableList.<T>builder()
						.addAll(this.data)
						.add(t)
						.build());
	}

	@Override
	public Queue<T> deQueue() {
		if (isEmpty()) {
			return new MyQueue<>();
		}
		return new MyQueue<>(this.data.subList(1, this.data.size()));
	}
}
