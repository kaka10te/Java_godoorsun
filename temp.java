import java.util.ArrayList;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);

		ArrayList<String> a = new ArrayList<String>();
		while (scan.hasNext()) {
			a.add(scan.nextLine());
		}
		int num[] = new int[100];
		for (int i = 0; i < a.size(); i++) {
			num[i] = Integer.parseInt(a.get(i).substring(1, 12));
		}
		
		int temp;
		for (int i = 0; i < a.size() - 1; i++) {
			for (int j = 0; j < a.size() - i - 1; j++) {
				if (num[j] > num[j + 1]) {
					temp = num[j];
					num[j] = num[j + 1];
					num[j + 1] = temp;
				}
			}
		}

		for (int x = 0; x < a.size(); x++) {
			for (int j = 0; j < a.size(); j++) {
				if (num[x] == Integer.parseInt(a.get(j).substring(1, 12)))
					System.out.println(a.get(j));
			}
		}
		scan.close();
	}
}
