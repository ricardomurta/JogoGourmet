package com.objective.jogogourmet;

public class FoodTree {
	
	private FoodNode root;
	private FoodNode current;
	private FoodNode parent;
	
	public FoodTree() {
		begin();
	}

	public void begin() {
		this.root = new FoodNode("massa", new FoodNode("Lasanha", null, null), new FoodNode("Bolo de Chocolate", null, null));
		this.current = this.root;
	}

	public FoodNode getRoot() {
		return root;
	}

	public FoodNode getCurrent() {
		return current;
	}
	
	public void setCurrent(FoodNode foodNode) {
		this.current = foodNode;
	}

	public FoodNode getParent() {
		return parent;
	}

	public void setParent(FoodNode parent) {
		this.parent = parent;
	}

}
