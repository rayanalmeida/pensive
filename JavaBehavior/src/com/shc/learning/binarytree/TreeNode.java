package com.shc.learning.binarytree;

public class TreeNode {

	private int value;
	private TreeNode leftNode;
	private TreeNode rightNode;
	private TreeNode parent;

	public TreeNode(int value, TreeNode leftNode, TreeNode rightNode,
			TreeNode parent) {
		super();
		this.value = value;
		this.leftNode = leftNode;
		this.rightNode = rightNode;
		this.parent = parent;
	}
	
	public TreeNode(int value) {
		this.value = value;
	}
	
	public int getValue() {
		return value;
	}
	public void setValue(int value) {
		this.value = value;
	}
	@Override
	public String toString() {
		return "\nTreeNode [value=" + value + ", leftNode=\t" + leftNode
				+ ", rightNode=\t" + rightNode + ", parent=" + (null != parent ? parent.getValue() : "-") + "]";
	}

	public TreeNode getLeftNode() {
		return leftNode;
	}
	public void setLeftNode(TreeNode leftNode) {
		this.leftNode = leftNode;
	}
	public TreeNode getRightNode() {
		return rightNode;
	}
	public void setRightNode(TreeNode rightNode) {
		this.rightNode = rightNode;
	}
	public TreeNode getParent() {
		return parent;
	}
	public void setParent(TreeNode parent) {
		this.parent = parent;
	}	

}
