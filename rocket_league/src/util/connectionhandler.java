package util;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.URL;

import javax.net.ssl.HttpsURLConnection;

public class connectionhandler {
	
	//all private final Strings
	private final static String callproc_url = "https://psyonix-rl.appspot.com/callproc105/";
	private final static String CallProcKey = "pX9pn8F4JnBpoO8Aa219QC6N7g18FJ0F";
	
	//all private Strings
	private static String sid = "529b2811969b0a9015c1f43808598753";
	private static String test2 = "";
	
	//
	private final static String update_population_url = "https://psyonix-rl.appspot.com/Population/UpdatePlayerCurrentGame/";
	private final static String get_population_url = "https://psyonix-rl.appspot.com/Population/GetPopulation/";
	
	//all private final Strings
	private final String host = "https://psyonix-rl.appspot.com/";
	private final static String auth_url = "https://psyonix-rl.appspot.com/auth/";
	private final static String reqBody = "&PlayerName=blackjack4494&PlayerID=76561198011004815&Platform=Steam&BuildID=342373649&AuthCode=14000000348D01696C79C1C68F370603010010019795DE56180000000100000002000000A4C95A5F00000000E3F1111415000000CA0000004A000000040000008F3706030100100116DC0300A4C95A5F2AB2A8C000000000E16ADD56611AF9560100E4780000040000FA05000000721906000000B22E06000000223C060000000000DD757D1409E0FD390D4197E3650EC28397D0F922A3D5D3C05F3B18BFA0910AEF46D0FB815B6A14168DFEA1A6BFB68AF7E6A5FFBCDC28CAF12AE84DB45388BD78039DE75A54A705B0E6C528BA1C64556D5A7433F4432E7B20A275CCDB530802DE7464BCF4894CA9BD1C92E190415731D94275E4A3713140EF8B8CCC8ABC4E30DB&IssuerID=0";
	
	private final static String LoginSecretKey = "dUe3SE4YsR8B0c30E6r7F2KqpZSbGiVx";
	private final String Player = "&PlayerName=blackjack4494"; //steam display name
	private final String PlayerID = "&PlayerID=76561198011004815"; //steamid
	private final String Platform = "&Platform=Steam"; //either Steam, (PS4 or Xbox)?
	private final String BuildID = "&BuildID=-168744029"; //can be everything
	private final String AuthCode = "&AuthCode=14000000A72CD34151DEF2F38F370603010010015BF1DA56180000000100000002000000A4C95A5F2AB2A8C06B38CB060B000000CA0000004A000000040000008F3706030100100116DC0300A4C95A5F2AB2A8C0000000001C90CF569C3FEB560100E4780000040000FA05000000721906000000B22E06000000223C060000000000DF73649ECED9EE752185EAC797DA64E7CF6888D249709FDE9AA262FDA405E8C42997F22D9C8B817B7AEFD40F2E45AE4387951858614AC1DC269352A152871EF0351072C7445765E55B05C296152B4975CE45E3C8930A6348CB7DFD6E5051FDEDDA5E90811B2551F1A532955244F5433A836974026B2005A99ED999A48E722C57"; //can be anything but contains some data like how often a user connected the same day etc
	private final String IssuerID = "&IssuerID=0"; //dunno about that
	private final String payload = Player + PlayerID + Platform + BuildID + AuthCode + IssuerID;
	
