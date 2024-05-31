package sushigame.view;

import sushigame.model.Chef;

public class HighToLowFoodExpiredComparator implements ChefComparator {
	
	private String indentifier  = "foodExpired";

	@Override
	public int compare(Chef a, Chef b) {
		// We do b - a because we want largest to smallest
		return (int) (Math.round(b.getFoodExpired()*100.0) - 
				Math.round(a.getFoodExpired()*100));
	}		
	
	public String getIdentifier () {
		return indentifier; 
	}
}
