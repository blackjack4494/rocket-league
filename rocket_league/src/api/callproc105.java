package api;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import javax.net.ssl.HttpsURLConnection;

import util.connectionhandler;

/**
 * @author tom_h
 *
 */
public class callproc105 {
		
		public callproc105() throws Exception {
				//this.sid = sid;
				//connectionhandler test
				//String payload = "&Proc[]=GetGameServerPingList";
				//connectionhandler.chcallproc(payload);
			//getGameServers();
		}
		
		/*
		 * RL supports multi/cross-platform
		 * Create two or more methods with the same name -
		 * but different parameters (steam use ids. ps4 names)
		 */
				
		// Game Server
		public void getGameServers() throws Exception {
			
			String payload = "&Proc[]=GetGameServerPingList"; 
			
			connectionhandler.chcallproc(payload);
			
		}
		
		// Player Skill
		// for steam
		/**
		 * @param UserID
		 * @throws Exception
		 */
		public void getPlayerSkillForSteam(String UserID) throws Exception {
			
			//String UserID = "";
			
			String payload = "&Proc[]=GetPlayerSkillSteam&P0P[]=" + UserID; //either SteamID or PSN/XboxO Name
			
			connectionhandler.chcallproc(payload);
			
		}
		
		// Player Skill
		// for ps4
		public void getPlayerSkillForPS4(String UserName) throws Exception {
			
			//String UserName = "";
			
			String payload = "&Proc[]=GetPlayerSkillPS4&P0P[]=" + UserName; //either SteamID or PSN/XboxO Name
			
			connectionhandler.chcallproc(payload);
			
		}
		
		// FUTURE FEATURE
		// use this to request PlayerSkill for multiple Users 
		// use case: queue skill check
		// this will reduce number of packages sent
		public void getPlayerSkillBulk(String[] UserIDs) throws Exception {
			
			//to ignore error
			int i = 0;
			
			//String UserIDs = "user1, user2, user3...";
			// use loop (maybe for each) or iterate to get all users
			// increase number i in "&PiP" for every "&Proc" Request
			// e.g. "&Proc[]=GetPlayerSkillSteam&P0P[]=123456789&Proc[]=GetPlayerSkillSteam&P1P[]=12345678&Proc[]=GetPlayerSkillSteam&P2P[]=1234567" and so on.
			
			
			String payload = "&Proc[]=GetPlayerSkillSteam&P0P[]=" + UserIDs[i];
			
			connectionhandler.chcallproc(payload);
			
		}
		
		// Player Titles
		// extend this method. there is only response if there are titles otherwise nothing.
		public void getPlayerTitles(String UserID) throws Exception {
			
			//for Steam
			String payload = "&Proc[]=GetPlayerTitlesSteam&P0P[]=" + UserID;
			
			connectionhandler.chcallproc(payload);
			
		}
		
		//
		public void getPlayerTitles(String[] UserIDs) throws Exception {
			
			//for Steam
			int i = 0;
			int z = 0;
			String payload = "&Proc[]=GetPlayerTitlesSteam&P" + z + "P[]=" + UserIDs[i];
			
			String proc = "&Proc[]=GetPlayerTitlesSteam";
			String template = proc + "&P" + z + "P[]=" + UserIDs[i];
			
			//connectionhandler.chcallproc(payload);
			connectionhandler.chcallproc(template);
			
		}
		
		// get seasonal playlists
		public void getSeasonalPlaylists() throws Exception {
			
			String payload = "&Proc[]=GetSeasonalPlaylists"; // get all featured (or time limited) playlists/queues
			
			connectionhandler.chcallproc(payload);
			
		}
		
		// get all (available?) dlcs
		// for steam
		public void getAvailableDLCs() throws Exception {
			
			//for Steam
			String payload = "&Proc[]=GetDLCSteam";
			
			connectionhandler.chcallproc(payload);
			
		}
		
		// get all (available?) dlcs
		// for ps4
		public void getAvailableDLCsForPS4() throws Exception {
			
			//for ps4
			String payload = "&Proc[]=GetDLCPS4";
			
			connectionhandler.chcallproc(payload);
			
		}
		
		// get Status infos e.g. if ranked is enabled
		public void getGenericDataStatus() throws Exception {
			
			String payload = "&Proc[]=GetGenericDataAll";
			
			connectionhandler.chcallproc(payload);
			
		}
		
		// dunno what you can do with that information
		// maybe for steam/ps4 v xboxone
		public void getRegionList() throws Exception {
			
			String payload = "&Proc[]=GetRegionListForPlatform&P0P[]=INTv2";
			
			connectionhandler.chcallproc(payload);
			
		}
		
