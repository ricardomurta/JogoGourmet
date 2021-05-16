package com.objective.jogogourmet;

public class FoodNode {
	
	private String food;
	private FoodNode yes;
	private FoodNode no;
	
	public FoodNode(String food, FoodNode yes, FoodNode no) {
		super();
		this.food = food;
		this.yes = yes;
		this.no = no;
	}

	public Boolean isLeaf() {
		return (yes == null && no == null) ? true : false;
	}
	
	public void addYes(String food) {
		this.yes = new FoodNode(food, null, null);
	}
	
	public void addNo(String food) {
		this.no = new FoodNode(food, null, null);
	}

	public String getFood() {
		return food;
	}

	public FoodNode getYes() {
		return yes;
	}

	public FoodNode getNo() {
		return no;
	}

}
