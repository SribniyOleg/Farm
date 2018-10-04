package Farm.wer;

public class Player {

	private static int userID = 0;
	private String userName;
	private int cash = 1000;
	
	Player(String nickName){
		this.userName = nickName;
		userID++;	
	}
	
	public int getCash() {
		return cash;
	}
	
	public String getUserName() {
		return userName;
	}
	
	public int getID() {
		return userID;
	}
	
	public void buyPlant(Plant p) {
		cash =cash - p.getPlantPrice();
	}
	
	public void sellHarvest(Plant p) {
		cash +=p.getHarvestPrice();
	}
	
	
	
}