		//
		public void getSkillLeaderboard(String PlaylistID) throws Exception {
			
			//leaderboard for one playlist
			
			String payload = "&Proc[]=GetSkillLeaderboard_v2&P0P[]=" + PlaylistID;
			
			connectionhandler.chcallproc(payload);
			
		}
		
		//
		public void getSkillLeaderboard(String[] PlaylistIDs) throws Exception {
			
			//leaderboard for all playlists
			
			int z = 0;
			int i = 0;
			String payload = "&Proc[]=GetSkillLeaderboard_v2&P" + z + "P[]=" + PlaylistIDs[i];
			
			connectionhandler.chcallproc(payload);
			
		}
		
		//
		public void getSkillLeaderboardForUser(String UserID, String PlaylistID) throws Exception {
			
			//one user in one playlist
			
			//for steam
			String payload = "&Proc[]=GetSkillLeaderboardValueForUser_v2Steam&P0P[]=" + UserID + "&P0P[]=" + PlaylistID; 
			//p0p=10 is the playlist (10 = solo duel)
			//returns LeaderboardID=Skill10&MMR=82.2435&Value=15
			// where value means the ranking (15 = grand champion -/- 0 = prospect I)
			
			connectionhandler.chcallproc(payload);
			
		}
		
		//
		public void getSkillLeaderboardForUser(String UserID, String[] PlaylistIDs) throws Exception {
			
			//one use in all playlists
			
			//for steam
			String payload = "&Proc[]=GetSkillLeaderboardValueForUser_v2Steam&P0P[]=" + UserID + "&P0P[]=" + PlaylistIDs[0];
			
			//alternative
			String proc = "&Proc[]=GetSkillLeaderboardValueForUser_v2Steam";
			int z = 0; //use this in loops and increase it
			int i = 0; //use this as index for String arrays
			String template = proc + "&P" + z +"P[]=" + UserID + "&P" + z + "P[]=" + PlaylistIDs[i];
			
			connectionhandler.chcallproc(payload);
			
		}
		
		//
		public void getSkillLeaderboardForUserBulk(String[] UserIDs, String[] PlaylistIDs) throws Exception {
			
			//multiple users in all playlists
			
			//for steam
			String payload = "&Proc[]=GetSkillLeaderboardValueForUser_v2Steam&P0P[]=" + UserIDs[0] + "&P0P[]=" + PlaylistIDs[0] + "&Proc[]=GetSkillLeaderboardValueForUser_v2Steam&P1P[]=" + UserIDs[1] + "&P1P[]=" + PlaylistIDs[1];
			
			//alternative
			String proc = "&Proc[]=GetSkillLeaderboardValueForUser_v2Steam";
			int z = 0; //use this in loops and increase it
			int i = 0; //use this as index for String arrays
			String template = proc + "&P" + z +"P[]=" + UserIDs[i] + "&P" + z + "P[]=" + PlaylistIDs[i];
			
			connectionhandler.chcallproc(payload);
			
		}
		
		//
		public void getLeaderboardTopWins() throws Exception {
			
			//100 is standard. returns 200 results. 100 of each platform ps4/steam
			String payload = "&Proc[]=GetLeaderboard&P0P[]=Wins&P0P[]=100";
			
			connectionhandler.chcallproc(payload);
			
		}
		
		//
		public void getLeaderboardTopWins(String z) throws Exception {
			
			//returns double the amount of z. z is for each platform ps4/steam
			//max z = 500
			String payload = "&Proc[]=GetLeaderboard&P0P[]=Wins&P0P[]=" + z;
			
			connectionhandler.chcallproc(payload);
			
		}
		
		//
		public void getLeaderboardTopGoals() throws Exception {
			
			//100 is standard. returns 200 results. 100 of each platform ps4/steam
			String payload = "&Proc[]=GetLeaderboard&P0P[]=Goals&P0P[]=100";
			
			connectionhandler.chcallproc(payload);
			
		}
		
		//
		public void getLeaderboardTopGoals(String z) throws Exception {
			
			//returns double the amount of z. z is for each platform ps4/steam
			//max z = 500
			String payload = "&Proc[]=GetLeaderboard&P0P[]=Goals&P0P[]=" + z;
			
			connectionhandler.chcallproc(payload);
			
		}
		
