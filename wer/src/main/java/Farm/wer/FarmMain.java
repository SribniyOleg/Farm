package Farm.wer;


import java.util.Scanner;

import com.alibaba.fastjson.JSON;


public class FarmMain {

	public static void main(String[] args) throws InterruptedException {

		Scanner n = new Scanner(System.in);
		System.out.println("Введите свое имя!");
		String s = n.nextLine();
		Farm f = new Farm(s);
		
	}
}
