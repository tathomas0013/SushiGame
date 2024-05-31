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
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import comp401.sushi.CrabPortion;
import comp401.sushi.EelPortion;
import comp401.sushi.IngredientPortion;
import comp401.sushi.RicePortion;
import comp401.sushi.SalmonPortion;
import comp401.sushi.SeaweedPortion;
import comp401.sushi.ShrimpPortion;
import comp401.sushi.Sushi;
import comp401.sushi.TunaPortion;

public class RollUI extends JPanel{
	

	public enum PlateColor {RED,GREEN,BLUE,GOLD};
	
	private JLabel sashimi; 
	
	private JRadioButton red,green,blue,gold; //plateChooser 
                        
	private JSlider goldPlateSlider = new JSlider(500, 1000, 500);
	private JSlider riceSlider = new JSlider(0, 150, 0);
	private JSlider seaweedSlider = new JSlider(0, 150, 0);
	private JSlider crabSlider = new JSlider(0, 150, 0);
	private JSlider eelSlider = new JSlider(0, 150, 0);
	private JSlider salmonSlider = new JSlider(0, 150, 0);
	private JSlider shrimpSlider = new JSlider(0, 150, 0);
	private JSlider tunaSlider = new JSlider(0, 150, 0);
	
	private JTextField rollName = new JTextField("enter name here");
	 
	private Sushi sushi; 
	private String[] positions = {"0","1", "2", "3", "4", "5", "6","7", "8", "9", "10","11","12", "13", "14"}; 
	private JComboBox positionsList = new JComboBox(positions);
	
	private PlateColor plateColor;
	private int position; 
	private double goldPrice = 5.0; 
	private String sushiRollName = "";
	private double ricePortion = 0.0;
	private double seaweedPortion =0.0;
	private double crabPortion = 0.0;
	private double eelPortion = 0.0;
	private double salmonPortion = 0.0;
	private double shrimpPortion = 0.0;
	private double tunaPortion = 0.0;
	

	public PlateColor getPlateColor() { 
		return plateColor; 
	}
	
	public int getPosition() { 
		return position; 
	}
	
	public double getGoldPrice() {
		return goldPrice;
	}
	
	public String getName() { 
		return rollName.getText();
	}
	
