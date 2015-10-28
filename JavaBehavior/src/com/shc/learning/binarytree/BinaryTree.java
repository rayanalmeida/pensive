package com.shc.learning.binarytree;


public class BinaryTree {

	private TreeNode root = null;

	synchronized public boolean insert(TreeNode node) {
		if(null == root) {
			root = node;
			return true;
		}
		setNode(root, node);

		return true;
	}

	private boolean setNode(TreeNode resident, TreeNode guest) {
		if(resident.getValue() > guest.getValue()) {
			TreeNode leftNode = resident.getLeftNode();
			if(null == leftNode) {
				resident.setLeftNode(guest);
				guest.setParent(resident);
				
				return true;
				
			} else {
				setNode(leftNode, guest);
			}
		} else if(resident.getValue() < guest.getValue()){
			TreeNode rightNode = resident.getRightNode();
			if(null == rightNode) {
				resident.setRightNode(guest);
				guest.setParent(resident);
				return true;
			} else {
				setNode(rightNode, guest);
			}
		}
		return false;
	}

	@Override
	public String toString() {
		return "BinaryTree [root=" + root + "]";
	}

	synchronized public boolean delete(TreeNode node) {
		return false;
	}
}
