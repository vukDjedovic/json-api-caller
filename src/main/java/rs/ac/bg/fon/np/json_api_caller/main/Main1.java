package rs.ac.bg.fon.np.json_api_caller.main;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;

import rs.ac.bg.fon.np.json_api_caller.konvertor.KonvertorValuta;

public class Main1 {

	private static final String BASE_URL = "http://api.currencylayer.com";
	private static final String API_KEY = "0886329b0787418515c9e3a9bb63e986";
	private static final String ENDPOINT = "live";

	public static void main(String[] args) {

		try {
			KonvertorValuta konvertor = new KonvertorValuta();
			konvertor.setValutaKojaSeKonvertuje("USD");
			konvertor.setValutaUKojuSeKonvertuje("EUR");
			konvertor.setIznosKojiSeKonvertuje(100);

			Gson gson = new GsonBuilder().setPrettyPrinting().create();

			URL url = new URL(BASE_URL + "/" + ENDPOINT + "?access_key=" + API_KEY + "&source=" + konvertor.getValutaKojaSeKonvertuje()
					+ "&currencies=" + konvertor.getValutaUKojuSeKonvertuje());

			HttpURLConnection con = (HttpURLConnection)url.openConnection();
			
			con.setRequestMethod("GET");

			BufferedReader reader = new BufferedReader(new InputStreamReader(con.getInputStream()));

			JsonObject rez = gson.fromJson(reader, JsonObject.class);
			System.out.println(rez);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
