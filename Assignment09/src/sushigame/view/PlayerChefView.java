package sushigame.view;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

import comp401.sushi.AvocadoPortion;
import comp401.sushi.BluePlate;
import comp401.sushi.EelPortion;
import comp401.sushi.IngredientPortion;
import comp401.sushi.Nigiri;
import comp401.sushi.Plate;
import comp401.sushi.RedPlate;
import comp401.sushi.Roll;
import comp401.sushi.Sashimi;
import comp401.sushi.SeaweedPortion;
import comp401.sushi.Sushi;

public class PlayerChefView extends JPanel implements ActionListener {

	private List<ChefViewListener> listeners;

	
	JPanel currentDisplay = new JPanel();
	JPanel sashimiUI = new SashimiUI();
	JPanel nigiriUI = new NigiriUI();
	JPanel rollUI = new RollUI();
	JButton addSushi = new JButton("place plate"); 
	JRadioButton sashimi,nigiri,roll; 
	
	public PlayerChefView(int belt_size) {
		listeners = new ArrayList<ChefViewListener>();

		this.setLayout(new BorderLayout());
		
		
		currentDisplay = new JPanel();
		CardLayout currentDisplayLayout = new CardLayout();
		currentDisplay.setLayout(currentDisplayLayout);
		
		sashimi = new JRadioButton("sashimi");
		nigiri = new JRadioButton("nigiri");
		roll = new JRadioButton("roll");
	
		
		ButtonGroup sushiChooser = new ButtonGroup(); 
		sushiChooser.add(sashimi);
		sushiChooser.add(nigiri);
		sushiChooser.add(roll);
		
		JPanel northPane = new JPanel();
		northPane.add(sashimi);
		northPane.add(nigiri);
		northPane.add(roll); 
		northPane.setBorder(BorderFactory.createLineBorder(Color.DARK_GRAY));
		
		JPanel yeet = new JPanel(); 
		yeet.add(currentDisplay, BorderLayout.CENTER);
		
		currentDisplay.add(sashimiUI, "sashimi");
		currentDisplay.add(nigiriUI, "nigiri");
		currentDisplay.add(rollUI, "roll");
		currentDisplayLayout.show(currentDisplay, "sashimi");
		
		
		
		sashimi.addActionListener(new ActionListener(){
					public void actionPerformed (ActionEvent e){
						currentDisplayLayout.show(currentDisplay, "sashimi");
					}
				});
		
		nigiri.addActionListener(new ActionListener(){ 
					public void actionPerformed(ActionEvent e){
						currentDisplayLayout.show(currentDisplay, "nigiri");
					}
				});
		
		roll.addActionListener(new ActionListener(){
			public void actionPerformed (ActionEvent e){
				currentDisplayLayout.show(currentDisplay, "roll");
			}
		});
		
		
		addSushi.addActionListener(new ActionListener() { 
			public void actionPerformed(ActionEvent e) { 
				
				
			
				Sushi newSushi = null; 
				int position = 0; 
				
				//Sashimi
				if (sashimi.isSelected()) { 
					
					position = ((SashimiUI) sashimiUI).getPosition();
					
					//Sushi Type
					try {
						switch(((SashimiUI) sashimiUI).getSashimiType()) {
						case CRAB:
							newSushi = new Sashimi(comp401.sushi.Sashimi.SashimiType.CRAB);
							break;
						case EEL:
							newSushi = new Sashimi(comp401.sushi.Sashimi.SashimiType.EEL);
							break;
						case SALMON:
							newSushi = new Sashimi(comp401.sushi.Sashimi.SashimiType.SALMON);
							break;
						case SHRIMP:
							newSushi = new Sashimi(comp401.sushi.Sashimi.SashimiType.SHRIMP);
							break;
						case TUNA:
							newSushi = new Sashimi(comp401.sushi.Sashimi.SashimiType.TUNA);
							break;
						default:
							break;
						}
					} catch (NullPointerException ex) { 
						JOptionPane.showMessageDialog(null, "please select a sushi type");
					}
					
					//Plate Color
					try {
						switch (((SashimiUI) sashimiUI).getPlateColor()) {
						case BLUE:
							makeBluePlateRequest(newSushi, position);
							break;
						case GOLD:
							double goldPrice = ((SashimiUI) sashimiUI).getGoldPrice();
							makeGoldPlateRequest(newSushi, position, goldPrice);
							break;
						case GREEN:
							makeGreenPlateRequest(newSushi, position);
							break;
						case RED:
							makeRedPlateRequest(newSushi, position);
							break;
						}
					} catch (NullPointerException exc){
						JOptionPane.showMessageDialog(null, "please select a plate color");
					}
					
					//Nigiri
				} else if(nigiri.isSelected()) {
					
					position = ((NigiriUI) nigiriUI).getPosition();
					
					//Sushi Type
					try {
						switch(((NigiriUI) nigiriUI).getNigiriType()) {
						case CRAB:
							newSushi = new Nigiri(comp401.sushi.Nigiri.NigiriType.CRAB);
							break;
						case EEL:
							newSushi = new Nigiri(comp401.sushi.Nigiri.NigiriType.EEL);
							break;
						case SALMON:
							newSushi = new Nigiri(comp401.sushi.Nigiri.NigiriType.SALMON);
							break;
						case SHRIMP:
							newSushi = new Nigiri(comp401.sushi.Nigiri.NigiriType.SHRIMP);
							break;
						case TUNA:
							newSushi = new Nigiri(comp401.sushi.Nigiri.NigiriType.TUNA);
							break;
						default:
							newSushi = new Nigiri(comp401.sushi.Nigiri.NigiriType.CRAB);
							break;
						}
					}catch (NullPointerException heck) {
						JOptionPane.showMessageDialog(null, "please select a sushi type");
					}
					
					//Plate color
					try {
						switch (((NigiriUI) nigiriUI).getPlateColor()) {
						case BLUE:
							makeBluePlateRequest(newSushi, position);
							break;
						case GOLD:
							double goldPrice = ((NigiriUI) nigiriUI).getGoldPrice();
							makeGoldPlateRequest(newSushi, position, goldPrice);
							break;
						case GREEN:
							makeGreenPlateRequest(newSushi, position);
							break;
						case RED:
							makeRedPlateRequest(newSushi, position);
							break;
						}
					} catch (NullPointerException thicc) { 
						JOptionPane.showMessageDialog(null, "please select a sushi type");
					}
					
					//Roll
				} else if (roll.isSelected()) { 
					
				
					RollUI roll = (RollUI) rollUI;
					newSushi = new Roll(roll.getName(), roll.getIngredinets());
					position = roll.getPosition();
					
					
					try {
					switch (roll.getPlateColor()) {
					case BLUE:
						makeBluePlateRequest(newSushi, position);
						break;
					case GOLD:
						double goldPrice = roll.getGoldPrice();
						makeGoldPlateRequest(newSushi, position, goldPrice);
						break;
					case GREEN:
						makeGreenPlateRequest(newSushi, position);
						break;
					case RED:
						makeRedPlateRequest(newSushi, position);
						break;
					}
					}catch (NullPointerException excp) { 
						JOptionPane.showMessageDialog(null, "please select a plate type");
					}
					
				} else { 
					JOptionPane.showMessageDialog(null, "select a sushi type.");
				}
			}
		}); 
		
		
		add(yeet, BorderLayout.CENTER);
		add(addSushi, BorderLayout.SOUTH);
		add(northPane, BorderLayout.NORTH);
		
		
	}

	
	

	public void registerChefListener(ChefViewListener cl) {
		listeners.add(cl);
	}

	private void makeRedPlateRequest(Sushi plate_sushi, int plate_position) {
		for (ChefViewListener l : listeners) {
			l.handleRedPlateRequest(plate_sushi, plate_position);
		}
	}

	private void makeGreenPlateRequest(Sushi plate_sushi, int plate_position) {
		for (ChefViewListener l : listeners) {
			l.handleGreenPlateRequest(plate_sushi, plate_position);
		}
	}

	private void makeBluePlateRequest(Sushi plate_sushi, int plate_position) {
		for (ChefViewListener l : listeners) {
			l.handleBluePlateRequest(plate_sushi, plate_position);
		}
	}
	
	private void makeGoldPlateRequest(Sushi plate_sushi, int plate_position, double price) {
		for (ChefViewListener l : listeners) {
			l.handleGoldPlateRequest(plate_sushi, plate_position, price);
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
	
		}
	}

