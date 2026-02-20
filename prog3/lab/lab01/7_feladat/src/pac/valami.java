package pac;
import sample.calc.*;
public class valami {
	public static void main(String[] args) {
		Calculator c = new Calculator();
		int sum = 0;
		for(String arg: args) {
			sum = c.add(sum, Integer.parseInt(arg));
		}
		System.out.println(sum);
	}
}
