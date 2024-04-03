//Dimas Rezananda
//235150700111036
//LK02

import java.util.Scanner;

class driver {
    public String no_sim;
    String nama;

    public driver(String nama, String no_sim) {
        this.nama = nama;
        this.no_sim = no_sim;
        System.out.println("Nama Supir              :" + this.nama + "\nNomor SIM               :" + this.no_sim);
    }
}

class Penumpang {
    public String nama;
    public int umur;

    public Penumpang(String nama, int umur) {
        this.nama = nama;
        this.umur = umur;
    }
}

class kendaraan {
    public String merk;
    public String warna;
    public String platNomor;
    public int jumlahPenumpang;
    public int maxPenumpang;
    public driver supir;

    public kendaraan(String pn, String m, int max) {
        this.merk = m;
        this.platNomor = pn;
        this.jumlahPenumpang = 0;
        this.maxPenumpang = max;

        System.out.println("Plat Nomor              : " + this.platNomor + "\nMerk                    : " + this.merk + "\nMaksimal Penumpang      : " + this.maxPenumpang);
        cekPenumpang();
    }

    public void cekPenumpang() {
        System.out.println("Penumpang saat ini      : " + this.jumlahPenumpang);
    }

    public void penumpangNaik(int naik) {
        System.out.println("Ada penumpang mau naik: " + naik);
        int current = this.jumlahPenumpang;
        if (current + naik > this.maxPenumpang) {
            System.out.println("Maaf penumpang yang mau naik melebihi kapasitas");
        } else {
            this.jumlahPenumpang += naik;
            System.out.println("YEAY penumpang berhasil naik");
        }
        cekPenumpang();
    }

    public void penumpangTurun(int turun) {
        System.out.println("Ada penumpang mau turun: " + turun);
        int current = this.jumlahPenumpang;
        if (current - turun < 0) {
            System.out.println("Maaf penumpang ghoib yang turun");
        } else {
            this.jumlahPenumpang -= turun;
            System.out.println("YEAY penumpang berhasil turun");
        }
        cekPenumpang();
    }

    public void maju() {
        System.out.println(this.merk + " " + this.platNomor + " Maju");
    }

    public void mundur() {
        System.out.println(this.merk + " " + this.platNomor + " Mundur");
    }

    public void belok() {
        System.out.println(this.merk + " " + this.platNomor + " Belok");
    }

    public void berhenti() {
        System.out.println(this.merk + " " + this.platNomor + " Berhenti");
    }

    public void showSIM() {
        if (this.supir != null) {
        } else {
            System.out.println("Tidak ada supir yang terdaftar");
        }
    }
}


class truk extends kendaraan {
    int kapasitasMuatan;

    public truk(String pn, String m, int max) {
        super(pn, m, max);
    }

    public void setKapasitas(int kapasitas) {
        this.kapasitasMuatan = kapasitas;
        System.out.println("Kapasitas muatan truk ini " + this.kapasitasMuatan + " ton.");
    }
}

class bus extends kendaraan {
    boolean isToilet;

    public bus(String pn, String m, int max) {
        super(pn, m, max);
    }

    public void telolet() {
        System.out.println("Bus ini memiliki klakson telolet");
    }

    public void setToilet(boolean toilet) {
        if (toilet == true) {
            System.out.println("Bus ini memiliki fasilitas toilet");
        }
        else {
            System.out.println("Bus ini tidak dilengkapi dengan toilet");
        }
    }
}

    public class Kendaraanku {
        public static void main(String[] args) {
            System.out.println("Jenis Kendaraan         : Truk");
            truk t1 = new truk("D 1616 IT", "MERCEDES BENZ", 4);
            driver s1 = new driver(" Arthur Morgan", " 3278012301850912");
            s1.no_sim = "123456";
            t1.supir = s1;
            t1.showSIM();
            t1.setKapasitas(10);
            System.out.println(" ");
    
            System.out.println("Jenis Kendaraan         : Bus");
            bus b1 = new bus("D 14 RE", "YUTONG", 40);
            driver s2 = new driver(" Bill Williamson", " 3278012301850913");
            s2.no_sim = "789101";
            b1.supir = s2;
            b1.showSIM();
            b1.setToilet(true);
            b1.telolet();
            System.out.println(" ");
    
            Scanner scanner = new Scanner(System.in);
            int pilihanKendaraan = 0;
            while (pilihanKendaraan != 3) {
                // KENDARAAN YG INGIN DINAIKI
                System.out.println("Pilih kendaraan yang Anda mau:");
                System.out.println("1. Truk");
                System.out.println("2. Bus");
                System.out.println("3. Tidak jadi naik");
    
                System.out.print("Pilih kendaraan (masukkan angka): ");
                pilihanKendaraan = scanner.nextInt();
    
                switch (pilihanKendaraan) {
                    case 1:
                        System.out.println("Anda telah memilih Truk");
                        menuKendaraan(t1, scanner);
                        break;
                    case 2:
                        System.out.println("Anda telah memilih Bus");
                        menuKendaraan(b1, scanner);
                        break;
                    case 3:
                        System.out.println("Terima kasih. Program berhenti.");
                        System.exit(0);
                    default:
                        System.out.println("Pilihan tidak valid. Silakan pilih antara 1-3.");
                        continue;
                }
            }
        }
    
        public static void menuKendaraan(kendaraan kendaraan, Scanner scanner) {
            int pilihanMenu = 0;
            while (pilihanMenu != 4) {
                // MENU
                System.out.println("Tolong pilih menu berikut :");
                System.out.println("1. Naik");
                System.out.println("2. Turun");
                System.out.println("3. Cek Penumpang");
                System.out.println("4. Keluar Program");
    
                // INPUT
                System.out.print("Pilih menu (masukkan angka): ");
                pilihanMenu = scanner.nextInt();
        
        // PILIH MENU
        switch (pilihanMenu) {
            case 1:
                System.out.println("Berapa jumlah penumpang naik?");
                System.out.print("(masukkan angka): ");
                int naik = scanner.nextInt();
                kendaraan.penumpangNaik(naik);
                break;
            case 2:
                System.out.println("Berapa jumlah penumpang turun?");
                System.out.print("(masukkan angka): ");
                int turun = scanner.nextInt();
                kendaraan.penumpangTurun(turun);
                break;
            case 3:
                kendaraan.cekPenumpang();
                break;
            case 4:
                System.out.println("Terima kasih. Program berhenti.");
                System.exit(0);
            default:
                System.out.println("Pilihan tidak valid. Silakan pilih antara 1-4.");
        }
        }    
        scanner.close();
    }
}