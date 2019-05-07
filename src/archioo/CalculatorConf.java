package archioo;

import java.util.HashMap;
import java.util.Map;

public class CalculatorConf {
	
	private static final Map<Character, Operation> map = new HashMap<Character, Operation>();
	
	public static void init() {
		map.put('+', new Sum());
		map.put('/', new Division());
	}

	public static Operation getOperation(char sign) {
		return map.get(sign);
	}
	
}