		//
		public void getLeaderboardTopMVPs() throws Exception {
			
			//100 is standard. returns 200 results. 100 of each platform ps4/steam
			String payload = "&Proc[]=GetLeaderboard&P0P[]=MVPs&P0P[]=100";
			
			connectionhandler.chcallproc(payload);
			
		}
		
		//
		public void getLeaderboardTopMVPs(String z) throws Exception {
			
			//returns double the amount of z. z is for each platform ps4/steam
			//max z = 500
			String payload = "&Proc[]=GetLeaderboard&P0P[]=MVPs&P0P[]=" + z;
			
			connectionhandler.chcallproc(payload);
			
		}
		
		//
		public void getLeaderboardTopSaves() throws Exception {
			
			//100 is standard. returns 200 results. 100 of each platform ps4/steam
			String payload = "&Proc[]=GetLeaderboard&P0P[]=Saves&P0P[]=100";
			
			connectionhandler.chcallproc(payload);
			
		}
		
		//
		public void getLeaderboardTopSaves(String z) throws Exception {
			
			//returns double the amount of z. z is for each platform ps4/steam
			//max z = 500
			String payload = "&Proc[]=GetLeaderboard&P0P[]=Saves&P0P[]=" + z;
			
			connectionhandler.chcallproc(payload);
			
		}		
		
		//
		public void getLeaderboardTopShots() throws Exception {
			
			//100 is standard. returns 200 results. 100 of each platform ps4/steam
			String payload = "&Proc[]=GetLeaderboard&P0P[]=Shots&P0P[]=100";
			
			connectionhandler.chcallproc(payload);
			
		}
		
		//
		public void getLeaderboardTopShots(String z) throws Exception {
			
			//returns double the amount of z. z is for each platform ps4/steam
			//max z = 500
			String payload = "&Proc[]=GetLeaderboard&P0P[]=Shots&P0P[]=" + z;
			
			connectionhandler.chcallproc(payload);
			
		}
		
		//
		public void getLeaderboardTopAssists() throws Exception {
			
			//100 is standard. returns 200 results. 100 of each platform ps4/steam
			String payload = "&Proc[]=GetLeaderboard&P0P[]=Assists&P0P[]=100";
			
			connectionhandler.chcallproc(payload);
			
		}
		
		//
		public void getLeaderboardTopAssists(String z) throws Exception {
			
			//returns double the amount of z. z is for each platform ps4/steam
			//max z = 500
			String payload = "&Proc[]=GetLeaderboard&P0P[]=Assists&P0P[]=" + z;
			
			connectionhandler.chcallproc(payload);
			
		}
		
		//
		public void getWins(String UserID) throws Exception {
			
			//for steam
			String payload = "&Proc[]=GetLeaderboardValueForUserSteam&P0P[]=" + UserID + "&P0P[]=Wins";
			
			connectionhandler.chcallproc(payload);
			
		}
		
		//
		public void getGoals(String UserID) throws Exception {
			
			//for steam
			String payload = "&Proc[]=GetLeaderboardValueForUserSteam&P0P[]=" + UserID + "&P0P[]=Goals";
			
			connectionhandler.chcallproc(payload);
			
		}
		
		//
		public void getMVPs(String UserID) throws Exception {
			
			//for steam
			String payload = "&Proc[]=GetLeaderboardValueForUserSteam&P0P[]=" + UserID + "&P0P[]=MVPs";
			
			connectionhandler.chcallproc(payload);
			
		}	
		
		//
		public void getSaves(String UserID) throws Exception {
			
			//for steam
			String payload = "&Proc[]=GetLeaderboardValueForUserSteam&P0P[]=" + UserID + "&P0P[]=Saves";
			
			connectionhandler.chcallproc(payload);
			
		}
		
		//
		public void getShots(String UserID) throws Exception {
			
			//for steam
			String payload = "&Proc[]=GetLeaderboardValueForUserSteam&P0P[]=" + UserID + "&P0P[]=Shots";
			
			connectionhandler.chcallproc(payload);
			
		}
		
		//
		public void getAssists(String UserID) throws Exception {
			
			//for steam
			String payload = "&Proc[]=GetLeaderboardValueForUserSteam&P0P[]=" + UserID + "&P0P[]=Assists";
			
			connectionhandler.chcallproc(payload);
			
		}
		
		//
		public void w00t() throws Exception {
			
			String payload = "&Proc[]=GetSkillLeaderboard_v2&P0P[]=10&Proc[]=GetSkillLeaderboardValueForUser_v2Steam&P1P[]=76561198011004815&P1P[]=10";
			
			connectionhandler.chcallproc(payload);

		}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
}
