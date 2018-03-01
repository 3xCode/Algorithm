package com.sunyang.btree;

public class Node {
	int position;
	int value;
	Node left;
	Node right;

	public Node(int position, int value) {
		this.position = position;
		this.value = value;
	}
}
