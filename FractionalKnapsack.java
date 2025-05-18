// import java.util.ArrayList;
// import java.util.Scanner;

// public class Knapsack {

//     // Recursive function to solve 0/1 Knapsack and track items
//     static int knapsack(int[] weights, int[] values, int capacity, int n, ArrayList<Integer> takenItems) {
//         if (n == 0 || capacity == 0) {
//             return 0;
//         }

//         if (weights[n-1] > capacity) {
//             return knapsack(weights, values, capacity, n-1, takenItems);
//         } else {
//             ArrayList<Integer> includeList = new ArrayList<>(takenItems);
//             ArrayList<Integer> excludeList = new ArrayList<>(takenItems);

//             // Include current item
//             includeList.add(weights[n-1]);
//             int include = values[n-1] + knapsack(weights, values, capacity - weights[n-1], n-1, includeList);

//             // Exclude current item
//             int exclude = knapsack(weights, values, capacity, n-1, excludeList);

//             // Choose better option
//             if (include > exclude) {
//                 takenItems.clear();
//                 takenItems.addAll(includeList);
//                 return include;
//             } else {
//                 takenItems.clear();
//                 takenItems.addAll(excludeList);
//                 return exclude;
//             }
//         }
//     }

//     public static void main(String[] args) {
//         Scanner sc = new Scanner(System.in);

//         System.out.print("Enter number of items: ");
//         int n = sc.nextInt();

//         int[] weights = new int[n];
//         int[] values = new int[n];

//         System.out.println("Enter weights of items:");
//         for (int i = 0; i < n; i++) {
//             weights[i] = sc.nextInt();
//         }

//         System.out.println("Enter values of items:");
//         for (int i = 0; i < n; i++) {
//             values[i] = sc.nextInt();
//         }

//         System.out.print("Enter knapsack capacity: ");
//         int capacity = sc.nextInt();

//         ArrayList<Integer> takenItems = new ArrayList<>();
//         int maxProfit = knapsack(weights, values, capacity, n, takenItems);

//         System.out.println("Maximum value that can be obtained: " + maxProfit);
//         System.out.println("Weights taken in knapsack: " + takenItems);

//         sc.close();
//     }
// }
//fractional knapsack
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class FractionalKnapsack {

    // Item class representing weight and value
    static class Item {
        int weight;
        int value;

        Item(int value, int weight) {
            this.value = value;
            this.weight = weight;
        }
    }

    // Comparator to sort items by value/weight ratio
    static class ItemComparator implements Comparator<Item> {
        public int compare(Item a, Item b) {
            double r1 = (double) a.value / a.weight;
            double r2 = (double) b.value / b.weight;
            return Double.compare(r2, r1);  // descending
        }
    }

    public static double getMaxValue(Item[] items, int capacity) {
        Arrays.sort(items, new ItemComparator());

        double totalValue = 0.0;

        for (Item item : items) {
            if (capacity == 0) break;

            if (item.weight <= capacity) {
                totalValue += item.value;
                capacity -= item.weight;
            } else {
                double fraction = (double) capacity / item.weight;
                totalValue += item.value * fraction;
                capacity = 0;
            }
        }

        return totalValue;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Take input from user
        System.out.print("Enter number of items: ");
        int n = scanner.nextInt();

        Item[] items = new Item[n];

        for (int i = 0; i < n; i++) {
            System.out.print("Enter value of item " + (i + 1) + ": ");
            int value = scanner.nextInt();

            System.out.print("Enter weight of item " + (i + 1) + ": ");
            int weight = scanner.nextInt();

            items[i] = new Item(value, weight);
        }

        System.out.print("Enter capacity of knapsack: ");
        int capacity = scanner.nextInt();

        double maxValue = getMaxValue(items, capacity);
        System.out.printf("Maximum value in knapsack = %.2f\n", maxValue);

        scanner.close();
    }
}
