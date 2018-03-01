package com.sunyang.btree;

interface AbsTree {
	public Node get(int position);

	public void insert(int position, int value);

	public boolean delete(int position);

	public Node getDirectPostNode(Node delNode);

	public void preTraversal(Node root);

	public void middleTraversal(Node root);

	public void postTraversal(Node root);
}
