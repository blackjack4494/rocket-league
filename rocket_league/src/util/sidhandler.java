package util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class sidhandler {

	private static String sid = "";

	private static boolean file_exists = false;
	private static boolean file_not_empty = false;
	private static boolean file_length_32bytes = false;
	private static boolean file_matches_pattern = false;

	static File file = new File("sid.txt");

	// TODO: - change return type
	//
	//
	/**
	 * @throws Exception
	 */
	public static void checkSIDFile() throws Exception {

		if (file.exists() && !file.isDirectory()) {
			file_exists = true;
		} else {
			throw new FileNotFoundException("'Could not find file!'");
		}
		if (file_exists) {
			file_not_empty = file.length() != 0;
		}
		if(file_not_empty){
			file_length_32bytes = file.length() == 32;
		}
		if(file_length_32bytes){
			BufferedReader br = new BufferedReader(new FileReader(file));
			String str = br.readLine();
			br.close();
			file_matches_pattern = str.matches("[a-f0-9]+");
		}
		
		//DEBUGGING
		if (file_not_empty) {
			System.out.println("File check successful!");
		} else {
			System.out.println("File check failed!");
		}
		if(file_length_32bytes){
			System.out.println("File probably contains SID");
		} else {
			System.out.println("File length is not correct!");
		}
		if(file_matches_pattern){
			System.out.println("File content is matching pattern");
		} else {
			System.out.println("File content is not matching pattern!");
		}
		

	}

	// TODO: - change return type
	//
	//
	/**
	 * @throws Exception
	 */
	public static void readSID() throws Exception {

		if (file_not_empty) {
			BufferedReader br = new BufferedReader(new FileReader(file));
			sid = br.readLine();
			br.close();
			//System.out.println(sid);
		} else {
			throw new Exception("File error!");
		}
	}

}
