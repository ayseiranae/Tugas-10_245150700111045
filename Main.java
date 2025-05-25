import java.util.*;

class Pemain {
    int tinggi;
    int berat;

    Pemain(int tinggi, int berat) {
        this.tinggi = tinggi;
        this.berat = berat;
    }

    @Override
    public String toString() {
        return "Tinggi: " + tinggi + " cm, Berat: " + berat + " kg";
    }
}

public class Main {
    public static void main(String[] args) {
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

        // --- a) Binary Search: tinggi 168 dan 160 di Tim B
        List<Integer> tinggiB = new ArrayList<>();
        for (Pemain p : timB) tinggiB.add(p.tinggi);
        Collections.sort(tinggiB);

        System.out.println("Tinggi 168 di Tim B: " + countOccurrences(tinggiB, 168));
        System.out.println("Tinggi 160 di Tim B: " + countOccurrences(tinggiB, 160));

        // --- b) Binary Search: berat 56 dan 53 di Tim A
        List<Integer> beratA = new ArrayList<>();
        for (Pemain p : timA) beratA.add(p.berat);
        Collections.sort(beratA);

        System.out.println("Berat 56 di Tim A: " + countOccurrences(beratA, 56));
        System.out.println("Berat 53 di Tim A: " + countOccurrences(beratA, 53));

        // --- c) Cek apakah ada tinggi atau berat yang sama antara Tim A dan Tim B
        Set<Integer> tinggiASet = new HashSet<>();
        Set<Integer> beratASet = new HashSet<>();
        for (Pemain p : timA) {
            tinggiASet.add(p.tinggi);
            beratASet.add(p.berat);
        }

        boolean adaTinggiSama = false, adaBeratSama = false;
        for (Pemain p : timB) {
            if (tinggiASet.contains(p.tinggi)) adaTinggiSama = true;
            if (beratASet.contains(p.berat)) adaBeratSama = true;
        }

        System.out.println("Ada tinggi badan yang sama antara Tim A dan Tim B? " + adaTinggiSama);
        System.out.println("Ada berat badan yang sama antara Tim A dan Tim B? " + adaBeratSama);
    }

    // Binary Search + count kemunculan
    public static int countOccurrences(List<Integer> sortedList, int target) {
        int count = 0;
        for (int i = 0; i < sortedList.size(); i++) {
            if (sortedList.get(i) == target) count++;
        }
        return count;
    }
}
