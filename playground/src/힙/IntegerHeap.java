package 힙;

import java.util.Arrays;

public class IntegerHeap<Integer> {

	private static final int DEFAULT_SIZE = 10;

	private int lastPosition; // 힙이 시작점에서 얼마나 떨어져 있는지 나타냄, 어디까지 요소를 넣었는지 기록
	private final int[] array;

	public IntegerHeap() {
		this.array = new int[DEFAULT_SIZE];
		lastPosition = 0;
	}

	public IntegerHeap(int size) {
		this.array = new int[size];
		lastPosition = 0;
	}

	/**
	 * 마지막 위치에 요소를 추가하고 Trickle Up을 통해 힙 규칙을 만족시킨다.
	 * @param object, 추가할 요소
	 */
	public void add(int object) {
		array[++lastPosition] = object; // 마지막 위치 다음에 요소를 추가
		trickleUp(lastPosition);
	}

	public void swap(int from, int to) {
		int tmp = array[from];
		array[from] = array[to];
		array[to] = tmp;
	}

	/**
	 * root 까지 도달하면 early return
	 * 부모 노드와 비교해 크다면 swap 후 힙 규칙을 만족할 때 까지 Trickle Up
	 * @param position, 요소의 현재 위치
	 */
	public void trickleUp(int position) {
		if (position == 0) {
			return;
		}

		int parent = (int)Math.floor((position - 1) / 2);
		if (array[position] > array[parent]) {
			swap(position, parent);
			trickleUp(parent);
		}
	}

	/**
	 * 힙은 root node 만 제거할 수 있음
	 * 마지막 노드와 루트 노드를 바꾼 후 lastPosition 값을 줄여 배열에 없는 값으로 취급
	 * 최대 힙 규칙을 만족할 때 까지 Trickle Down
	 * @return root node
	 */
	public int remove() {
		int tmp = array[0];
		swap(0, lastPosition--);
		trickleDown(0);
		return tmp;
	}

	@Override
	public String toString() {
		return "Heap{" +
			"array=" + Arrays.toString(array) +
			'}';
	}

	public void trickleDown(int parent) {
		int left = 2 * parent + 1;
		int right = 2 * parent + 2;

		// 마지막 위치가 왼쪽 자식이고, 자식이 부모보다 클 때
		if (left == lastPosition && array[left] > array[parent]) {
			swap(parent, left);
			return;
		}

		// 마지막 위치가 오른쪽 자식이고, 자식이 부모보다 클 때
		if (right == lastPosition && array[right] > array[parent]) {
			swap(parent, right);
			return;
		}

		// 계산한 자식들의 위치가 lastPosition 보다 크거나 같으면 종료 (끝까지 도착함)
		if (left >= lastPosition || right >= lastPosition) {
			return;
		}

		// 왼쪽 자식이 오른쪽 자식보다 더 크고, 왼쪽 자식이 부모보다 클 때
		if (array[left] > array[right] && array[left] > array[parent]) {
			swap(parent, left);
			trickleDown(left);
		} else if ( // 오른쪽 자식이 왼쪽 자식보다 더 크고, 오른쪽 자식이 부모보다 클 때
			array[right] > array[parent]
		) {
			swap(parent, right);
			trickleDown(right);
		}

	}
}

class Main {
	public static void main(String[] args) {
		IntegerHeap<Integer> heap = new IntegerHeap<>(12);

		heap.add(22);
		heap.add(17);
		heap.add(19);
		heap.add(12);
		heap.add(15);
		heap.add(11);
		heap.add(7);
		heap.add(6);
		heap.add(9);
		heap.add(10);
		heap.add(5);

		System.out.println(heap);
		// Heap{array=[22, 19, 17, 7, 12, 15, 11, 0, 6, 9, 10, 5]}
		for (int i = 0; i < 11; i++) {
			heap.remove();
		}

		System.out.println(heap);
		// Heap{array=[0, 6, 5, 7, 9, 10, 11, 12, 15, 17, 19, 22]}
	}
}
