package sushigame.view;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JLabel;
import javax.swing.JPanel;

import comp401.sushi.IngredientPortion;
import comp401.sushi.Plate;

public class CenterLabel extends JPanel {
	private JLabel rollName; 
	private JLabel ingredients;
	private IngredientPortion[] ingredientArray;

	
	public CenterLabel(Plate plate) {
		
		this.setLayout(new BorderLayout());
		
		rollName = new JLabel("Spot Empty");
		rollName.setOpaque(true);
		rollName.setBackground(Color.GRAY);
		rollName.setForeground(Color.GRAY);
		
		ingredients = new JLabel("Spot Empty");
		ingredients.setOpaque(true);
		ingredients.setBackground(Color.GRAY);
		ingredients.setForeground(Color.GRAY);
		
	
			add(rollName, BorderLayout.WEST);
			add(ingredients, BorderLayout.EAST);
			
		}
	
		public void updateCenter(Plate plate) {
			
			
			
			if (plate == null) { 
				
				ingredientArray = null;
				
				rollName.setText("Empty");
				rollName.setOpaque(true);
				rollName.setForeground(Color.GRAY);
				
				ingredients.setText("Empty");
				ingredients.setForeground(Color.GRAY);
				
				
			} else { 
				
				ingredientArray = plate.getContents().getIngredients();
				
				rollName.setText(plate.getContents().getName());
				rollName.setForeground(Color.WHITE);
				
				setIngredinets(ingredientArray);
				ingredients.setForeground(Color.WHITE);
				
			}
		}

		private void setIngredinets( IngredientPortion[] ingredients) {
			String stringIngredinets = "";
			for (int i = 0; i < ingredients.length; i++) { 
				if (ingredients[i].getAmount() == 0.0) {
					
				}else {
				if (ingredients.length -1 == i) {
					double amount =  ((int) ((ingredients[i].getAmount() * 100.0)+0.5))/100.0;
					stringIngredinets += ingredients[i].getName() + "(" +  amount + ")    ";
				} else {
					double amount =  ((int) ((ingredients[i].getAmount() * 100.0)+0.5))/100.0;
					stringIngredinets += ingredients[i].getName() + "(" + amount + "), ";
				}
			
			}
			}
			
			this.ingredients.setText(stringIngredinets);
		}
	}



