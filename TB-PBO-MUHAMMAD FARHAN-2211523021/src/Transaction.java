import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;
import java.util.HashMap;

// Merepresentasikan transaksi pembelian kue
public class Transaction implements Bakery {
    Integer idPelanggan;
    Integer noKue;
    String tanggal;
    int inputrasa;
    int noDekor;
    public static int metode;
    static String jenisKue;
    static String rasa;
    static String selai;
    static String hias;
    static int biaya1, totalHarga, cash, kembalian;
    static String metod;

    static Scanner input = new Scanner(System.in);
    static Scanner data = new Scanner(System.in);

    public void NamaPelanggan() {
        System.out.print("Nama Pelanggan : ");
    }

    public void Kue() {
        String[] jenis = { "Kue Ulang Tahun", "CupCake", "Kue Bolu", "Donat"};
        String temp;

        //jenis kue
        System.err.println("\n            TOKO KUE         ");
        System.err.println("-----------------------------");

        //perulangan for
        for (int i = 0; i < (jenis.length - 1); i++) {
            for (int j = 0; j < (jenis.length - 1); j++) {
                if (jenis[j].compareTo(jenis[j + 1]) > 0) {
                    temp = jenis[j + 1];
                    jenis[j + 1] = jenis[j];
                    jenis[j] = temp;
                }
            }
        }
        for (int i = 0; i <jenis.length; i++) {
            System.err.println(i + 1 + " " + jenis[i]);
        }
        System.out.print("Masukkan Kue : ");
        noKue = input.nextInt();
        input.nextLine();

        //percabangan
        if (this.noKue == 1) {
            jenisKue = "Kue Ulang Tahun";
        } else if (this.noKue == 2) {
            jenisKue = "CupCake";
        } else if (this.noKue == 3) {
            jenisKue = "Kue Bolu";
        } else if (this.noKue == 4) {
            jenisKue = "Donat";
        }
    }

