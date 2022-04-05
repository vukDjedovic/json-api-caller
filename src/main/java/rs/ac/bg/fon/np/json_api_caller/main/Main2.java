package rs.ac.bg.fon.np.json_api_caller.main;

import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;

import rs.ac.bg.fon.np.json_api_caller.konvertor.KonvertorValuta;

public class Main2 {

	private static final String BASE_URL = "http://api.currencylayer.com";
	private static final String API_KEY = "0886329b0787418515c9e3a9bb63e986";
	private static final String ENDPOINT = "historical";
	private static final String DATE = "2022-04-05";

	public static void main(String[] args) {
		KonvertorValuta konvertor1 = new KonvertorValuta();
		konvertor1.setValutaKojaSeKonvertuje("USD");
		konvertor1.setValutaUKojuSeKonvertuje("EUR");
		konvertor1.setIznosKojiSeKonvertuje(100);

		KonvertorValuta konvertor2 = new KonvertorValuta();
		konvertor2.setValutaKojaSeKonvertuje("USD");
		konvertor2.setValutaUKojuSeKonvertuje("CHF");
		konvertor2.setIznosKojiSeKonvertuje(100);

		KonvertorValuta konvertor3 = new KonvertorValuta();
		konvertor3.setValutaKojaSeKonvertuje("USD");
		konvertor3.setValutaUKojuSeKonvertuje("CAD");
		konvertor3.setIznosKojiSeKonvertuje(100);

		KonvertorValuta konvertor4 = new KonvertorValuta();
		konvertor4.setValutaKojaSeKonvertuje("USD");
		konvertor4.setValutaUKojuSeKonvertuje("HRK");
		konvertor4.setIznosKojiSeKonvertuje(100);

		KonvertorValuta konvertor5 = new KonvertorValuta();
		konvertor5.setValutaKojaSeKonvertuje("USD");
		konvertor5.setValutaUKojuSeKonvertuje("MKD");
		konvertor5.setIznosKojiSeKonvertuje(100);

		KonvertorValuta[] konvertoriValuta = { konvertor1, konvertor2, konvertor3, konvertor4, konvertor5 };

		Gson gson = new GsonBuilder().setPrettyPrinting().create();

		URL url;
		try {
			url = new URL(BASE_URL + "/" + ENDPOINT + "?access_key=" + API_KEY + "&date=" + DATE + "&source="
					+ konvertor1.getValutaKojaSeKonvertuje() + "&currencies=" + konvertor1.getValutaUKojuSeKonvertuje()
					+ "," + konvertor2.getValutaUKojuSeKonvertuje() + "," + konvertor3.getValutaUKojuSeKonvertuje()
					+ "," + konvertor4.getValutaUKojuSeKonvertuje() + "," + konvertor5.getValutaUKojuSeKonvertuje());

			System.out.println(url.toString());
			HttpURLConnection con = (HttpURLConnection) url.openConnection();

			try {
				con.setRequestMethod("GET");
			} catch (ProtocolException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			BufferedReader reader = new BufferedReader(new InputStreamReader(con.getInputStream()));

			JsonObject rez = gson.fromJson(reader, JsonObject.class);
			System.out.println(rez);

			if (rez.get("success").getAsBoolean()) {
				konvertor1.setKonvertovaniIznos(rez.get("quotes").getAsJsonObject().get("USDEUR").getAsDouble()
						* konvertor1.getIznosKojiSeKonvertuje());
				konvertor2.setKonvertovaniIznos(rez.get("quotes").getAsJsonObject().get("USDCHF").getAsDouble()
						* konvertor2.getIznosKojiSeKonvertuje());
				konvertor3.setKonvertovaniIznos(rez.get("quotes").getAsJsonObject().get("USDCAD").getAsDouble()
						* konvertor3.getIznosKojiSeKonvertuje());
				konvertor4.setKonvertovaniIznos(rez.get("quotes").getAsJsonObject().get("USDHRK").getAsDouble()
						* konvertor4.getIznosKojiSeKonvertuje());
				konvertor5.setKonvertovaniIznos(rez.get("quotes").getAsJsonObject().get("USDMKD").getAsDouble()
						* konvertor5.getIznosKojiSeKonvertuje());
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		try (FileWriter file = new FileWriter("niz_objekata.json")) {
			gson.toJson(konvertoriValuta, file);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
