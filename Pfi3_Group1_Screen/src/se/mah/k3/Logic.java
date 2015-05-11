package se.mah.k3;

import java.util.ArrayList;

import com.firebase.client.ChildEventListener;
import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;

public class Logic {
	
	private static final long serialVersionUID = 1L;
	
	ArrayList<TreasureLocation> treasureLocations = new ArrayList<TreasureLocation>();	
	Firebase firebase;
	
	
	public Logic() {
		
		addLocations();		
		for (TreasureLocation tl : treasureLocations){
			System.out.print(tl.getId()+" type: "+tl.getType()+" at: "+tl.getPosX()+" "+tl.getPosY()+"\n");
		}
		
		
		firebase = new Firebase(Constants.FIREBASE_URL);
		firebase.removeValue();
		//firebase.child("Test").setValue("Do you have data?");
		
		
		
		
		//Thread.sleep(3000);
	}
	
	public void addLocations(){
		treasureLocations.add(new TreasureLocation("TL101",10,10));
		treasureLocations.add(new TreasureLocation("TL102",20,20));
		treasureLocations.add(new TreasureLocation("TL103",50,50));
		treasureLocations.add(new TreasureLocation("TL104",100,100));
		treasureLocations.add(new TreasureLocation("TL105",300,100));
	}
}
