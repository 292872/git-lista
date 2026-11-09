//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Konto k1 = new Konto("Anna Kowalska", 1000.0);
        Konto k2 = new Konto("Jan Nowak");
        Konto k3 = new Konto("   ", -50.0);

        System.out.println(k1);
        System.out.println(k2);
        System.out.println(k3);

        robWplate(k2, 200.0);
        robWyplate(k1, 300.0);
        robWyplate(k2, 500.0);
        robWplate(k2, -50.0);
        robWplate(k1, 6000.0);
        robWyplate(k1, 6000.0);
        robWyplate(k1, 5000.0);


        System.out.println(k1);
        System.out.println(k2);
        System.out.println(k3);
        System.out.println("Liczba kont: " + Konto.getLiczbaKont());

        if (k1.maWiecejNiz(k2)) {
            System.out.println("Konto nr 1 ma wiecej niz konto nr 2: TAK");
        } else {
            System.out.println("Konto nr 1 ma wiecej niz konto nr 2: NIE");
        }
        Konto k2Ref = k1;
        k2Ref.wplac(100.0);


    }

    private static void robWplate(Konto k, double kwota) {
        boolean res = k.wplac(kwota);
        System.out.println("Wplata " + (int) kwota + " na konto nr " + k.getNumer() + ": " + (res ? "OK" : "ODMOWA"));
    }

    private static void robWyplate(Konto k, double kwota) {
        boolean res = k.wyplac(kwota);
        System.out.println("Wyplata " + (int) kwota + " z konta nr " + k.getNumer() + ": " + (res ? "OK" : "ODMOWA"));
    }
}