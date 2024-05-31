package sushigame.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;

import comp401.sushi.Plate;
import sushigame.model.Belt;

public class SouthLabel extends JPanel{
	private JLabel colorLabel;
	private JLabel priceLabel;
	private JLabel ageLabel; 
	private Plate plate; 
	
	protected SouthLabel(Plate plate) {
	
			colorLabel = new JLabel("-----");
			colorLabel.setOpaque(true);
			colorLabel.setMinimumSize(new Dimension(150, 20));
			colorLabel.setBackground(Color.GRAY);
			colorLabel.setForeground(Color.GRAY);
			colorLabel.setPreferredSize(new Dimension(150, 20));
			
			
			priceLabel = new JLabel("$0.0");
			priceLabel.setOpaque(true);
			priceLabel.setMinimumSize(new Dimension(150, 20));
			priceLabel.setBackground(Color.GRAY);
			priceLabel.setForeground(Color.GRAY);
			priceLabel.setPreferredSize(new Dimension(150, 20));
			
			ageLabel = new JLabel("0");
			ageLabel.setOpaque(true);
			ageLabel.setBackground(Color.GRAY);
			ageLabel.setForeground(Color.GRAY);
			ageLabel.setPreferredSize(new Dimension(150, 20));
		
		
		this.setLayout(new GridLayout(1,3));
		this.add(colorLabel);
		this.add(priceLabel);
		this.add(ageLabel);
		
	}
	

	public void updateSouth(Plate plate, Belt belt, int position) {
		
		this.plate = plate;
				
		if (plate != null) {
			comp401.sushi.Plate.Color color = plate.getColor();
			double price =  ((int) ((plate.getPrice() * 100.0)+0.5))/100.0;

			
			
			priceLabel.setText("$" + price);
			priceLabel.setForeground(Color.WHITE);
			
			ageLabel.setText("Age: " + belt.getAgeOfPlateAtPosition(position));
			ageLabel.setForeground(Color.WHITE);
		
			switch (color) {
				case RED:
					colorLabel.setText("red");
					colorLabel.setForeground(Color.RED);
					break; 
		
				case BLUE:
					colorLabel.setText("blue");
					colorLabel.setForeground(Color.BLUE);
					break; 
			
				case GREEN:
					colorLabel.setText("green");
					colorLabel.setForeground(Color.GREEN);
					break; 
				
				case GOLD: 
					colorLabel.setText("gold");
					colorLabel.setForeground(Color.YELLOW);
					break; 		
				}
			} else { 
				colorLabel.setText("-----");
				priceLabel.setText("$0.0");
				ageLabel.setText("Age: 0");
				
				colorLabel.setForeground(Color.GRAY);
				ageLabel.setForeground(Color.GRAY);
				priceLabel.setForeground(Color.GRAY);
			}
	}
	
	
	
}
