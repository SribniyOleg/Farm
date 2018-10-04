package Farm.wer;

import java.util.Scanner;

public class Farm {

	private Ground[] ground = new Ground[8];
	private Player p;
	private Plant plant = new Plant();
	private int userID;
	private Scanner in = new Scanner(System.in);

	Farm(String userName) {
		p = new Player(userName);
		userID = p.getID();
		for(int i=0;i<ground.length;i++) {
			ground[i] = new Ground();
			ground[i].setID(p.getID());
		}
	}

	
	
	public void groundInfo() {
		for (int i = 0; i < ground.length; i++) {
			System.out.println("Грядка " + (i+1)+" " + ground[i].getInfo());
		}
	}

	public void plantVeg(String path, int selectedGround) {
		plant = plant.getPlant(path);
		ground[selectedGround].setPlant(plant);
		p.buyPlant(plant);
		ground[selectedGround].implant();
	}

	public void harvest(int n) {
		if (ground[n].isReady()) {
			p.sellHarvest(ground[n].getPlant());
		}
	}

	public void start() {
		System.out.println("Приветствую " + p.getUserName() + "\n Ваш баланс: " + p.getCash());
		System.out.println("1. Посмотреть поле ");
		System.out.println("2. Посадить саженец");
		System.out.println("3. Собрать урожай");
		int s = in.nextInt();
		int f;
		switch (s) {
		case 1:
			groundInfo();
			System.out.println("нажмите 1 для выхода в меню ");
			f = in.nextInt();
			if(f == 1)
			start();
		case 2:
			String pl;
			System.out.println("Выберете овощь для посадки");
			System.out.println("1.Картошка , 2.Лук , 3.Огурец ");
			int c = in.nextInt();
			if(c==1) {
				pl = "src\\data\\Potato.json";
			}else if(c==2) {
				pl = "src\\data\\Onion.json";
			}else {
				pl = "src\\data\\Cucmber.json";
			}
			System.out.println("Выберете номер грядки ");
			int q = in.nextInt();
			if(ground[q].isEmpty()) {
				plantVeg(pl,q);
				System.out.println("Сажанец успешно посажен!  ");
				start();
			}else {
				System.out.println("Грядка занята!");
				start();
			}
			
		case 3:
			System.out.println("Выберете номерг грядки!");
			f = in.nextInt();
			if(ground[f].isReady()) {
				harvest(f);
			}else {
				System.out.println("Грядка пустая !");
			}
			
		}

	}

}
