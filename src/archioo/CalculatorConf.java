package archioo;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class CalculatorConf {
	
	private static final Map<Character, Operation> map = new HashMap<Character, Operation>();
	
	private static void initOperations() {
		map.put('+', new Sum());
		map.put('/', new Division());
	}
	
	private static void initLanguages() throws IOException, NullPointerException {
		MyProperties.init();
		MyProperties.parse("fr");
	}
	
	public static void init() throws IOException, NullPointerException {
		initOperations();
		initLanguages();
	}

	public static Operation getOperation(char sign) {
		return map.get(sign);
	}
	
}
