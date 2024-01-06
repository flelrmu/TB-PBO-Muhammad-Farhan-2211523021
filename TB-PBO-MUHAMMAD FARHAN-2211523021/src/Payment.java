import java.util.InputMismatchException;

public class Payment extends Transaction {
    public int biaya1;

    //construktor
    public Payment(int biaya1) {
        this.biaya1 = biaya1;
    }
    @Override
    public void bayar() {
        System.out.println("   METODE PEMBAYARAN   ");
        System.out.println("-----------------------");
        System.out.println(" 1. Cash");
        System.out.println(" 2. Transfer");
        System.out.print(" Pilih Metode Pembayaran : ");
        metode = input.nextInt();

        if (metode == 1) {
            metod = "Cash";
            totalHarga = biaya1;
            System.out.print("Total Harga : Rp. " + totalHarga);
            System.out.println("");
            System.out.print("Cash : Rp. ");
            cash = input.nextInt();
            System.out.println("");
        } else if (metode == 2) {
            metod = "Transfer";
            totalHarga = biaya1;
            System.out.print("Total Harga : Rp. " + totalHarga);

            if (totalHarga > cash) {
                System.out.println("Uang Kurang!");
                System.out.print("\nMasukkan Uang : ");
                cash = input.nextInt();
                input.nextLine();
                System.out.println("");

                kembalian = cash - totalHarga;
                System.out.println("Kembalian : Rp. " + kembalian);
                System.out.println("");
            } else {
                kembalian = cash - totalHarga;
                System.out.println("Kembalian : Rp. " + kembalian);
                System.out.println("");
            }
        } else {
            System.out.println("Pilih Metode Pembayaran (1/2)");
            System.out.print("\nPilih Metode Pembayaran (1/2) : ");
            metode = input.nextInt();
        }
    }
    @Override
    public void dekor() {
        boolean kondisi = true;
        do {
            try {
                if (inputrasa <= 0 || inputrasa > 3)
                throw new Exception();
                kondisi = false;
            } catch (InputMismatchException e) {
                System.out.print("Input Salah! Masukkan dalam Angka" + "\n");
                input.nextLine();
            } catch (Exception e) {
                System.out.print("Input Salah! Masukkan dalam Angka (1/2)" + "\n");
                input.nextLine();
            } finally {
                System.out.print("berhasil!" + "\n");
            }
        } while (kondisi);
    }
}
