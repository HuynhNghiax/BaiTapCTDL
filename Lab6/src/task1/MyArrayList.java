package task1;

import java.util.Arrays;
import java.util.Comparator;

public class MyArrayList<E> {
	public static final int DEFAULT_CAPACITY = 10;
	private E[] elements;
	private int size;

	public MyArrayList() {
		this.elements = (E[]) new Object[DEFAULT_CAPACITY];
	}

	public MyArrayList(int capacity) {
		this.elements = (E[]) new Object[capacity];
	}
	public void growSize() {
		if (elements.length == size) {
			int newCapatity = elements.length * 2;
			E[] newElements = (E[]) new Object[newCapatity];
			System.arraycopy(elements, 0, newElements, 0, size);
			elements = newElements;
		}
	}
	public int size() {
		return size;
	}
	public boolean isEmpty() {
		return size == 0;
	}
	public E get(int i) throws IndexOutOfBoundsException {
		if (i < 0 || i >= size) {
			throw new ArrayIndexOutOfBoundsException("");
		} else {
			return elements[i];
		}
	}
	public E set(int i, E e) throws IndexOutOfBoundsException {
		if (i < 0 || i > size) {
			throw new ArrayIndexOutOfBoundsException("");
		} else {
			E replacedElement = elements[i];
			elements[i] = e;
			return replacedElement;
		}
	}
	public boolean add(E e) {
		elements[size++] = e;
		growSize();
		return true;
	}
	public void add(int i, E e) throws IndexOutOfBoundsException {
		if (i < 0 || i > size) {
			throw new ArrayIndexOutOfBoundsException("");
		} else {
			growSize();
			E[] data = Arrays.copyOf(elements, elements.length);
			for (int j = size; j > 0; j--) {
				if (j == i) {
					elements[j] = e;
					break;
				} else {
					elements[j] = elements[j - 1];
				}
			}
			size++;
		}
	}
	public E remove(int i) throws IndexOutOfBoundsException {
		if (i < 0 || i > size) {
			throw new ArrayIndexOutOfBoundsException("");
		} else {
			E removedElement = elements[i];
			System.arraycopy(elements, i + 1, elements, i, size - 1 - i);
			elements[--size] = null;
			return removedElement;
		}
	}
	public void clear() {
		for (int i = 0; i < elements.length; i++) {
			elements[i] = null;
		}
		size = 0;
	}
	public int lastIndexOf(Object o) {
		for (int i = size - 1; i >= 0; i--) {
			if (o.equals(elements[i])) {
				return i;
			}
		}
		return -1;
	}
	public E[] toArray() {
		return Arrays.copyOf(elements, size);
	}
	public MyArrayList<E> clone() {
		MyArrayList<E> clonedList = new MyArrayList<>(size);
		clonedList.size = this.size;
		clonedList.elements = this.toArray();
		return clonedList;
	}
	public boolean contains(E o) {
		return indexOf(o) >= 0;
	}
	public int indexOf(E o) {
		for (int i = 0; i < elements.length; i++) {
			if (o.equals(elements[i])) {
				return i;
			}
		}
		return -1;
	}
	public boolean remove(E e) {
		for (int i = 0; i < size; i++) {
			if (e.equals(elements[i])) {
				remove(i);
				return true;
			}
		}
		return false;
	}
	public void sort(Comparator<E> comparator) {
		Arrays.sort(elements, 0, size, comparator);
	}
}
