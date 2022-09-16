package vtiger.Practice;

import java.util.Random;

public class PracticeRandomnumber {

	public static void main(String[] args) {

		Random r = new Random();
		int ran = r.nextInt(1000);
		System.out.println(ran);
	}

}
