import java.util.InputMismatchException;
import java.util.Scanner;
import java.sql.*;

//inheritance
public class App extends Transaction{
    static Connection connect;
    public static void main(String[] args) {
        //CRUD
        try (Scanner input = new Scanner(System.in)) {
            boolean lanjut = true;
            String pilih;

            String url = "jdbc:mysql://localhost:3306/bakery";
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
                connect = DriverManager.getConnection(url, "root", "");
                System.out.println("Koneksi Berhasil");
                System.out.println("\n^_^ SELAMAT DI TOKO KUE ELI(ENAK SEKALI)^_^\n");

                while (lanjut) {
                    System.out.println("PILIH OPERASI TOKO KUE");
                    System.out.println("------------------------");
                    System.out.println(" 1. Tampilkan Data Pelanggan");
                    System.out.println(" 2. Masukkan Data Pelanggan");
                    System.out.println(" 3. Ubah Data Pelanggan");
                    System.out.println(" 4. Hapus Data Pelanggan");
                    System.out.println(" 5. Cari Data Pelanggan");

                    System.out.print("\nPilih Nomor (1/2/3/4/5) : ");
                    pilih = input.next();
                    input.nextLine();

                    switch (pilih) {
                        case "1":
                            read();
                            break;
                        case "2":
                            create();
                            break;
                        case "3":
                            update();
                            break;
                        case "4":
                            delete();
                            break;
                        case "5":
                            search();
                            break;
                    
                        default:
                            System.err.println("\nTerjadi Kesalahan Pemimlihan\npilih no 1-5");
                    }
                    System.out.print("\nLanjutkan Operasi? (y/n)");
                    pilih = input.next();
                    input.nextLine();
                    lanjut = pilih.equalsIgnoreCase("y");
                }
                //exception
            } catch (ClassNotFoundException ex) {
                System.err.println("\nError\n");
                System.exit(0);
            } catch (SQLException e) {
                System.err.println("Tidak Ada Koneksi");
            }
        }
    }

    private static void read() throws SQLException {
        String text1 = "\nData Pelanggan Toko Kue Eli";
        System.out.println(text1.toUpperCase());
        System.out.println("----------------------------");

        String sql = "SELECT * FROM data_pelanggan";
        Statement statement = connect.createStatement();
        ResultSet result = statement.executeQuery(sql);

        while (result.next()) {
            System.out.print("\nTanggal Pembelian\t: ");
            System.out.print(result.getString("tanggal"));
            System.out.print("\nId Pelanggan\t\t: ");
            System.out.print(result.getString("id_pelanggan"));
            System.out.print("\nNama Pelanggan\t\t: ");
            System.out.print(result.getString("nama_pelanggan"));
            System.out.print("\nJenis Kue\t\t: ");
            System.out.print(result.getString("jenis_kue"));
            System.out.print("\nRasa Kue\t\t\t: ");
            System.out.print(result.getString("rasa"));
            System.out.print("\nDekorasi Kue\t\t\t: ");
            System.out.print(result.getString("dekorasi"));
            System.out.print("\nMetode Pembayaran\t: ");
            System.out.print(result.getString("pembayaran"));
            System.out.print("\nTotal Harga\t: ");
            System.out.print(result.getString("total_harga"));
            System.out.print("\n");
        }
    }
    private static void create() throws SQLException {
        String text2 = "\nMasukkan Data Pelanggan";
        System.out.println(text2.toUpperCase());
        System.out.println("-----------------------");

        try {
            Transaction trans = new Transaction();
            trans.NamaPelanggan();
            String namaPelanggan = input.nextLine();
            trans.Tanggal();
            String tanggal = trans.tanggal;
            trans.Kue();
            trans.flavor();
            trans.dekor();
            trans.uang();

            Payment biaya = new Payment(biaya1);
            biaya.bayar();
            Integer.toString(biaya1);

            String sql = "INSERT INTO data_pelanggan (tanggal, nama_pelanggan, jenis_kue, rasa, dekorasi, pembayaran, total_harga) VALUES ('"
             + tanggal + "','" + namaPelanggan + "','" + jenisKue + "','" + rasa + "','" + hias + "','" + metod + "','" + totalHarga + "')";

            Statement statement = connect.createStatement();
            statement.execute(sql);
            System.out.println("\nBerhasil Input Data");
        } catch (SQLException e) {
            System.err.println("\nKesalahan Input");
        } catch (InputMismatchException e) {
            System.err.println("\nInput Angka!");
        }
    }
    private static void update() throws SQLException {
        String text3 = "\nUbah Data Pelanggan";
        System.out.println(text3.toUpperCase());
        System.out.println("----------------");

        try {
            try {
                read();
                {
                    System.out.print("\nMasukkan Id Pelanggan yang akan diubah : ");
                    Integer idpelanggan = Integer.parseInt(data.nextLine());
                    String sql = "SELECT * FROM data_pelanggan WHERE id_pelanggan = " + idpelanggan;
                    Statement statement = connect.createStatement();
                    ResultSet result = statement.executeQuery(sql);

                    if (result.next()) {
                        System.out.print("\nNama Pelanggan [" + result.getString("nama_pelanggan") + "]\t: ");
                        String namaPelanggan = data.nextLine();

                        Transaction trans = new Transaction();
                        trans.Tanggal();
                        String tanggal = trans.tanggal;
                        trans.Kue();
                        trans.flavor();
                        trans.dekor();
                        trans.uang();
                        Payment biaya = new Payment(biaya1);
                        biaya.bayar();
                        Integer.toString(biaya1);

                        sql = "UPDATE data_pelanggan SET tanggal='" + tanggal + "', nama_pelanggan='" + namaPelanggan + "', jenis_kue='" + jenisKue + "', rasa='" + rasa + "', dekorasi='" + hias + "', pembayaran='" + metod + "', total_harga='" + totalHarga + "' WHERE id_pelanggan='" + idpelanggan + "'";

                        if (statement.executeUpdate(sql) > 0) {
                            System.out.println("\nData Pelanggan Sudah Diperbarui (id_pelanggan " + idpelanggan + ")");
                        }
                    }
                    statement.close();
                }
            } catch (SQLException e) {
                System.err.println("\nTerjadi Kesalahan");
                System.err.println(e.getMessage());
            }
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
    }
    private static void delete() {
        String text4 = "\nHapus Data Pelanggan";
        System.out.println(text4.toUpperCase());
        System.out.println("-------------------");

        try {
            try {
                read();
                System.out.print("\nPilih Id Pelanggan yang akan dihapus : ");
                Integer idpelanggan = Integer.parseInt(data.nextLine());

                String sql = "DELETE FROM data_pelanggan WHERE id_pelanggan = " + idpelanggan;
                Statement statement = connect.createStatement();

                if (statement.executeUpdate(sql) > 0) {
                    System.out.println("\nData Pembeli Telah dihapus (ID pelanggan " + idpelanggan + ")");
                }
            } catch (SQLException e) {
                System.out.println("\nTerjadi Kesalahan!");
            }
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
    }
    private static void search() throws SQLException {
        String text5 = "\nCari Data Pelanggan";
        System.out.println(text5.toUpperCase());
        System.out.println("--------------------");

        System.out.print("\nMasukkan Nama Pelanggan : ");
        String key = data.nextLine();
        Statement statement = connect.createStatement();
        String sql = "SELECT * FROM data_pelanggan WHERE nama_pelanggan LIKE '%" + key + "%'";
        ResultSet result = statement.executeQuery(sql);

        while (result.next()) {
            System.out.print("\nTanggal Transaksi\t: ");
            System.out.print(result.getString("tanggal"));
            System.out.print("\nId Pelanggan\t\t: ");
            System.out.print(result.getString("id_pelanggan"));
            System.out.print("\nNama Pelanggan\t\t: ");
            System.out.print(result.getString("nama_pelanggan"));
            System.out.print("\nJenis Kue\t\t: ");
            System.out.print(result.getString("jenis_kue"));
            System.out.print("\nRasa\t\t\t: ");
            System.out.print(result.getString("rasa"));
            System.out.print("\nDekorasi Kue\t\t\t: ");
            System.out.print(result.getString("dekorasi"));
            System.out.print("\nMetode Pembayaran\t: ");
            System.out.print(result.getString("pembayaran"));
            System.out.print("\nTotal Harga\t: ");
            System.out.print(result.getString("total_harga"));
            System.out.print("\n");
        }
    }
}
