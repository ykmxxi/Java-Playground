package 트리;

class Node<E> {
	E data; // 저장할 데이터
	Node<E> left; // 왼쪽 자식을 가리키는 포인터
	Node<E> right; // 오른쪽 자식을 가리키는 포인터

	public Node(E obj) {
		this.data = obj;
		left = right = null;
	}
}

public class Tree<E> {
	private Node<E> root;
	private int currentSize;

	public Tree() {
		this.root = null;
		currentSize = 0;
	}

	public Tree(Node<E> root) {
		this.root = root;
		currentSize = 1;
	}

	/**
	 * @param obj, 추가할 데이터
	 * @param node, 비교할 노드(root 부터 시작)
	 */
	@SuppressWarnings("unchecked")
	private void add(E obj, Node<E> node) {
		// 추가할 데이터가 현재 노드의 값보다 크면
		if (((Comparable<E>)obj).compareTo(node.data) > 0) {
			// 오른쪽으로 내려가야 한다.
			if (node.right == null) { // 오른쪽이 비어있으면 추가
				node.right = new Node<>(obj);
				return;
			}

			add(obj, node.right);
		}
		// 추가할 데이터가 현재 노드의 값보다 작거나 같으면
		// 왼쪽으로 내려가야 한다.
		if (node.left == null) {
			node.left = new Node<>(obj);
			return;
		}

		add(obj, node.left);
	}

	/**
	 * @param obj, 추가할 데이터
	 */

	public void add(E obj) {
		if (root == null) {
			root = new Node<>(obj);
		} else {
			add(obj, root);
		}
		currentSize++;
	}

	@SuppressWarnings("unchecked")
	private boolean contains(E obj, Node<E> node) {
		if (node == null) { // 트리 끝에 도달했
			return false;
		}

		if (((Comparable<E>)obj).compareTo(node.data) == 0) {
			return true;
		}

		if (((Comparable<E>)obj).compareTo(node.data) > 0) { // 찾으려는 값이 현재 노드보다 크면
			return contains(obj, node.right); // 오른쪽으로 이동
		} else { // 찾으려는 값이 현재 노드보다 작으면
			return contains(obj, node.left); // 왼쪽으로 이동
		}
	}

	public boolean contains(E obj) {
		return contains(obj, root);
	}

	/**
	 * 주어진 노드를 기준으로 불균형한 트리를 좌측 회전하여 균형을 조정하는 메서드.
	 * @param node 불균형한 트리의 조부모 노드
	 * @return 균형이 조정된 트리의 새로운 루트 노드
	 */
	public Node<E> leftRotate(Node<E> node) {
		// 노드가 null 이거나 오른쪽 자식이 없으면 회전 불가능
		if (node == null || node.right == null) {
			return node;
		}

		Node<E> tmp = node.right; // 부모 노드
		node.right = tmp.left; // 부모 노드의 왼쪽 자식을 현재 노드의 오른쪽 자식으로 연결
		tmp.left = node; // 현재 노드를 부모 노드의 왼쪽 자식으로 연결

		return tmp; // 균형이 조정된 트리의 새로운 루트 노드 반환
	}

	/**
	 * 주어진 노드를 기준으로 불균형한 트리를 우측 회전하여 균형을 조정하는 메서드.
	 * @param node 불균형한 트리의 조부모 노드
	 * @return 균형이 조정된 트리의 새로운 루트 노드
	 */
	public Node<E> rightRotate(Node<E> node) {
		// 노드가 null 이거나 왼쪽 자식이 없으면 회전 불가능
		if (node == null || node.left == null) {
			return node;
		}

		Node<E> tmp = node.left; // 부모 노드
		node.left = tmp.right; // 부모 노드의 오른쪽 자식을 현재 노드의 왼쪽 자식으로 연결
		tmp.right = node; // 현재 노드를 부모 노드의 오른쪽 자식으로 연결

		return tmp; // 균형이 조정된 트리의 새로운 루트 노드 반환
	}

	/**
	 * 주어진 노드를 기준으로 불균형한 트리를 우측-좌측 회전하여 균형을 조정하는 메서드.
	 * @param node 불균형한 트리의 조부모 노드
	 * @return 균형이 조정된 트리의 새로운 루트 노드
	 */
	public Node<E> rightLeftRotate(Node<E> node) {
		// 노드가 null 이거나 오른쪽 자식이 없으면 회전 불가능
		if (node == null || node.right == null) {
			return node;
		}

		node.right = rightRotate(node.right); // 오른쪽 자식을 기준으로 우측 회전
		return leftRotate(node); // 왼쪽 회전 수행
	}

	/**
	 * 주어진 노드를 기준으로 불균형한 트리를 좌측-우측 회전하여 균형을 조정하는 메서드.
	 * @param node 불균형한 트리의 조부모 노드
	 * @return 균형이 조정된 트리의 새로운 루트 노드
	 */
	public Node<E> leftRightRotate(Node<E> node) {
		// 노드가 null 이거나 왼쪽 자식이 없으면 회전 불가능
		if (node == null || node.left == null) {
			return node;
		}

		node.left = leftRotate(node.left); // 왼쪽 자식을 기준으로 좌측 회전
		return rightRotate(node); // 우측 회전 수행
	}

}
