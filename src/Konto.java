public class Konto {
    public static double MAKS_WYPLATA = 5000; //stała może być publiczna, bo jest informacją, która nie wpływa na realne wartości portfela
    private static int liczbaKont;
    private final int numer;
    private final String wlasciciel;
    private double saldo;
    private int liczbaOperacji;

    public Konto(String wlasciciel) {
        liczbaKont++;
        this.numer = liczbaKont;
        if (wlasciciel == null || wlasciciel.trim().isEmpty()) {
            this.wlasciciel = "nieznany";
        } else {
            this.wlasciciel = wlasciciel;
        }
        this.liczbaOperacji = 0;
        this.saldo = 0.0;
    }

    public Konto(String wlasciciel, double saldoPoczatkowe) {
        this(wlasciciel);
        if (saldoPoczatkowe > 0) {
            this.saldo = saldoPoczatkowe;
        } else {
            this.saldo = 0.0;
        }

    }

    public static int getLiczbaKont() {
        return liczbaKont;
    }

    // brak możliwości publicznej ustawienia salda i liczby operacji( brak setterów, żeby zablokować użytkownikowi modyfikacje kruchych parametrów)
    public int getNumer() {
        return numer;
    }

    public String getWlasciciel() {
        return wlasciciel;
    }

    public double getSaldo() {
        return saldo;
    }

    public int getLiczbaOperacji() {
        return liczbaOperacji;
    }

    public boolean wplac(double kwota) {
        if (kwota <= 0) {
            return false;
        } else {
            this.saldo += kwota;
            liczbaOperacji++;
            return true;
        }

    }

    public boolean czyMozeWyplacic(double kwota) {
        return kwota >= 0 || kwota < saldo || kwota < MAKS_WYPLATA;
    }

    public boolean wyplac(double kwota) {
        if (czyMozeWyplacic(kwota)) {
            this.saldo -= kwota;
            liczbaOperacji++;
            return true;
        } else {
            return false;
        }
    }

    public boolean maWiecejNiz(Konto inneKonto) {
        if (inneKonto == null) return false;
        return this.saldo > inneKonto.saldo;
    }

    public String toString() {
        return "Konto nr " + numer + " [" + wlasciciel + "] saldo: " + String.format("%.2f", saldo) + " | operacji: " + liczbaOperacji;
    }
}
