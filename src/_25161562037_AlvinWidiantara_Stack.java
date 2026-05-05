public class _25161562037_AlvinWidiantara_Stack {

    // === BAGIAN 1: Deklarasi Stack ===
    static String[] stack = new String[10];
    static int top = -1;

    // === BAGIAN 2: Operasi Stack ===

    // Method push() - menambahkan tiket ke atas stack
    static void push(String tiket) {
        if (top == stack.length - 1) {
            // Cek overflow: stack sudah penuh
            System.out.println("Stack penuh!");
        } else {
            top++;
            stack[top] = tiket;
        }
    }

    // Method pop() - menghapus dan mengembalikan tiket teratas
    static String pop() {
        if (isEmpty()) {
            // Cek underflow: stack kosong
            return "Stack kosong!";
        } else {
            String tiketTeratas = stack[top];
            stack[top] = null; // bersihkan slot
            top--;
            return tiketTeratas;
        }
    }

    // Method peek() - melihat tiket teratas tanpa menghapus
    static String peek() {
        if (isEmpty()) {
            return "Stack kosong";
        } else {
            return stack[top];
        }
    }

    // Method isEmpty() - mengecek apakah stack kosong
    static boolean isEmpty() {
        return top == -1;
    }

    // Method tampilkanStack() - menampilkan seluruh isi stack
    static void tampilkanStack() {
        System.out.println("=== Isi Stack (TOP -> BOTTOM) ===");
        for (int i = top; i >= 0; i--) {
            System.out.println("| " + stack[i] + " |");
        }
        System.out.println("=================================");
    }

    // === BONUS: Method hitungTotal() ===
    // Menelusuri stack dan menjumlahkan semua harga tiket
    static void hitungTotal() {
        int total = 0;
        for (int i = 0; i <= top; i++) {
            // Ambil bagian harga dari string tiket, contoh: "Rp50.000"
            String[] bagian = stack[i].split("Rp");
            if (bagian.length > 1) {
                // Hapus titik dan parse angkanya
                String angka = bagian[1].replace(".", "").trim();
                total += Integer.parseInt(angka);
            }
        }
        // Format output dengan titik ribuan
        System.out.println("Total transaksi: Rp" + String.format("%,d", total).replace(",", "."));
    }

    // === BAGIAN 3: Main Program ===
    public static void main(String[] args) {

        // Push 3 transaksi ke dalam stack
        push("Tiket-A01: Avengers Rp50.000");
        push("Tiket-B02: Interstellar Rp45.000");
        push("Tiket-C03: Inception Rp45.000");

        // Tampilkan seluruh isi stack
        tampilkanStack();

        // Tampilkan tiket paling atas (peek)
        System.out.println("Tiket terakhir masuk: " + peek());

        // BONUS: Hitung total transaksi
        // Tampilkan total
        hitungTotal();

        // Batalkan 1 transaksi teratas (pop) dan tampilkan
        System.out.println("Tiket dibatalkan: " + pop());

        // Tampilkan isi stack setelah pop
        tampilkanStack();
    }
}
