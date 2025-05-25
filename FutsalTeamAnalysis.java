import java.util.*;

class Pemain {
    int tinggi, berat;

    Pemain(int tinggi, int berat) {
        this.tinggi = tinggi;
        this.berat = berat;
    }

    @Override
    public String toString() {
        return "Tinggi: " + tinggi + " cm, Berat: " + berat + " kg";
    }
}

public class FutsalTeamAnalysis {
    public static void main(String[] args) {
        // a) Data Tim A dan B
        ArrayList<Pemain> timA = new ArrayList<>(Arrays.asList(
            new Pemain(168, 50), new Pemain(170, 60), new Pemain(165, 56),
            new Pemain(168, 55), new Pemain(172, 60), new Pemain(170, 70),
            new Pemain(169, 66), new Pemain(165, 56), new Pemain(171, 72),
            new Pemain(166, 56)
        ));

        ArrayList<Pemain> timB = new ArrayList<>(Arrays.asList(
            new Pemain(170, 66), new Pemain(167, 60), new Pemain(165, 59),
            new Pemain(166, 58), new Pemain(168, 58), new Pemain(175, 71),
            new Pemain(172, 68), new Pemain(171, 68), new Pemain(168, 65),
            new Pemain(169, 60)
        ));

        ArrayList<Pemain> gabungan = new ArrayList<>();
        gabungan.addAll(timA);
        gabungan.addAll(timB);

        // a. Urut Tinggi Asc & Desc
        gabungan.sort(Comparator.comparingInt(p -> p.tinggi));
        System.out.println("Urut Tinggi Ascending:");
        gabungan.forEach(System.out::println);

        gabungan.sort((p1, p2) -> Integer.compare(p2.tinggi, p1.tinggi));
        System.out.println("\nUrut Tinggi Descending:");
        gabungan.forEach(System.out::println);

        // b. Urut Berat Asc & Desc
        gabungan.sort(Comparator.comparingInt(p -> p.berat));
        System.out.println("\nUrut Berat Ascending:");
        gabungan.forEach(System.out::println);

        gabungan.sort((p1, p2) -> Integer.compare(p2.berat, p1.berat));
        System.out.println("\nUrut Berat Descending:");
        gabungan.forEach(System.out::println);

        // c. Nilai maksimum dan minimum
        findMinMax(timA, "Tim A");
        findMinMax(timB, "Tim B");

        // d. Copy Tim B ke Tim C
        ArrayList<Pemain> timC = new ArrayList<>();
        for (Pemain p : timB) {
            timC.add(new Pemain(p.tinggi, p.berat));
        }

        System.out.println("\nData Tim C (salinan dari Tim B):");
        timC.forEach(System.out::println);

        // 2a. Simpan ke ArrayList (sudah)

        // 2b. Cari tinggi 168 & 160 di Tim B
        List<Integer> tinggiB = new ArrayList<>();
        for (Pemain p : timB) tinggiB.add(p.tinggi);
        Collections.sort(tinggiB);
        System.out.println("\nTinggi 168 di Tim B: " + countOccurrences(tinggiB, 168));
        System.out.println("Tinggi 160 di Tim B: " + countOccurrences(tinggiB, 160));

        // 2c. Cari berat 56 & 53 di Tim A
        List<Integer> beratA = new ArrayList<>();
        for (Pemain p : timA) beratA.add(p.berat);
        Collections.sort(beratA);
        System.out.println("\nBerat 56 di Tim A: " + countOccurrences(beratA, 56));
        System.out.println("Berat 53 di Tim A: " + countOccurrences(beratA, 53));

        // 2d. Cek apakah ada tinggi/berat yang sama di Tim A dan Tim B
        Set<Integer> tinggiASet = new HashSet<>(), beratASet = new HashSet<>();
        for (Pemain p : timA) {
            tinggiASet.add(p.tinggi);
            beratASet.add(p.berat);
        }

        boolean samaTinggi = false, samaBerat = false;
        for (Pemain p : timB) {
            if (tinggiASet.contains(p.tinggi)) samaTinggi = true;
            if (beratASet.contains(p.berat)) samaBerat = true;
        }

        System.out.println("\nAda tinggi sama antara Tim A dan B? " + samaTinggi);
        System.out.println("Ada berat sama antara Tim A dan B? " + samaBerat);
    }

    // Fungsi bantu
    public static void findMinMax(List<Pemain> tim, String nama) {
        int minTinggi = tim.stream().mapToInt(p -> p.tinggi).min().orElse(-1);
        int maxTinggi = tim.stream().mapToInt(p -> p.tinggi).max().orElse(-1);
        int minBerat = tim.stream().mapToInt(p -> p.berat).min().orElse(-1);
        int maxBerat = tim.stream().mapToInt(p -> p.berat).max().orElse(-1);

        System.out.println("\nData " + nama);
        System.out.println("Min Tinggi: " + minTinggi + " cm | Max Tinggi: " + maxTinggi + " cm");
        System.out.println("Min Berat : " + minBerat + " kg | Max Berat : " + maxBerat + " kg");
    }

    public static int countOccurrences(List<Integer> list, int target) {
        return Collections.frequency(list, target);
    }
}
