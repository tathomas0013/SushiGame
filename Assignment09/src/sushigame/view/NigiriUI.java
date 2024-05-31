package sushigame.view;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JSlider;
import javax.swing.SwingConstants;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import comp401.sushi.Sushi;

public class NigiriUI extends JPanel{
	
	public enum NigiriType {SHRIMP,TUNA, EEL,SALMON,CRAB};
	public enum PlateColor {RED,GREEN,BLUE,GOLD};
	
	private JLabel nigiri; 
	private JRadioButton red,green,blue,gold; //plateChooser 
	private JRadioButton  crab,shrimp,tuna,salmon,eel; //sashimiType                              
	private JSlider goldPlateSlider = new JSlider(500, 1000, 500);
	 
	private Sushi sushi; 
	private String[] positions = {"0","1", "2", "3", "4", "5", "6","7", "8", "9", "10","11","12", "13", "14"}; 
	private JComboBox positionsList = new JComboBox(positions);
	

	private NigiriType nigiriSeafood;
	private PlateColor plateColor;
	private int position; 
	private double goldPrice = 5.0;
	
	
	public NigiriType getNigiriType() { 
		return nigiriSeafood; 
	}
	
	public PlateColor getPlateColor() { 
		return plateColor; 
	}
	
	public int getPosition() { 
		return position; 
	}
	
	public double getGoldPrice() {
		return goldPrice;
	}

	
	
