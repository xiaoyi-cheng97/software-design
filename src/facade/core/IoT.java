package facade.core;

import java.util.Scanner;

import i18n.I18N;
import i18n.Messages;

import static i18n.Messages.*;

public class IoT {
	
	
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		boolean terminou = false;
		while (!terminou) {
			System.out.println(I18N.getString(Messages.QUIT_OPT));
			String s = getUserInput(sc);
		
			if (s.equals("9")) {
				terminou = true;
			}
		}
	}
	
	
	public static String getUserInput(Scanner sc) {
		return sc.nextLine();
	}
	
	
	
}
