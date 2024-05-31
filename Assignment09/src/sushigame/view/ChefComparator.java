package sushigame.view;

import java.util.Comparator;

import sushigame.model.Chef;

public interface  ChefComparator extends Comparator<Chef> {
	
	@Override 
	public abstract int compare (Chef a, Chef b);
	
	public String getIdentifier();

}
