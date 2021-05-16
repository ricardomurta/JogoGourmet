package com.objective.jogogourmet;

import javax.swing.JOptionPane;

public class Menu {

	FoodTree foodTree = new FoodTree();
	Boolean active = true;

	Menu() {
		start();
	}
	
	private void start() {
		
		Integer i = initialize();
		
		if(i == JOptionPane.CLOSED_OPTION)
			this.active = false;
		
		this.foodTree.setCurrent(foodTree.getRoot());
		
		if (i == 0)
			while (active == true) {
				ask(foodTree);
			}
		
	}
	
	private Integer initialize() {
		
		Object[] option = { "Ok" };
		return JOptionPane.showOptionDialog(null, "Pense em um prato...", "Jogo Gourmet - Ricardo Murta",
				JOptionPane.PLAIN_MESSAGE, JOptionPane.QUESTION_MESSAGE, null, option, option[0]);
		
	}

	private void ask(FoodTree foodTree) {
		
		String question = "O prato que você pensou é " + foodTree.getCurrent().getFood() + "?";
		int opt = JOptionPane.showConfirmDialog(null, question, "Confirm", JOptionPane.YES_NO_OPTION);
		
		if(opt == JOptionPane.CLOSED_OPTION) {
			this.active = false;
		}else {
			if (opt == JOptionPane.OK_OPTION) {
				if (foodTree.getCurrent().isLeaf()) {
					foodTree.setCurrent(foodTree.getRoot());
					JOptionPane.showMessageDialog(null, "Acertei de novo!");
				} else {
					foodTree.setParent(foodTree.getCurrent());
					foodTree.setCurrent(foodTree.getCurrent().getYes());
					ask(foodTree);
				}
			} else {
				if (foodTree.getCurrent().getNo() == null) {
					write();
					foodTree.setCurrent(foodTree.getRoot());
					start();
				} else {
					foodTree.setParent(foodTree.getCurrent());
					foodTree.setCurrent(foodTree.getCurrent().getNo());
					ask(foodTree);
				}
			}
		}

	}
	
	private void write() {
        
		String newFood = JOptionPane.showInputDialog("Qual prato você pensou?");
        String newType = JOptionPane.showInputDialog(newFood + " é _________ mas " + this.foodTree.getCurrent().getFood() + " não.");
        
        if(foodTree.getCurrent().isLeaf()) {
        	if(foodTree.getCurrent() == foodTree.getParent().getYes()) {
        		this.foodTree.getParent().addYes(newType);
        		this.foodTree.getParent().getYes().addYes(newFood);
        		this.foodTree.getParent().getYes().addNo(foodTree.getCurrent().getFood());
        	}else {
        		this.foodTree.getParent().addNo(newType);
        		this.foodTree.getParent().getNo().addYes(newFood);
        		this.foodTree.getParent().getNo().addNo(foodTree.getCurrent().getFood());
        	}
        }else {
        	this.foodTree.getCurrent().addNo(newType);
        	this.foodTree.getCurrent().getNo().addYes(newFood);
        }
        
    }

}
