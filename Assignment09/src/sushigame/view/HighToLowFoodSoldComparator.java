package sushigame.view;

import java.util.Comparator;

import sushigame.model.Chef;

public class HighToLowFoodSoldComparator implements ChefComparator {
	
	private String identifier  = "foodSold";

	@Override
	public int compare(Chef a, Chef b) {
		// We do b - a because we want largest to smallest
		return (int) (Math.round(b.getFoodCustomersConsumed()*100.0) - 
				Math.round(a.getFoodCustomersConsumed()*100));
	}

	@Override
	public String getIdentifier() {
		return identifier;
	}
		
}
