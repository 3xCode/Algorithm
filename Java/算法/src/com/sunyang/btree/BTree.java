package com.sunyang.btree;

class BTree implements AbsTree {

	Node root;

	public Node get(int position) {
		Node currentNode = root;
		// 如果小于position，从左边查找，如果大于position，从右边查找。
		while (currentNode != null && currentNode.position != position) {
			if (position < currentNode.position) {
				currentNode = currentNode.left;
			} else {
				currentNode = currentNode.right;
			}
		}
		return currentNode;
	}

	public void insert(int position, int value) {
		if (root == null) {
			root = new Node(position, value);
			return;
		}

		Node currentNode = root;
		Node parentNode = root;
		boolean isLeft = true;

		while (currentNode != null) {
			parentNode = currentNode;
			if (position < currentNode.position) {
				currentNode = currentNode.left;
				isLeft = true;
			} else {
				currentNode = currentNode.right;
				isLeft = false;
			}
			
			Node newNode = new Node(position, value);
			if (isLeft) {
				parentNode.left = newNode;
			} else {
				parentNode.right = newNode;
			}
		}

	}

	public boolean delete(int position) {
		// 删除叶子节点
		Node currentNode = root;
		Node parentNode = null;
		boolean isLeft = true;
		while (currentNode != null && currentNode.position != position) {
			parentNode = currentNode;
			if (position < currentNode.position) {
				currentNode = currentNode.left;
				isLeft = true;
			} else {
				currentNode = currentNode.right;
				isLeft = false;
			}
		}

		if (currentNode == null) {
			return false;
		}

		// 是否为叶子节点
		if (currentNode.left == null && currentNode.right == null) {
			if (currentNode == root) {
				root = null;
			}
			if (isLeft) {
				currentNode.left = null;
			} else {
				currentNode.right = null;
			}
		} else if (currentNode.right == null) {
			// 待删除节点有一个节点
			if (currentNode == root) {
				root = currentNode.left;
			}

			if (isLeft) {
				parentNode.left = currentNode.left;
			} else {
				parentNode.right = currentNode.right;
			}
		} else if (currentNode.left == null) {
			if (currentNode == root) {
				root = currentNode.right;
			}
			if (isLeft) {
				parentNode.left = currentNode.left;
			} else {
				parentNode.right = currentNode.right;
			}
		} else {
			// 待删除节点有两个节点
			Node targetNode = getDirectPostNode(currentNode);
			currentNode.position = targetNode.position;
			currentNode.value = targetNode.value;
		}

		return false;
	}

	public Node getDirectPostNode(Node delNode) {
		Node targetParentNode = null;
		Node targetNode = delNode;
		Node currentNode = delNode.right;
		// 先序遍历找到targetNode
		while (currentNode != null) {
			targetParentNode = targetNode;
			targetNode = currentNode;
			currentNode = currentNode.left;
		}
		if (targetNode != delNode.right) {
			if (targetNode.right != null) {
				targetParentNode.left = targetNode.right;
				targetNode.right = null;
			}
		}
		return targetNode;
	}

	public void destory(Node root) {
		if (root == null) {
			return;
		}
		if (root.left != null) {
			destory(root.left);
		}
		if (root.right != null) {
			destory(root.right);
		}
		root = null;
	}

	public void destory() {
		destory(root);
	}

	public void preTraversal(Node root) {
		if (root != null) {
			System.out.println(root.position + ":" + root.value);
		}
		preTraversal(root.left);
		preTraversal(root.right);
	}

	public void middleTraversal(Node root) {
		if (root != null) {
			middleTraversal(root.left);
		}
		System.out.println(root.position + ":" + root.value);
		middleTraversal(root.right);
	}

	public void postTraversal(Node root) {
		if (root != null) {
			postTraversal(root.left);
		}
		postTraversal(root.right);
		System.out.println(root.position + ":" + root.value);
	}
}