	public IngredientPortion[] getIngredinets() {
		
		IngredientPortion rice = new RicePortion(ricePortion);
		IngredientPortion seaweed = new SeaweedPortion(seaweedPortion);
		IngredientPortion crab = new CrabPortion(crabPortion);
		IngredientPortion eel = new EelPortion(eelPortion);
		IngredientPortion salmon = new SalmonPortion(salmonPortion);
		IngredientPortion shrimp = new ShrimpPortion(shrimpPortion);
		IngredientPortion tuna = new TunaPortion(tunaPortion);
		
		
		IngredientPortion[] ingredients = {rice, seaweed, crab, eel, salmon, shrimp, tuna};
		
	
		
		
		return ingredients;  
		
		
	}
	
	
	


	
	protected RollUI() {
		
		this.setLayout(new BorderLayout());
		
		sashimi = new JLabel ("roll", SwingConstants.CENTER);
		sashimi.setFont(sashimi.getFont().deriveFont(25.0f));
		
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
		
		
		JPanel riceSliderPane = new JPanel();
		riceSliderPane.setLayout(new BorderLayout());
		riceSliderPane.add(new JLabel("0.0 oz."), BorderLayout.WEST);
		riceSliderPane.add(new JLabel("1.5 oz."), BorderLayout.EAST);
		JLabel riceNameLabel = new JLabel("rice", SwingConstants.CENTER);
		riceNameLabel.setBorder(BorderFactory.createLineBorder(Color.DARK_GRAY));
		riceSliderPane.add(riceNameLabel, BorderLayout.NORTH);
		JLabel riceLabel = new JLabel("0.0 oz.", SwingConstants.CENTER);
		riceSliderPane.add(riceLabel, BorderLayout.SOUTH);
		riceSlider.addChangeListener(new ChangeListener(){ 
			public void stateChanged( ChangeEvent e) {
				double changeToDouble =(double) riceSlider.getValue() /100;
				riceLabel.setText((changeToDouble +" oz." ));
				ricePortion = changeToDouble;
			}
		});
		riceSliderPane.add(riceSlider, BorderLayout.CENTER);
		
		JPanel seaweedSliderPane = new JPanel();
		seaweedSliderPane.setLayout(new BorderLayout());
		seaweedSliderPane.add(new JLabel("0.0 oz."), BorderLayout.WEST);
		seaweedSliderPane.add(new JLabel("1.5 oz."), BorderLayout.EAST);
		JLabel seaweedNameLabel = new JLabel("seaweed", SwingConstants.CENTER);
		seaweedNameLabel.setBorder(BorderFactory.createLineBorder(Color.DARK_GRAY));
		seaweedSliderPane.add(seaweedNameLabel, BorderLayout.NORTH);
		JLabel seaweedLabel = new JLabel("0.0 oz.", SwingConstants.CENTER);
		seaweedSliderPane.add(seaweedLabel, BorderLayout.SOUTH);
		seaweedSlider.addChangeListener(new ChangeListener(){ 
			public void stateChanged( ChangeEvent e) {
				double changeToDouble =(double) seaweedSlider.getValue() /100;
				seaweedLabel.setText((changeToDouble +" oz." ));
				seaweedPortion = changeToDouble;
			}
		});
		seaweedSliderPane.add(seaweedSlider, BorderLayout.CENTER);
		
		JPanel crabSliderPane = new JPanel();
		crabSliderPane.setLayout(new BorderLayout());
		crabSliderPane.add(new JLabel("0.0 oz."), BorderLayout.WEST);
		crabSliderPane.add(new JLabel("1.5 oz."), BorderLayout.EAST);
		JLabel crabNameLabel = new JLabel("crab", SwingConstants.CENTER);
		crabNameLabel.setBorder(BorderFactory.createLineBorder(Color.DARK_GRAY));
		crabSliderPane.add(crabNameLabel, BorderLayout.NORTH);
		JLabel crabLabel = new JLabel("0.0 oz.", SwingConstants.CENTER);
		crabSliderPane.add(crabLabel, BorderLayout.SOUTH);
		crabSlider.addChangeListener(new ChangeListener(){ 
			public void stateChanged( ChangeEvent e) {
				double changeToDouble =(double) crabSlider.getValue() /100;
				crabLabel.setText((changeToDouble +" oz." ));
				crabPortion = changeToDouble;
			}
		});
		crabSliderPane.add(crabSlider, BorderLayout.CENTER);
		
		JPanel eelSliderPane = new JPanel();
		eelSliderPane.setLayout(new BorderLayout());
		eelSliderPane.add(new JLabel("0.0 oz."), BorderLayout.WEST);
		eelSliderPane.add(new JLabel("1.5 oz."), BorderLayout.EAST);
		JLabel eelNameLabel = new JLabel("eel", SwingConstants.CENTER);
		eelNameLabel.setBorder(BorderFactory.createLineBorder(Color.DARK_GRAY));
		eelSliderPane.add(eelNameLabel, BorderLayout.NORTH);
		JLabel eelLabel = new JLabel("0.0 oz.", SwingConstants.CENTER);
		eelSliderPane.add(eelLabel, BorderLayout.SOUTH);
		eelSlider.addChangeListener(new ChangeListener(){ 
			public void stateChanged( ChangeEvent e) {
				double changeToDouble =(double) eelSlider.getValue() /100;
				eelLabel.setText((changeToDouble +" oz." ));
				eelPortion = changeToDouble;
			}
		});
		eelSliderPane.add(eelSlider, BorderLayout.CENTER);
		
		JPanel salmonSliderPane = new JPanel();
		salmonSliderPane.setLayout(new BorderLayout());
		salmonSliderPane.add(new JLabel("0.0 oz."), BorderLayout.WEST);
		salmonSliderPane.add(new JLabel("1.5 oz."), BorderLayout.EAST);
		JLabel salmonNameLabel = new JLabel("salmon", SwingConstants.CENTER);
		salmonNameLabel.setBorder(BorderFactory.createLineBorder(Color.DARK_GRAY));
		salmonSliderPane.add(salmonNameLabel, BorderLayout.NORTH);
		JLabel salmonLabel = new JLabel("0.0 oz.", SwingConstants.CENTER);
		salmonSliderPane.add(salmonLabel, BorderLayout.SOUTH);
		salmonSlider.addChangeListener(new ChangeListener(){ 
			public void stateChanged( ChangeEvent e) {
				double changeToDouble =(double) salmonSlider.getValue() /100;
				salmonLabel.setText((changeToDouble +" oz." ));
				salmonPortion = changeToDouble;
			}
		});
		salmonSliderPane.add(salmonSlider, BorderLayout.CENTER);
		
		JPanel shrimpSliderPane = new JPanel();
		shrimpSliderPane.setLayout(new BorderLayout());
		shrimpSliderPane.add(new JLabel("0.0 oz."), BorderLayout.WEST);
		shrimpSliderPane.add(new JLabel("1.5 oz."), BorderLayout.EAST);
		JLabel shrimpNameLabel = new JLabel("shrimp", SwingConstants.CENTER);
		shrimpNameLabel.setBorder(BorderFactory.createLineBorder(Color.DARK_GRAY));
		shrimpSliderPane.add(shrimpNameLabel, BorderLayout.NORTH);
		JLabel shrimpLabel = new JLabel("0.0 oz.", SwingConstants.CENTER);
		shrimpSliderPane.add(shrimpLabel, BorderLayout.SOUTH);
		shrimpSlider.addChangeListener(new ChangeListener(){ 
			public void stateChanged( ChangeEvent e) {
				double changeToDouble =(double) shrimpSlider.getValue() /100;
				shrimpLabel.setText((changeToDouble +" oz." ));
				shrimpPortion = changeToDouble;
			}
		});
		shrimpSliderPane.add(shrimpSlider, BorderLayout.CENTER);
		
		JPanel tunaSliderPane = new JPanel();
		tunaSliderPane.setLayout(new BorderLayout());
		tunaSliderPane.add(new JLabel("0.0 oz."), BorderLayout.WEST);
		tunaSliderPane.add(new JLabel("1.5 oz."), BorderLayout.EAST);
		JLabel tunaNameLabel = new JLabel("tuna", SwingConstants.CENTER);
		tunaNameLabel.setBorder(BorderFactory.createLineBorder(Color.DARK_GRAY));
		tunaSliderPane.add(tunaNameLabel, BorderLayout.NORTH);
		JLabel tunaLabel = new JLabel("0.0 oz.", SwingConstants.CENTER);
		tunaSliderPane.add(tunaLabel, BorderLayout.SOUTH);
		tunaSlider.addChangeListener(new ChangeListener(){ 
			public void stateChanged( ChangeEvent e) {
				double changeToDouble =(double) tunaSlider.getValue() /100;
				tunaLabel.setText((changeToDouble +" oz." ));
				tunaPortion = changeToDouble;
			}
		});
		tunaSliderPane.add(tunaSlider, BorderLayout.CENTER);
		
		
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
		
	
	
		JPanel positionPane = new JPanel();
		positionPane.setLayout(new BorderLayout());
		positionPane.add(new JLabel("set plate at:"), BorderLayout.NORTH);
		positionPane.add(positionsList, BorderLayout.CENTER);
		
	
		JPanel centerPane = new JPanel(); 
		centerPane.setLayout(new GridLayout(10,1));
		centerPane.add(rollName);
		centerPane.add(plateFrameContainer);
		centerPane.add(riceSliderPane);
		centerPane.add(seaweedSliderPane);
		centerPane.add(crabSliderPane);
		centerPane.add(eelSliderPane);
		centerPane.add(salmonSliderPane);
		centerPane.add(shrimpSliderPane);
		centerPane.add(tunaSliderPane);
		centerPane.add(positionPane);
		
		
		JPanel formatCenter = new JPanel(); 
		formatCenter.setLayout(new BorderLayout());
		
		formatCenter.add(centerPane, BorderLayout.CENTER);
		
	
		
		
	
		add(formatCenter, BorderLayout.CENTER);
		add(sashimi, BorderLayout.NORTH);
		
		
	}

	

	
	



}
