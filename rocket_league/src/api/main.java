package api;

import api.auth;
import util.connectionhandler;

public class main {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		// try{auth test = new auth();}catch(Exception e){}
		// callproc105 test = new callproc105();
		// auth test = new auth();
		callproc105 t;
		t = new callproc105();

		String id = "76561198011004815";
		// t.getPlayerSkillForSteam(id);
		// t.getSeasonalPlaylists();

		String payload = "&Proc[]=GetPopulationAllPlaylists";

		connectionhandler.chGetPopulation(payload);

		// connectionhandler.chcheckstatus();

	}

}
