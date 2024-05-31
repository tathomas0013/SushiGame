package sushigame.view;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;
import java.util.Comparator;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import sushigame.model.Belt;
import sushigame.model.BeltEvent;
import sushigame.model.BeltObserver;
import sushigame.model.Chef;
import sushigame.model.SushiGameModel;

public class ScoreboardWidget extends JPanel implements BeltObserver {

	private SushiGameModel game_model;
	private JLabel balanceDisplay;
	private JLabel foodSoldDisplay; 
	private JLabel foodExpiredDisplay; 
	
	private JPanel container = new JPanel(); 
	private JPanel balanceOrder = new JPanel(); 
	private JPanel foodSoldOrder = new JPanel();
	private JPanel foodExpiredOrder = new JPanel(); 
	private CardLayout containerLayout = new CardLayout();
	
	private JButton balanceButton = new JButton("balance");
	private JButton foodSoldButton = new JButton("food sold");
	private JButton foodExpiredButton = new JButton("food expired");
	
	private HighToLowBalanceComparator balanceComparator = new HighToLowBalanceComparator();
	private HighToLowFoodSoldComparator foodSoldComparator = new HighToLowFoodSoldComparator();
	private HighToLowFoodExpiredComparator foodExpiredComparator = new HighToLowFoodExpiredComparator();
	
	public ScoreboardWidget(SushiGameModel gm) {
		game_model = gm;
		game_model.getBelt().registerBeltObserver(this);
		
		balanceDisplay = new JLabel();
		balanceDisplay.setVerticalAlignment(SwingConstants.TOP);
		setLayout(new BorderLayout());
		balanceOrder.add(balanceDisplay);
		balanceDisplay.setText(makeScoreboardHTML(balanceComparator));
		
		foodSoldDisplay = new JLabel();
		foodSoldDisplay.setVerticalAlignment(SwingConstants.TOP);
		foodSoldOrder.add(foodSoldDisplay);
		foodSoldDisplay.setText(makeScoreboardHTML(foodSoldComparator));
		
		foodExpiredDisplay = new JLabel();
		foodExpiredDisplay.setVerticalAlignment(SwingConstants.TOP);
		foodExpiredOrder.add(foodExpiredDisplay);
		foodExpiredDisplay.setText(makeScoreboardHTML(foodExpiredComparator));
		
		JPanel buttons = new JPanel(); 
		buttons.add(balanceButton);
		buttons.add(foodSoldButton);
		buttons.add(foodExpiredButton);
		
		 JLabel title = new JLabel("scoreboard", SwingConstants.CENTER);
		 title.setFont(title.getFont().deriveFont(25.0f));
		 title.setBorder(BorderFactory.createLineBorder(Color.DARK_GRAY));
		
		
		container.setLayout(containerLayout);
		container.add(balanceOrder, "balance");
		container.add(foodSoldOrder, "foodSold");
		container.add(foodExpiredOrder, "foodExpired");
		
		balanceButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				containerLayout.show(container, "balance");
			}
		});
		
		foodSoldButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				containerLayout.show(container, "foodSold");
			}
		});
		
		foodExpiredButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				containerLayout.show(container, "foodExpired");
			}
		});
		
		
		add(buttons,BorderLayout.SOUTH);
		add(title, BorderLayout.NORTH);
		add(container,BorderLayout.CENTER);
		
	}

	private String makeScoreboardHTML(ChefComparator comparator) {
		String sb_html = "<html>";
		sb_html += "<h1> </h1>";

		// Create an array of all chefs and sort by balance.
		Chef[] opponent_chefs= game_model.getOpponentChefs();
		Chef[] chefs = new Chef[opponent_chefs.length+1];
		chefs[0] = game_model.getPlayerChef();
		for (int i=1; i<chefs.length; i++) {
			chefs[i] = opponent_chefs[i-1];
		}
		Arrays.sort(chefs, comparator);
		
		if (comparator.getIdentifier().equals("balance")) {
			for (Chef c : chefs) {
				sb_html += c.getName() + " ($" + Math.round(c.getBalance()*100.0)/100.0 + ") <br>";
			}
			
		} else if (comparator.getIdentifier().equals("foodSold")) {
			for (Chef c : chefs) {
				sb_html += c.getName() + " (" + Math.round(c.getFoodCustomersConsumed()*100.0)/100.0 + " oz.) <br>";
			}
		} else if (comparator.getIdentifier().equals("foodExpired")) {
			for (Chef c : chefs) {
				sb_html += c.getName() + " (" + Math.round(c.getFoodExpired()*100.0)/100.0 + " oz.) <br>";
			}
		}
		
			return sb_html;
	}
		
		

	public void refresh() {
		balanceDisplay.setText(makeScoreboardHTML(balanceComparator));	
		foodSoldDisplay.setText(makeScoreboardHTML(foodSoldComparator));
		foodExpiredDisplay.setText(makeScoreboardHTML(foodExpiredComparator));
	}
	
	@Override
	public void handleBeltEvent(BeltEvent e) {
		if (e.getType() == BeltEvent.EventType.ROTATE) {
			refresh();
		}		
	}

}
