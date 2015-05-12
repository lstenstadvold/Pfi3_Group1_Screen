package se.mah.k3;

import java.util.ArrayList;
import java.util.Random;

import com.firebase.client.ChildEventListener;
import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;
import com.firebase.client.ValueEventListener;

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
		for (final TreasureLocation tl : treasureLocations){
			firebase.child(tl.getId()+"/active").setValue(0);
			
			firebase.child(tl.getId()).addValueEventListener(new ValueEventListener() {
				@Override
				public void onDataChange(DataSnapshot snapshot) {
					//generateTreasureLocations();
					//updateFirebase();
					//updateMap();
					System.out.println(tl.getId()+snapshot.getValue());
				}
				@Override
				public void onCancelled(FirebaseError error) {
					// TODO Auto-generated method stub	
				}
			});
		}
	}
	
	public void generateTreasureLocations(){
		int activeCount = 0;
		for (final TreasureLocation tl : treasureLocations){
			if(tl.getActive()){
				activeCount++;
			}
		}
		System.out.println("NbrOfActiveQR: "+activeCount);
		
		while(activeCount < Constants.MAX_ACTIVE){
			int item = generateRandomTreasureLocation();
			int type = generateRandomTreasureType();

			if(treasureLocations.get(item).getActive()) { //already active
				
			} else { //not active, sets to active and give random type
				treasureLocations.get(item).setActive(true);
				treasureLocations.get(item).setType(type);
				activeCount++;
				System.out.println("New treasure generated: "+treasureLocations.get(item).getId()+" "+treasureLocations.get(item).getType());
			}
		}
	}
	
	
	
	public int generateRandomTreasureLocation(){
		Random rand = new Random();
	    int randomNum = rand.nextInt((treasureLocations.size()));
	    return randomNum;
	}
	
	public int generateRandomTreasureType(){
		Random rand = new Random();
	    int randomNum = rand.nextInt(Constants.NBR_TYPES) + 1;
	    return randomNum;
	}
	
	public void updateFirebase(){
		for (final TreasureLocation tl : treasureLocations){
			if(tl.getActive()){
				firebase.child(tl.getId()+"/active").setValue(tl.getType());
			}
		}
	}
	
	public void updateMap(){
		for (final TreasureLocation tl : treasureLocations){
			if(tl.getActive()){
				int x = tl.getPosX();
				int y = tl.getPosY();
				//hur skriver vi dessa till en punkt på kartan?
			}
		}
	}
	
}
