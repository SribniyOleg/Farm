package Farm.wer;

import java.util.Date;

public class Ground {

	private Date moment;
	private Plant p;
	private boolean isImplant , isReady ;
	private int ID;
	
	

	Ground() {

	}

	public void setPlant(Plant p) {
		this.p = p;
		isReady = false;
	}

	public int getID() {
		return ID;
	}
	
	public void setID(int s) {
		s = ID;
	}
	
	public boolean isEmpty() {
			return !isImplant;
	}
	
	public boolean isReady() {
		return isReady;
	}
	
	public String getInfo() {
		if(isImplant) {
			return ("засажена ");
		}else {
			return "пустая";
		}
	}
	
	public Plant getPlant() {
		return p;
	}
	
	public void implant() {
		new Thread(new Runnable() {
			@Override
			public void run() {
				try {
					isImplant = true;
					moment = new Date();
					Thread.sleep(p.getMaturationTime());
					isImplant = false;
					isReady = true;
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}).start();

	}
	

}
