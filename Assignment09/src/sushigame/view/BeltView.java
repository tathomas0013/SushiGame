package sushigame.view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;

import comp401.sushi.Plate;
import sushigame.model.Belt;
import sushigame.model.BeltEvent;
import sushigame.model.BeltObserver;

public class BeltView extends JPanel implements BeltObserver {

	private Belt belt;
	private PlateView[] plates;

	public BeltView(Belt b) {
		this.belt = b;
		belt.registerBeltObserver(this);
		setLayout(new GridLayout(belt.getSize(), 1));
		plates = new PlateView[belt.getSize()];
		for (int i = 0; i < belt.getSize(); i++) {
			PlateView view = new PlateView (belt.getPlateAtPosition(i), i);
			view.setMinimumSize(new Dimension(300, 20));
			view.setPreferredSize(new Dimension(300, 20));
			view.setOpaque(true);
			add(view);
			plates[i] = view;  
		}
		
		refresh();
	}

	@Override
	public void handleBeltEvent(BeltEvent e) {	
		refresh();
	}

	private void refresh() {
		for (int i=0; i<belt.getSize(); i++) {
			Plate plate = belt.getPlateAtPosition(i);
			PlateView view = plates[i];
			
			view.updatePlateView(plate, belt, i);
			
			
		

//			if (p == null) {
//				plabel.setText("");
//				plabel.setBackground(Color.GRAY);
//			} else {
//				plabel.setText(p.toString());
//				switch (p.getColor()) {
//				case RED:
//					plabel.setBackground(Color.RED); break;
//				case GREEN:
//					plabel.setBackground(Color.GREEN); break;
//				case BLUE:
//					plabel.setBackground(Color.BLUE); break;
//				case GOLD:
//					plabel.setBackground(Color.YELLOW); break;
//				}
				
			}
		}
	}