	// serialize requests
			public static void chauth(String payload) throws Exception {
				
			URL obj = new URL(auth_url);
			HttpsURLConnection con = (HttpsURLConnection) obj.openConnection();
				
			// add request header
			con.setRequestMethod("POST");
			con.setRequestProperty("LoginSecretKey", LoginSecretKey);
				
			String data_payload = payload;
				
			con.setDoOutput(true);
			DataOutputStream dos = new DataOutputStream(con.getOutputStream());
			dos.writeBytes(data_payload);
			dos.flush();
			dos.close();
				
			int responseCode = con.getResponseCode();
			String SessionID = con.getHeaderField("SessionID");
			sid = SessionID;
			System.out.println("\nSending 'POST' request to URL : " + auth_url);
			System.out.println("Post parameters : " + data_payload);
			System.out.println("Response Code : " + responseCode);
			System.out.println("SessionID: " + SessionID);
			BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
			String inLine;
			StringBuffer response = new StringBuffer();
			
			while ((inLine = in.readLine()) != null) {
				response.append(inLine);
			}
			in.close();
			
			// print result
			System.out.println("Content: " + response.toString());
			
			test2 = SessionID;
			System.out.println("Test: " + test2);
			
		}
	
			// serialize requests
			public static void chcallproc(String payload) throws Exception {
				
			URL obj = new URL(callproc_url);
			HttpsURLConnection con = (HttpsURLConnection) obj.openConnection();
				
			// add request header
			con.setRequestMethod("POST");
			con.setRequestProperty("CallProcKey", CallProcKey);
			con.setRequestProperty("SessionID", sid);
				
			String data_payload = payload;
				
			con.setDoOutput(true);
			DataOutputStream dos = new DataOutputStream(con.getOutputStream());
			dos.writeBytes(data_payload);
			dos.flush();
			dos.close();
				
			int responseCode = con.getResponseCode();
			System.out.println("\nSending 'POST' request to URL : " + callproc_url);
			System.out.println("Post parameters : " + data_payload);
			System.out.println("Response Code : " + responseCode);
			BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
			String inLine;
			StringBuffer response = new StringBuffer();
				
			while ((inLine = in.readLine()) != null) {
				response.append(inLine);
			}
			in.close();
				
			// print result
			System.out.println("Content: " + response.toString());
		}
			
			//
			public static void chUpdatePopulation(String payload) throws Exception {
				
			URL obj = new URL(update_population_url);
			HttpsURLConnection con = (HttpsURLConnection) obj.openConnection();
				
			// add request header
			con.setRequestMethod("POST");
			con.setRequestProperty("CallProcKey", CallProcKey);
			con.setRequestProperty("SessionID", sid);
				
			String data_payload = payload;
				
			con.setDoOutput(true);
			DataOutputStream dos = new DataOutputStream(con.getOutputStream());
			dos.writeBytes(data_payload);
			dos.flush();
			dos.close();
				
			int responseCode = con.getResponseCode();
			System.out.println("\nSending 'POST' request to URL : " + update_population_url);
			System.out.println("Post parameters : " + data_payload);
			System.out.println("Response Code : " + responseCode);
			BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
			String inLine;
			StringBuffer response = new StringBuffer();
				
			while ((inLine = in.readLine()) != null) {
				response.append(inLine);
			}
			in.close();
				
			// print result
			System.out.println("Content: " + response.toString());
		}
			
			//
			public static void chGetPopulation(String payload) throws Exception {
				
			URL obj = new URL(get_population_url);
			HttpsURLConnection con = (HttpsURLConnection) obj.openConnection();
				
			// add request header
			con.setRequestMethod("POST");
			con.setRequestProperty("CallProcKey", CallProcKey);
			con.setRequestProperty("SessionID", sid);
				
			String data_payload = payload;
				
			con.setDoOutput(true);
			DataOutputStream dos = new DataOutputStream(con.getOutputStream());
			dos.writeBytes(data_payload);
			dos.flush();
			dos.close();
				
			int responseCode = con.getResponseCode();
			System.out.println("\nSending 'POST' request to URL : " + get_population_url);
			System.out.println("Post parameters : " + data_payload);
			System.out.println("Response Code : " + responseCode);
			BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
			String inLine;
			StringBuffer response = new StringBuffer();
				
			while ((inLine = in.readLine()) != null) {
				response.append(inLine);
			}
			in.close();
				
			// print result
			System.out.println("Content: " + response.toString());
		}
			
}
