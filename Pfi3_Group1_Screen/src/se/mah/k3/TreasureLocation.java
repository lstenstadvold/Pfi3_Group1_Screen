package se.mah.k3;

public class TreasureLocation {
	private String id;
	private int posX;
	private int posY;
	private boolean active;
	private int type;
	
	public TreasureLocation(String id, int x, int y){	
		this.id = id;
		this.posX = x;
		this.posY = y;
		this.active = false;
		this.type = 0;
	}
	
	public String getId(){
		return this.id;
	}
	
	public boolean getActive(){
		return this.active;
	}
	
	public int getType(){
		return this.type;
	}
	
	public int getPosX(){
		return this.posX;
	}
	
	public int getPosY(){
		return this.posY;
	}
}
