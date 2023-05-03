
class Mobil {
    String Nama;
    boolean mesinHidup;
    int kecepatan;
    int jarak;

    // Constructor
    Mobil(String Nama){
        this.Nama = Nama;
        this.mesinHidup = false;
        this.kecepatan = 0;
        this.jarak = 0;
    }

    // method menghidupkan mesin
    void hidupkanMesin(){
        if (this.mesinHidup) {
            System.out.println("Mobil " + this.Nama + " sudah hidup");
        } else {
            this.mesinHidup = true;
            System.out.println("Mobil " + this.Nama + " dihidupkan");
        }
    }

    // method mematikan mesin
    void matikanMesin(){
        if (!this.mesinHidup) {
            System.out.println("Mobil " + this.Nama + " sudah dimatikan");
        } else if (this.kecepatan > 0) {
            System.out.println("Tidak bisa mematikan mobil " + this.Nama + " saat mobil bergerak.");
        } else {
            this.mesinHidup = false;
            System.out.println("Mobil " + this.Nama + " dimatikan");
        }
    }

    // method jika ingin memajukan mobil
    void maju(int kecepatan) {
        if(!this.mesinHidup) {
            System.out.println("Mobil " + this.Nama + " belum dihidupkan");
        } else if (kecepatan < 0) {
            System.out.println("Kecepatan " + this.Nama + " tidak valid.");
        } else {
            this.kecepatan = kecepatan;
            this.jarak += kecepatan;
            System.out.println("Mobil " + this.Nama + " maju dengan kecepatan " + kecepatan);
        }
    }

    // method jika ingin memundurkan mobil
    void mundur(int kecepatan) {
        if (!this.mesinHidup) {
            System.out.println("Mobil " + this.Nama + " belum dihdupkan");
        } else if (kecepatan < 0){
            System.out.println("Kecepatan " + this.Nama + " tidak valid");
        } else {
            this.kecepatan = kecepatan;
            this.jarak -= kecepatan;
            System.out.println("Mobil " + this.Nama + " mundur dengan kecepatan "+ kecepatan);
        }
    }

    // method untuk memberhentikan mobil
    void rem() {
        if (this.kecepatan == 0){
            System.out.println("Mobil " + this.Nama + " sudah berhenti.");
        } else {
            this.kecepatan = 0;
            System.out.println("Mobil " + this.Nama + " dihentikan dengan rem.");
        }
    }

    // method untuk mengetahui mobil sudah berada dijarak berapa
    void cekJarak() {
        System.out.println("Mobil " + this.Nama + " berada di posisi " + this.jarak);
    }

    // method untuk membandingkan 2 posisi mobil
    void Posisi(Mobil namaMobil){
        if (this.jarak < namaMobil.jarak){
            System.out.println("Mobil " + namaMobil.Nama + " berada di depan mobil " + this.Nama);
        } else if (this.jarak > namaMobil.jarak) {
            System.out.println("Mobil " + namaMobil.Nama + " berada di belakang mobil " + this.Nama);
        } else {
            System.out.println("Mobil " + this.Nama + " dan " + namaMobil.Nama + " berada di posisi yang sama");
        }
    }
}
class RemoteControl {
    Mobil mobil;

    // constructor
    RemoteControl(Mobil mobil) {
        this.mobil = mobil;
    }
    void hidupkanMesin() {
        mobil.hidupkanMesin();
    }
    void matikanMesin() {
        mobil.matikanMesin();
    }
    void maju(int kecepatan) {
        mobil.maju(kecepatan);
    }
    void mundur(int kecepatan) {
        mobil.mundur(kecepatan);
    }
    void rem() {
        mobil.rem();
    }
    void cekJarak() {
        mobil.cekJarak();
    }
    void Posisi(Mobil namaMobil){
        mobil.Posisi(namaMobil);
    }
}

public class SimulasiMobil {
    public static void main(String[] args) {
        // Membuat objek
        Mobil RedBull = new Mobil("RB19");
        RemoteControl remoteControlRB = new RemoteControl(RedBull);

        Mobil Ferrari = new Mobil("SF23");
        RemoteControl remoteControlFerrari = new RemoteControl(Ferrari);

        // Aksi Remote Control
        remoteControlRB.hidupkanMesin();
        remoteControlFerrari.hidupkanMesin();

        remoteControlRB.maju(50);
        remoteControlFerrari.maju(40);

        remoteControlFerrari.Posisi(RedBull);
        remoteControlRB.Posisi(Ferrari);

        remoteControlFerrari.maju(60);
        remoteControlRB.Posisi(Ferrari);

        remoteControlRB.maju(100);
        remoteControlRB.cekJarak();

        remoteControlFerrari.mundur(100);
        remoteControlFerrari.rem();
        remoteControlFerrari.matikanMesin();

        remoteControlFerrari.Posisi(RedBull);

    }
}
