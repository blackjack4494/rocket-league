package main;

import util.sidhandler;

public class god {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		
		sidhandler.readSID();
		System.out.println(sidhandler.readSID());
		String test = sidhandler.readSID();
		System.out.println(test);
	}

	//
	public String getSID() throws Exception {
		return sidhandler.readSID();
	}

}
