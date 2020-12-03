import java.util.*;

public class Main {
    public static void main(String[] args) {
        String[] letters = {"A", "B", "E", "K", "M", "H", "O", "P", "C", "T", "Y", "X"};
        ArrayList<String> arrList = new ArrayList<>();
        HashSet<String> hashSet = new HashSet<>();
        TreeSet<String> treeSet = new TreeSet<>();

        for (int R = 1; R <= 199; R++) {
            for (String X : letters) {
                for (String Y : letters) {
                    for (String Z : letters) {
                        for (int N = 1; N <= 9; N++) {
                            String region = Integer.toString(R);
                            if (region.length() == 1) {
                                region = "0" + region;
                            }
                            String number = String.format("%s%d%d%d%s%s%s", X, N, N, N, Y, Z, region);
                            System.out.println(number);
                            arrList.add(number);
                            hashSet.add(number);
                            treeSet.add(number);
                        }
                    }
                }
            }
        }

        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите номер для поиска: ");
        boolean go = true;
        while (go) {
            String str = scanner.nextLine();

            long start = System.nanoTime();
            boolean isFound = arrList.contains(str);
            long duration = System.nanoTime() - start;
            System.out.println("Номер " + (isFound ? "найден" : "не найден") + " перебором" + " за " + duration + "ms.");

            Collections.sort(arrList);
            start = System.nanoTime();
            int res = Collections.binarySearch(arrList, str);
            duration = System.nanoTime() - start;
            System.out.println("Номер " + (res >= 0 ? "найден" : "не найден") + " бинарным поиском за " + duration + "ms.");

            start = System.nanoTime();
            isFound = hashSet.contains(str);
            duration = System.nanoTime() - start;
            System.out.println("Номер " + (isFound ? "найден" : "не найден") + " в HashSet за " + duration + "ms.");

            start = System.nanoTime();
            isFound = treeSet.contains(str);
            duration = System.nanoTime() - start;
            System.out.println("Номер " + (isFound ? "найден" : "не найден") + "в TreeSet за " + duration + "ms.");
        }
    }
}