    public void flavor() {
        // objek hashmap dan collection framework
        HashMap<Integer, String> selai = new HashMap<Integer, String>();
        selai.put(1, "Coklat");
        selai.put(2, "Vanila");
        selai.put(3, "Stroberi");

        System.out.println("\n          RASA KUE   ");
        System.out.println("----------------------");
        System.out.println(selai);
        System.out.println("Pilih Rasa Kue : ");
        inputrasa = input.nextInt();
        input.nextLine();

        //percabangan
        if (inputrasa == 1) {
            rasa = "Coklat";
        } else if (inputrasa == 2) {
            rasa = "Vanila";
        } else if (inputrasa == 3) {
            rasa = "Stroberi";
        } else {
            System.out.println("Nomor Salah!");
            System.out.print("Pilih Nomor Rasa yang diinginkan : ");
            inputrasa = input.nextInt();
            input.nextLine();
        }
    }
    public void dekor() {
        System.out.println("           DEKORASI KUE   ");
        System.out.println("------------------------");
        System.out.println(" 1. Iya, dekorasi kue");
        System.out.println(" 2. Tidak perlu dekorasi kue");
        System.out.print("\n Pilih keinginan dekorasi kue : ");
        noDekor = input.nextInt();
        input.nextLine();

        //percabangan if
        if (noDekor == 1) {
            hias = "Iya, dekorasi kue";
        } else if (noDekor == 2) {
            hias = "Tidak perlu dekorasi kue";
        } else {
            System.out.println("Nomor Salah!");
            System.out.print("\n Pilih keinginan dekorasi kue : ");
            noDekor = input.nextInt();
            input.nextLine();
        }
    }
    public void uang() {
        int harga[][][] = { { { 20000, 400000 }, { 50000, 1000000 }, { 30000, 600000} }, 
        { { 50000, 900000 }, { 12000, 240000 }, { 53000, 200000 } }, 
        { { 80000, 160000 }, { 20000, 450000 }, { 85000, 230000 } },
        { { 70000, 150000 }, { 55000, 360000 }, { 18000, 300000 } } };

        //percabangan
        if ((noKue == 1) && (inputrasa == 1) && (noDekor == 1)) 
        {
            biaya1 = harga[0][0][0];
        } else if ((noKue == 1) && (inputrasa == 1) && (noDekor == 2))
        {
            biaya1 = harga[0][0][1];
        } else if ((noKue == 1) && (inputrasa == 2) && (noDekor == 1))
        {
            biaya1 = harga[0][1][0];
        } else if ((noKue == 1) && (inputrasa == 2) && (noDekor == 2))
        {
            biaya1 = harga[0][1][1];
        } else if ((noKue == 1) && (inputrasa == 3) && (noDekor == 1))
        {
            biaya1 = harga[0][2][0];
        } else if ((noKue == 1) && (inputrasa == 3) && (noDekor == 2))
        {
            biaya1 = harga[0][2][1];
        } else if ((noKue == 2) && (inputrasa == 1) && (noDekor == 1))
        {
            biaya1 = harga[1][0][0];
        } else if ((noKue == 2) && (inputrasa == 1) && (noDekor == 2))
        {
            biaya1 = harga[1][0][1];
        } else if ((noKue == 2) && (inputrasa == 2) && (noDekor == 1))
        {
            biaya1 = harga[1][1][0];
        } else if ((noKue == 2) && (inputrasa ==2) && (noDekor == 2))
        {
            biaya1 = harga[1][1][1];
        } else if ((noKue == 2) && (inputrasa == 3) && (noDekor == 1))
        {
            biaya1 = harga[1][2][0];
        } else if ((noKue == 2) && (inputrasa == 3) && (noDekor == 2))
        {
            biaya1 = harga[1][2][1];
        } else if ((noKue == 3) && (inputrasa == 1) && (noDekor == 1))
        {
            biaya1 = harga[2][0][0];
        } else if ((noKue == 3) && (inputrasa == 1) && (noDekor == 2))
        {
            biaya1 = harga[2][0][1];
        } else if ((noKue == 3) && (inputrasa == 2) && (noDekor == 1))
        {
            biaya1 = harga[2][1][0];
        } else if ((noKue == 3) && (inputrasa == 2) && (noDekor == 2))
        {
            biaya1 = harga[2][1][1];
        } else if ((noKue == 3) && (inputrasa == 3) && (noDekor == 1))
        {
            biaya1 = harga[2][2][0];
        } else if ((noKue == 3) && (inputrasa == 3) && (noDekor == 2))
        {
            biaya1 = harga[2][2][1];
        } else if ((noKue == 4) && (inputrasa == 1) && (noDekor == 1))
        {
            biaya1 = harga[3][0][0];
        } else if ((noKue == 4) && (inputrasa == 1) && (noDekor == 2))
        {
            biaya1 = harga[3][0][1];
        } else if ((noKue == 4) && (inputrasa == 2) && (noDekor == 1))
        {
            biaya1 = harga[3][1][0];
        } else if ((noKue == 4) && (inputrasa == 2) && (noDekor == 2))
        {
            biaya1 = harga[3][1][1];
        } else if ((noKue == 4) && (inputrasa == 3) && (noDekor == 1))
        {
            biaya1 = harga[3][2][0];
        } else if ((noKue == 4) && (inputrasa == 3) && (noDekor == 2))
        {
            biaya1 = harga[3][2][1];
        } 
        System.out.print("Total Harga : Rp. " + biaya1);
        System.out.println("");
    }
    // String and Date
    public String Tanggal() {
        LocalDate date = LocalDate.now();
        DateTimeFormatter frmt = DateTimeFormatter.ofPattern("dd MMMM yyyy");
        this.tanggal = date.format(frmt);
        return this.tanggal;
    }
    @Override
    public void bayar() {
        
    }
}
