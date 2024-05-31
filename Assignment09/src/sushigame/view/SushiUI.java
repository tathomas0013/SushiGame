package sushigame.view;

import javax.swing.JPanel;

public class SushiUI extends JPanel {
	
	public enum SushiType {SASHIMI, NIGIRI, ROLL};
	private SushiType type;
		
	protected SushiUI (SushiType type) { 
		this.type = type;
	}
	
	public SushiType getSushiType() { 
		return type; 
	}
	
}
