package api;

import util.connectionhandler;

public class population {
	
	/*
	// All Playlists
	PlaylistID=-2&NumPlayers=4133 (Currently waiting for a game)
	PlaylistID=0&NumPlayers=40304 (Lobby)
	PlaylistID=2&NumPlayers=8361 (Normal Doubles)
	PlaylistID=4&NumPlayers=2694 (Chaos)
	PlaylistID=6&NumPlayers=3555 (Private Match)
	PlaylistID=7&NumPlayers=2992 (Season)
	PlaylistID=8&NumPlayers=4894 (Exhibition)
	PlaylistID=9&NumPlayers=2638 (Training)
	PlaylistID=10&NumPlayers=2402 (Ranked Solo Duel)
	PlaylistID=12&NumPlayers=2954 (Ranked Solo Standard)
	PlaylistID=13&NumPlayers=9157 (Ranked Standard)
	PlaylistID=16&NumPlayers=2197 (Rocket Labs)
	PlaylistID=1&NumPlayers=902 (Normal Duel)
	PlaylistID=3&NumPlayers=11192 (Normal Standard)
	PlaylistID=15&NumPlayers=979 (Snow Day)
	PlaylistID=11&NumPlayers=17540 (Ranked Doubles)
	PlaylistID=17&NumPlayers=xxxx (Hoops) - Basketball
	
	PlaylistID=0&NumPlayers=39953 (Lobby)
	PlaylistID=1&NumPlayers=862 (Normal Duel)
	PlaylistID=2&NumPlayers=8419 (Normal Doubles)
	PlaylistID=3&NumPlayers=11407 (Normal Standard)
	PlaylistID=4&NumPlayers=2731 (Chaos)
	PlaylistID=6&NumPlayers=3755 (Private Match)
	PlaylistID=7&NumPlayers=2944 (Season)
	PlaylistID=9&NumPlayers=2504 (Training)
	PlaylistID=10&NumPlayers=2437 (Ranked Solo Duel)
	PlaylistID=11&NumPlayers=17461 (Ranked Doubles)
	PlaylistID=12&NumPlayers=3051 (Ranked Solo Standard)
	PlaylistID=13&NumPlayers=9531 (Ranked Standard)
	PlaylistID=15&NumPlayers=1006 (Snow Day)
	PlaylistID=16&NumPlayers=2133 (Rocket Labs)
	PlaylistID=17&NumPlayers=xxxx (Hoops) - Basketball
	PlaylistID=-2&NumPlayers=4486 (Currently waiting for a game)
	PlaylistID=8&NumPlayers=4858 (Exhibition)
	*/
	
	// Get active players in queue
	private void getPopulation() throws Exception {
		
		//use this method every 1-5min
		//since the rl database is just being updated every few mins.
		
		//this endpoint allows to insert everything or nothing the response will be the same.
		String payload = "&Proc[]=GetPopulationAllPlaylists";
		
		connectionhandler.chGetPopulation(payload);
		
	}

}