	protected NigiriUI() {
		
		this.setLayout(new BorderLayout());
		
		nigiri = new JLabel ("nigiri", SwingConstants.CENTER);
		nigiri.setFont(nigiri.getFont().deriveFont(25.0f));
		
		positionsList.addActionListener(new ActionListener() { 
			public void actionPerformed(ActionEvent e) {
				position = positionsList.getSelectedIndex();
			}
		});

	
		red = new JRadioButton("red");
		blue = new JRadioButton("blue");
		green = new JRadioButton("green");
		gold = new JRadioButton("gold");
		
		ButtonGroup plateChooser = new ButtonGroup();
		plateChooser.add(red);
		plateChooser.add(blue);
		plateChooser.add(green);
		plateChooser.add(gold);
		
		crab = new JRadioButton("crab");
		shrimp = new JRadioButton("shrimp");
		tuna = new JRadioButton("tuna");
		salmon = new JRadioButton("salmon");
		eel = new JRadioButton("eel");
		
		ButtonGroup sashimiType = new ButtonGroup();
		sashimiType.add(crab);
		sashimiType.add(shrimp);
		sashimiType.add(tuna);
		sashimiType.add(salmon);
		sashimiType.add(eel);
		
		JPanel goldSliderPane = new JPanel();
		goldSliderPane.setLayout(new BorderLayout());
		goldSliderPane.add(new JLabel("set price of gold plate:"), BorderLayout.CENTER);
		goldSliderPane.add(new JLabel("$5.00"), BorderLayout.WEST);
		goldSliderPane.add(new JLabel("$10.00"), BorderLayout.EAST);
		JLabel southDynamicLabel = new JLabel("$5.00", SwingConstants.CENTER);
		goldSliderPane.add(southDynamicLabel, BorderLayout.SOUTH);
		goldPlateSlider.addChangeListener(new ChangeListener(){ 
			public void stateChanged( ChangeEvent e) {
				double changeToDouble =(double) goldPlateSlider.getValue() /100;
				southDynamicLabel.setText(("$" + changeToDouble ));
				goldPrice = changeToDouble;
			}
		});
		goldSliderPane.add(goldPlateSlider, BorderLayout.CENTER);
		
		 JPanel plateColors = new JPanel(); 
		 plateColors.setLayout(new GridLayout(1,4));
		 plateColors.setBorder(BorderFactory.createLineBorder(Color.DARK_GRAY));
		plateColors.add(red);
		plateColors.add(green);
		plateColors.add(blue);
		plateColors.add(gold);
		
		JPanel goldPlateColors = new JPanel();
		goldPlateColors.setLayout(new BorderLayout());
		goldPlateColors.add(goldSliderPane, BorderLayout.SOUTH);
		
		JPanel otherPlateColors = new JPanel();
		 JLabel otherPlateColorsPrice = new JLabel("select plate color");
        otherPlateColors.setLayout(new BorderLayout());
		otherPlateColors.add(otherPlateColorsPrice, BorderLayout.CENTER);
		
		
		JPanel dynamicPlateFrame = new JPanel(); 
		CardLayout plateLayout = new CardLayout();
		dynamicPlateFrame.setLayout(plateLayout);
		dynamicPlateFrame.add(goldPlateColors, "gold");
		dynamicPlateFrame.add(otherPlateColors, "other");
		plateLayout.show(dynamicPlateFrame, "other");
		
		red.addActionListener(new ActionListener() {
			public void actionPerformed (ActionEvent e) {
				plateLayout.show(dynamicPlateFrame, "other");
				otherPlateColorsPrice.setText("$1.00");
				plateColor = PlateColor.RED;
			}
		});
		
		blue.addActionListener(new ActionListener() {
			public void actionPerformed (ActionEvent e) {
				plateLayout.show(dynamicPlateFrame, "other");
				otherPlateColorsPrice.setText("$4.00");
				plateColor = PlateColor.BLUE;
				
			}
		});
		
		green.addActionListener(new ActionListener() {
			public void actionPerformed (ActionEvent e) {
				plateLayout.show(dynamicPlateFrame, "other");
				otherPlateColorsPrice.setText("$2.00");
				plateColor = PlateColor.GREEN;
			}
		});
		
		gold.addActionListener(new ActionListener() {
			public void actionPerformed (ActionEvent e) {
				plateLayout.show(dynamicPlateFrame, "gold");
				plateColor = PlateColor.GOLD;
			}
		});
		
		
		
		JPanel plateFrameContainer =  new JPanel();
		plateFrameContainer.add(plateColors);
		plateFrameContainer.add(dynamicPlateFrame);
		
		JPanel sashimiText = new JPanel(); 
		JLabel text =  new JLabel("select a seafood");
		sashimiText.add(text);
		
		JPanel sashimiMeats = new JPanel(); 
		 sashimiMeats.setBorder(BorderFactory.createLineBorder(Color.DARK_GRAY));
		sashimiMeats.add(crab);
		sashimiMeats.add(eel);
		sashimiMeats.add(salmon);
		sashimiMeats.add(shrimp);
		sashimiMeats.add(tuna);
		
		crab.addActionListener(new ActionListener() {
			public void actionPerformed (ActionEvent e) {
				text.setText("crab");
				nigiriSeafood= NigiriType.CRAB;
			}
		});
		
		eel.addActionListener(new ActionListener() {
			public void actionPerformed (ActionEvent e) {
				text.setText("eel");
				nigiriSeafood= NigiriType.EEL;
			}
		});
		
		salmon.addActionListener(new ActionListener() {
			public void actionPerformed (ActionEvent e) {
				text.setText("salmon");
				nigiriSeafood= NigiriType.SALMON;
			}
		});
		
		shrimp.addActionListener(new ActionListener() {
			public void actionPerformed (ActionEvent e) {
				text.setText("shrimp");
				nigiriSeafood= NigiriType.SHRIMP;
			}
		});
		
		tuna.addActionListener(new ActionListener() {
			public void actionPerformed (ActionEvent e) {
				text.setText("tuna");
				nigiriSeafood=	NigiriType.TUNA;
			}
		});
		
		JPanel sushiTypeContainer = new JPanel(); 
		sushiTypeContainer.add(sashimiMeats);
		sushiTypeContainer.add(sashimiText);
		
		
		JPanel positionPane = new JPanel();
		positionPane.setLayout(new BorderLayout());
		positionPane.add(new JLabel("set plate at:"), BorderLayout.NORTH);
		positionPane.add(positionsList, BorderLayout.CENTER);
		
	
		JPanel centerPane = new JPanel(); 
		centerPane.setLayout(new GridLayout(4,1));
		centerPane.add(plateFrameContainer);
		centerPane.add(sushiTypeContainer);
		centerPane.add(positionPane);
		
		JPanel formatCenter = new JPanel(); 
		formatCenter.setLayout(new BorderLayout());
		formatCenter.add(centerPane);
		
		JPanel formatHalf = new JPanel();
		formatHalf.setLayout(new GridLayout(3,1));
		formatHalf.add(formatCenter);
		
		
	
		add(formatHalf, BorderLayout.CENTER);
		add(nigiri, BorderLayout.NORTH);
		
		
	}

	

	
	



}
