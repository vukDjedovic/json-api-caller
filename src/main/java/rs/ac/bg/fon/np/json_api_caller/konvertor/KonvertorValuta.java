package rs.ac.bg.fon.np.json_api_caller.konvertor;

public class KonvertorValuta {
	
	
	private String valutaKojaSeKonvertuje;

	private String valutaUKojuSeKonvertuje;

	private double iznosKojiSeKonvertuje;

	private double konvertovaniIznos;

	public String getValutaKojaSeKonvertuje() {
		return valutaKojaSeKonvertuje;
	}

	public void setValutaKojaSeKonvertuje(String valutaKojaSeKonvertuje) {
		this.valutaKojaSeKonvertuje = valutaKojaSeKonvertuje;
	}

	public String getValutaUKojuSeKonvertuje() {
		return valutaUKojuSeKonvertuje;
	}

	public void setValutaUKojuSeKonvertuje(String valutaUKojuSeKonvertuje) {
		this.valutaUKojuSeKonvertuje = valutaUKojuSeKonvertuje;
	}

	public double getIznosKojiSeKonvertuje() {
		return iznosKojiSeKonvertuje;
	}

	public void setIznosKojiSeKonvertuje(double iznosKojiSeKonvertuje) {
		this.iznosKojiSeKonvertuje = iznosKojiSeKonvertuje;
	}

	public double getKonvertovaniIznos() {
		return konvertovaniIznos;
	}

	public void setKonvertovaniIznos(double konvertovaniIznos) {
		this.konvertovaniIznos = konvertovaniIznos;
	}

	@Override
	public String toString() {
		return "Kriptovaluta [valutaKojaSeKonvertuje=" + valutaKojaSeKonvertuje + ", valutaUKojuSeKonvertuje="
				+ valutaUKojuSeKonvertuje + ", iznosKojiSeKonvertuje=" + iznosKojiSeKonvertuje + ", konvertovaniIznos="
				+ konvertovaniIznos + "]";
	}
}
