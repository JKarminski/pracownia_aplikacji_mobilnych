import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int liczba = 0;
        Boolean antydebilizm = true;
        Boolean uzytkowniksienieznudzil = true;
        int[] tab = new int[6];
        tab[0] = 0;
        tab[1] = 0;
        tab[2] = 0;
        tab[3] = 0;
        tab[4] = 0;
        tab[5] = 0;
        int licznik = 0;
        while(uzytkowniksienieznudzil){
            liczba = 0;
            licznik = 0;
            antydebilizm = true;
            System.out.println("ile kostek chcesz rzucic?: ");
            Scanner iloscrzutow = new Scanner(System.in);
            int fajnyjezyk = iloscrzutow.nextInt();
            iloscrzutow.nextLine();
            if(fajnyjezyk>=3 && fajnyjezyk<=10){
                antydebilizm = false;
            }
            if(antydebilizm==false) {
                while (fajnyjezyk > 0) {
                    int losowaliczba = ((int) (Math.random() * 6) + 1);
                    System.out.println(losowaliczba);
                    tab[losowaliczba-1]++;
                    fajnyjezyk = fajnyjezyk - 1;
                }

                while (licznik<6){
                    if(tab[licznik]>=2){
                    liczba = liczba + tab[licznik]*(licznik+1);
                    }
                    licznik++;
                }
                System.out.println(liczba);
            }
            System.out.println("chcesz grac dalej bo brakuje mi hajsu na splate czynszu? (tak/nie): ");
            Scanner generowaniestringow = new  Scanner(System.in);
            String tekst = generowaniestringow.nextLine();
            System.out.println("Oh my days");
            System.out.println(tekst);
            if(tekst.equals("nie")){
                uzytkowniksienieznudzil = false;
                System.out.println("wroc do nas brakuje kieszonkowego");
            }
            /*switch(tekst){
                case "nie":
                    uzytkowniksienieznudzil = false;
            }*/
            tab[0] = 0;
            tab[1] = 0;
            tab[2] = 0;
            tab[3] = 0;
            tab[4] = 0;
            tab[5] = 0;
        }
    }
}