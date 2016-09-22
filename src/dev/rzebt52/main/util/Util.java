package dev.rzebt52.main.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Util {

	public static String loadFile(String path) {
		
		StringBuilder b = new StringBuilder();
		
		if (new File(path).exists()) {
			BufferedReader br = null;
			try {

				br = new BufferedReader(new FileReader(path));
				String line;
				while ((line = br.readLine()) != null) {
					b.append(line + "\n");
				}

			} catch (IOException e) {
				e.printStackTrace();
			} finally {
				try {
					br.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		} else {
			return null;
		}

		return b.toString();

	}

	public static int parseInt(String str) {
		try {
			return Integer.parseInt(str);
		} catch (NumberFormatException e) {
			e.printStackTrace();
			return 0;
		}

	}

}
