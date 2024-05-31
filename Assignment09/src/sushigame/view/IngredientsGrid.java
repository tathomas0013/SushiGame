package sushigame.view;

import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;

import comp401.sushi.IngredientPortion;

public class IngredientsGrid extends JPanel {
	private IngredientPortion[] ingredients;

	
	public IngredientsGrid(IngredientPortion[] ingredients) {
		
		this.setLayout(new GridLayout(0,1));
		
		this.ingredients = ingredients; 
		if (ingredients == null) {
		JLabel emptySpot = new JLabel("No ingredients, spot empty.");
		emptySpot.setForeground(Color.GRAY);
		emptySpot.setBackground(Color.GRAY);
		emptySpot.setOpaque(true);
		add(emptySpot);
		} else { 
			for (int i = 0; i < ingredients.length; i++) {
				JLabel name = new JLabel(ingredients[i].getName() + "(" + ingredients[i].getAmount() + ")");
				name.setForeground(Color.WHITE);
				name.setBackground(Color.GRAY);
				name.setOpaque(true);
				add(name);
			}
		}
	}
}
