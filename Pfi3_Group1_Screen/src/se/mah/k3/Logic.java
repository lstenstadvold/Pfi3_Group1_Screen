package se.mah.k3;

import java.util.ArrayList;

import com.firebase.client.ChildEventListener;
import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;

public class Logic {
	
	private static final long serialVersionUID = 1L;
	
	private ArrayList<TreasureLocation> treasureLocations = new ArrayList<TreasureLocation>();	
	private Firebase firebase;
	
	
	public Logic() {
		
		setupTreasureLocations();
		setupFirebase();
			
	}
	
	//Add all treasure locations to the treasureLocations array. If we want more treasure locations we add them here
	public void setupTreasureLocations(){
		
		//Every added new TreasureLocation is initialized with id, x position and y position
		treasureLocations.add(new TreasureLocation("TL01",10,10));
		treasureLocations.add(new TreasureLocation("TL02",20,20));
		treasureLocations.add(new TreasureLocation("TL03",50,50));
		treasureLocations.add(new TreasureLocation("TL04",100,100));
		treasureLocations.add(new TreasureLocation("TL05",300,100));
	}
	
	//Create a referens to firebase and sets all default values. Run in the start of a program.
	public void setupFirebase(){			
		
		firebase = new Firebase(Constants.FIREBASE_URL); //Instantiating the firebase referens with our firebase url
		firebase.removeValue(); //Empties the whole firebase app
		firebase.child("LightCue").setValue(0);//Create the LightCue child	
		
		//Create one child for each member of the treasureLocations array and sets the child active to 0
		for (TreasureLocation tl : treasureLocations){
			firebase.child(tl.getId()+"/active").setValue(0);
		}
	}
	
}
