package api;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import javax.net.ssl.HttpsURLConnection;

import util.connectionhandler;

public class auth {

	//all private final Strings
	private final String host = "https://psyonix-rl.appspot.com/";
	private final String auth_url = "https://psyonix-rl.appspot.com/auth/";
	private static String reqBody = "&PlayerName=blackjack4494&PlayerID=76561198011004815&Platform=Steam&BuildID=-178744029&AuthCode=14000000E819192D58CF8ABD8F370603010010016869DC56180000000100000002000000A4C95A5F00000000C723F90C0F000000CA0000004A000000040000008F3706030100100116DC0300A4C95A5F2AB2A8C0000000001C90CF569C3FEB560100E4780000040000FA05000000721906000000B22E06000000223C060000000000DF73649ECED9EE752185EAC797DA64E7CF6888D249709FDE9AA262FDA405E8C42997F22D9C8B817B7AEFD40F2E45AE4387951858614AC1DC269352A152871EF0351072C7445765E55B05C296152B4975CE45E3C8930A6348CB7DFD6E5051FDEDDA5E90811B2551F1A532955244F5433A836974026B2005A99ED999A48E722C57&IssuerID=0";
	
	private final static String Player = "&PlayerName=blackjack4494"; //steam display name
	private final static String PlayerID = "&PlayerID=76561198011004815"; //steamid
	private final static String Platform = "&Platform=Steam"; //either Steam, PSN (or XBOXONE)?
	private final static String BuildID = "&BuildID=-168744029"; //can be everything
	private final static String AuthCode = "&AuthCode=14000000A72CD34151DEF2F38F370603010010015BF1DA56180000000100000002000000A4C95A5F2AB2A8C06B38CB060B000000CA0000004A000000040000008F3706030100100116DC0300A4C95A5F2AB2A8C0000000001C90CF569C3FEB560100E4780000040000FA05000000721906000000B22E06000000223C060000000000DF73649ECED9EE752185EAC797DA64E7CF6888D249709FDE9AA262FDA405E8C42997F22D9C8B817B7AEFD40F2E45AE4387951858614AC1DC269352A152871EF0351072C7445765E55B05C296152B4975CE45E3C8930A6348CB7DFD6E5051FDEDDA5E90811B2551F1A532955244F5433A836974026B2005A99ED999A48E722C57"; //can be anything but contains some data like how often a user connected the same day etc
	private final static String IssuerID = "&IssuerID=0"; //dunno about that
	private static String payload = Player + PlayerID + Platform + BuildID + AuthCode + IssuerID;
	
	//all private Strings
	private String sid = "";
	
	//public void main(String[] args) throws Exception {
	//	obtainSessionID();
	//}
	
	public auth() throws Exception {
			//obtainSessionID();
		//connectionhandler test
		String dpayload = reqBody; 
		connectionhandler.chauth(dpayload);
	}
	
	// getsid
	public String getsid() {
		return sid;
	}
	
	// send this request every 30s-1min to keep alive session id
	private void keepSessionId() throws Exception{
		
		String dpayload = "&PlaylistID=0&NumLocalPlayers=1";
		
		connectionhandler.chUpdatePopulation(dpayload);
	}

}
