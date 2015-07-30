package edu.sjtu.wikimaster;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
/**
 * 
 * @author Zhu
 */
public class Config extends Properties{

	private static final long serialVersionUID = 2309866476435156357L;
	private static Logger logger = LogManager.getLogger(Config.class.getName());
	private static Config instance;
	private static String path = "./src/easyir.properties";
	
	private static final Pattern PATTERN = Pattern
			            .compile("\\$\\{([^\\}]+)\\}");

	public static synchronized Config getInstance() {
		if (instance == null) {
			instance = new Config(path);
			return instance;
		} else {
			return instance;
		}
	}

	private Config(String path) {
		InputStream in;
		try {
			in = new BufferedInputStream(new FileInputStream(path));
			try {
				load(in);
			} catch (IOException ex) {

			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

	}

	public String get(String key) {
		// TODO Auto-generated method stub
		String value = getProperty(key);
		Matcher matcher = PATTERN.matcher(value);
		StringBuffer buffer = new StringBuffer();
		while (matcher.find()) {
			String matcherKey = matcher.group(1);
			String matchervalue = getProperty(matcherKey);
			if (matchervalue != null) {
				matcher.appendReplacement(buffer, matchervalue);
			}

		}
		matcher.appendTail(buffer);
		return buffer.toString();
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Config config = Config.getInstance();
		String res = config.get("author");
		logger.debug(res);
	}
}
