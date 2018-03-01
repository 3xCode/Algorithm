package com.sunyang.btree;

public class BTree {
	
	class Node{
		int position;
		int value;
		Node left;
		Node right;
		
		public Node(int position,int value){
			this.position = position;
			this.value = value;
		}
	}
	
	
	interface AbsTree{
		public Node get(int position);
		public void insert(int position,int value);
		public boolean delete(int position);
		public Node getDelChild(Node delNode);
		public void preTraversal(Node root);
		public void middleTraversal(Node root);
		public void postTraversal(Node root);
	}
	
	
	
	class Tree implements AbsTree{
		Node root;

		public Node get(int position) {
			Node currentNode = root;
			//如果小于position，从左边查找，如果大于position，从右边查找。
			while(currentNode!=null && currentNode.position !=position){
				if(position<currentNode.position){
					currentNode = currentNode.left;
				}else{
					currentNode = currentNode.right;
				}
			}
			return currentNode;
		}

		public void insert(int position, int value) {
			if(root==null){
				root = new Node(position,value);
				return;
			}
			
			Node currentNode = root;
			boolean isLeft = true;
			
			while(currentNode!=null){
				if(position < currentNode.position){
					currentNode = currentNode.left;
					isLeft=true;
				}else{
					currentNode = currentNode.right;
					isLeft = false;
				}
				
				if(isLeft){
					currentNode.left=new Node(position, value);
				}else{
					currentNode.right=new Node(position, value);
				}
			}
			
			
		}

		public boolean delete(int position) {
			//删除叶子节点
			Node currentNode = root;
			Node parentNode = null;
			boolean isLeft = true;
			while(currentNode!=null && currentNode.position != position){
				parentNode = currentNode;
				if(position<currentNode.position){
					currentNode = currentNode.left;
					isLeft = true;
				}else{
					currentNode = currentNode.right;
					isLeft = false;
				}
			}
			
			if(currentNode ==null){
				return false;
			}
			
			//是否为叶子节点
			if(currentNode.left==null && currentNode.right==null){
				if(currentNode == root){
					root =null;
				}
				if(isLeft){
					currentNode.left = null;
				}else{
					currentNode.right = null;
				}
			}
			
			//待删除节点有一个节点
			if(currentNode.right==null){
				if(currentNode == root){
					root = currentNode.left;
				}
				
				if(isLeft){
					parentNode.left = currentNode.left;
				}else{
					parentNode.right=currentNode.right;
				}
			}else if(currentNode.left==null){
				if(currentNode==root){
					root = currentNode.right;
				}
				if(isLeft){
					parentNode.left = currentNode.left;
				}else{
					parentNode.right = currentNode.right;
				}
			}
			
			
			//待删除节点有两个节点
			
			
			return false;
		}

		public Node getDelChild(Node delNode) {
			return null;
		}

		public void preTraversal(Node root) {
			if(root != null){
				System.out.println(root.position+":"+root.value);
			}
			preTraversal(root.left);
			preTraversal(root.right);
		}

		public void middleTraversal(Node root) {
			if(root!=null){
				middleTraversal(root.left);
			}
			System.out.println(root.position+":"+root.value);
			middleTraversal(root.right);
		}

		public void postTraversal(Node root) {
			if(root!=null){
				postTraversal(root.left);
			}
			postTraversal(root.right);
			System.out.println(root.position+":"+root.value);
		}
	}
}
