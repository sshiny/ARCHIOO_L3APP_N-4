package archioo;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.Map;

public class MyProperties {

	private static final String DEFAULT_LANGUAGE = "en";
	private static Map<String, String> lang = new HashMap<>();
	private static Map<String, File> file = new HashMap<>();
	
	private static void initLang(String l) throws IOException, NullPointerException {
		File f = file.get(l);
		InputStream s = new FileInputStream(f);
		BufferedReader rdr = new BufferedReader(new InputStreamReader(s, Charset.forName("UTF-8")));
		String str;
		while ((str = rdr.readLine()) != null) {
			String[] split = str.split(" = ");
			lang.put(split[0], split[1]);
		}
		rdr.close();
	}
	
	public static void init() {
		file.put(MyProperties.DEFAULT_LANGUAGE, new File(System.getProperty("user.dir"), "lang_en.properties"));
		file.put("fr", new File(System.getProperty("user.dir"), "lang_fr.properties"));
	}

	public static void parse() throws IOException, NullPointerException  {
		initLang(MyProperties.DEFAULT_LANGUAGE);
	}
	
	public static void parse(String l) throws IOException, NullPointerException {
		initLang(l);
	}
	
	public static String readProperty(String key) {
		return lang.get(key);
	}
	
}
