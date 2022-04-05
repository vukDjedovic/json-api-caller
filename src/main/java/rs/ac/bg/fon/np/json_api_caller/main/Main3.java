package rs.ac.bg.fon.np.json_api_caller.main;

import java.io.FileReader;
import java.util.Arrays;
import java.util.List;

import com.google.gson.Gson;

import rs.ac.bg.fon.np.json_api_caller.konvertor.KonvertorValuta;

public class Main3 {

	public static void main(String[] args) {
		try (FileReader file = new FileReader("niz_objekata.json")){
			Gson gson = new Gson();
			List<KonvertorValuta> konvertorivaluta = Arrays.asList(gson.fromJson(file,  KonvertorValuta[].class));
			for (KonvertorValuta konvertorValuta : konvertorivaluta) {
				System.out.println(konvertorValuta);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
