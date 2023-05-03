// Prohram ini menghitung FPB (Faktor persekutuan terbesar dari 2 bilangan

class FPB {
    int bilangan;
    FPB(int bilangan){
        this.bilangan = bilangan;
    }
    int hitungFPB(int bilangan1, int bilangan2){
        if (bilangan2 == 0) {
            return bilangan1;
        } else {
            return hitungFPB(bilangan2, (bilangan1 % bilangan2)); //Pemanggilan rekursif
        }
    }
}

public class Rekursif {
    public static void main(String[] args) {
        FPB bilangan1 = new FPB(24);
        FPB bilangan2 = new FPB(36);

        int hasil = bilangan1.hitungFPB(bilangan1.bilangan, bilangan2.bilangan);
        System.out.println("FPB dari " + bilangan1.bilangan + " dan " + bilangan2.bilangan + " adalah " + hasil);
    }
}

