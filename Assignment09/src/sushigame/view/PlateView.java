package sushigame.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;

import comp401.sushi.Plate;
import sushigame.model.Belt;

public class PlateView extends JPanel {
	private Plate plate; 
	private JLabel northLabel;
	private SouthLabel southLabel;
	private CenterLabel centerLabel;
	private JLabel eastLabel;
	private int position; 
	
	public PlateView(Plate plate, int position) {
		this.plate = plate; 
		this.setLayout(new BorderLayout());
		this.setBorder(BorderFactory.createLineBorder(Color.DARK_GRAY));
		
		
		southLabel = new SouthLabel (plate);
		southLabel.setOpaque(true);
		southLabel.setBackground(Color.GRAY);
		
		
		northLabel = new JLabel("empty");
		northLabel.setOpaque(true);
		northLabel.setBackground(Color.GRAY);
		northLabel.setForeground(Color.GRAY);
		
		
		centerLabel = new CenterLabel(plate);
		centerLabel.setOpaque(true);
		centerLabel.setPreferredSize(new Dimension(300, 20));
		centerLabel.setBackground(Color.GRAY);
		
		eastLabel = new JLabel(position +"");
		eastLabel.setFont(eastLabel.getFont().deriveFont(10.0f));
		eastLabel.setOpaque(true);
		eastLabel.setBackground(Color.GRAY);
		eastLabel.setForeground(Color.WHITE);
	
		
		add(southLabel, BorderLayout.SOUTH);
		add(northLabel, BorderLayout.NORTH);
		add(centerLabel, BorderLayout.CENTER);
		add(eastLabel, BorderLayout.EAST);
		
	}
	
	

	
	public void updatePlateView(Plate plate, Belt belt, int position) {
		southLabel.updateSouth(plate, belt, position);
		centerLabel.updateCenter(plate);
		updateNorthLabel(plate);
		
	}

	
	public void updateNorthLabel(Plate plate) {
		if (plate == null) {
			northLabel.setText("empty");
			northLabel.setForeground(Color.GRAY);
			
		} else { 
			northLabel.setText(plate.getChef().getName());
			northLabel.setForeground(Color.WHITE);
		}
	}
	
	
}
