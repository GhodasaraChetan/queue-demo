package com.example.queuedemo;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;

public class MyQueueTest {

	@Test
	public void new_empty_queue() {
		Queue<String> que = new MyQueue<>();
		assertThat(que.isEmpty()).isTrue();
		assertThat(que.head()).isNull();
	}

	@Test
	public void one_element_queue() {
		Queue<String> que = new MyQueue<>();

		//enque one element
		Queue<String> enQue = que.enQueue("one");

		//isEmpty check
		assertThat(enQue.isEmpty()).isFalse();

		//head check
		String head = enQue.head();
		assertThat(head).isEqualTo("one");

		//dequeue check
		Queue<String> deQue = enQue.deQueue();
		assertThat(deQue).isEqualToComparingFieldByField(que);
		assertThat(deQue.isEmpty()).isTrue();
		assertThat(deQue.head()).isNull();

	}

	@Test
	public void multiple_elements_queue() {
		Queue<String> que = new MyQueue<>();

		//enque 3 elements
		que = que.enQueue("one");
		que = que.enQueue("two");
		que = que.enQueue("three");
		assertThat(que.isEmpty()).isFalse();

		//head check
		String head = que.head();
		assertThat(head).isEqualTo("one");

		//dequeue check
		que = que.deQueue();
		assertThat(que.head()).isEqualTo("two");
		assertThat(que.isEmpty()).isFalse();

		que = que.deQueue();
		assertThat(que.head()).isEqualTo("three");
		assertThat(que.isEmpty()).isFalse();

		que = que.deQueue();
		assertThat(que.head()).isNull();
		assertThat(que.isEmpty()).isTrue();
	}
}