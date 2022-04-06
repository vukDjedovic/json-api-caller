package rs.ac.bg.fon.np.json_api_caller.main;

import java.io.FileWriter;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;

public class Main4 {
	public static void main(String[] args) {
		try (FileWriter file = new FileWriter("rucni_upis.json")) {

			JsonObject object = new JsonObject();
			object.addProperty("valutaKojaSeKonvertuje", "USD");
			object.addProperty("valutaUKojuSeKonvertuje", "EUR");
			object.addProperty("iznosKojiSeKonvertuje", 100);
			object.addProperty("konvertovaniIznos", 91.1120);

			Gson gson = new GsonBuilder().setPrettyPrinting().create();
			gson.toJson(object, file);
		}

		catch (Exception e) {
			e.printStackTrace();
		}

	}
}
