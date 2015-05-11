package se.mah.k3;

import java.util.ArrayList;

import com.firebase.client.Firebase;

public class FireSupport {
	
	private Firebase firebaseRef;
	
	public FireSupport(String firebaseUrl){
		firebaseRef = new Firebase(firebaseUrl);
	}
	
	//Builds our base, remove all values, creates them and set them to default values
	public void buildBase(ArrayList<TreasureLocation> tlArr){
		firebaseRef.removeValue(); //removes every value
		for (TreasureLocation tl : tlArr){
			firebaseRef.child(tl.getId());
			firebaseRef.child(tl.getId()+"/active").setValue(0);
		}	
	}
	
	
}
