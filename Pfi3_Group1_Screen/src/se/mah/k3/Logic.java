package se.mah.k3;

import java.util.ArrayList;

public class Logic {
	
	public static ArrayList<TreasureLocation> treasureLocations = new ArrayList<TreasureLocation>();
	
	public static FireSupport fireSupport = new FireSupport(Constants.FIREBASE_URL);
	
	public static void main(String[] args){
		addLocations();
		for (TreasureLocation tl : treasureLocations){
			System.out.println(tl.getId());
			System.out.println(tl.getType());
		}
		
		fireSupport.buildBase(treasureLocations);
	}
	
	public static void addLocations(){
		treasureLocations.add(new TreasureLocation("TL101",10,10));
		treasureLocations.add(new TreasureLocation("TL102",20,20));
		treasureLocations.add(new TreasureLocation("TL103",50,50));
		treasureLocations.add(new TreasureLocation("TL104",100,100));
		treasureLocations.add(new TreasureLocation("TL105",300,100));
	}
}
