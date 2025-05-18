// import java.util.Arrays;
// import java.util.Comparator;



// public class ActivitySelection {

//     // Activity class to store start, finish times, and index
//     static class Activity {
//         int start, finish, index;

//         Activity(int start, int finish, int index) {
//             this.start = start;
//             this.finish = finish;
//             this.index = index;
//         }

//         // Method to count the total number of activities
//         static int countActivities(Activity[] activities) {
//             return activities.length;
//         }
//     }

//     // Function to perform activity selection
//     public static void selectActivities(Activity[] activities) {
//         // Sort activities based on their finish times
//         Arrays.sort(activities, Comparator.comparingInt(a -> a.finish));

//         System.out.println("Selected activities:");

//         // The first activity is always selected
//         int lastFinishTime = activities[0].finish;
//         System.out.println("Activity: Index " + activities[0].index + 
//         " (" + activities[0].start + ", " + activities[0].finish + ")");
//     int count=0;
//         // Iterate through the rest of the activities
//         for (int i = 1; i < activities.length; i++) {
//             if (activities[i].start >= lastFinishTime) {
//                 System.out.println("Activity: Index " + activities[i].index + 
//                 " (" + activities[i].start + ", " + activities[i].finish + ")");
//                 lastFinishTime = activities[i].finish;
//                 count++;
                
//             }
//         }
//         System.out.println(count);
//     }

//     public static void main(String[] args) {
//         // Example activities
//         Activity[] activities = {
//             new Activity(1, 3, 0),
//             new Activity(2, 5, 1),
//             new Activity(4, 6, 2),
//             new Activity(6, 7, 3),
//             new Activity(5, 9, 4),
//             new Activity(8, 9, 5)
//         };

//         selectActivities(activities);
//     }
// }
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class ActivitySelection {

    
    static class Activity {
        int start, finish, index;

        Activity(int start, int finish, int index) {
            this.start = start;
            this.finish = finish;
            this.index = index;
        }

        
        static int countActivities(Activity[] activities) {
            return activities.length;
        }
    }

   
    public static void selectActivities(Activity[] activities) {
       
        Arrays.sort(activities, Comparator.comparingInt(a -> a.finish));

        System.out.println("Selected activities:");

        
        int lastFinishTime = activities[0].finish;
        System.out.println("Activity: Index " + activities[0].index + 
        " (" + activities[0].start + ", " + activities[0].finish + ")");
        int count = 1;

       
        for (int i = 1; i < activities.length; i++) {
            if (activities[i].start >= lastFinishTime) {
                System.out.println("Activity: Index " + activities[i].index + 
                " (" + activities[i].start + ", " + activities[i].finish + ")");
                lastFinishTime = activities[i].finish;
                count++;
            }
        }
        System.out.println("Total activities selected: " + count);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter number of activities: ");
        int n = scanner.nextInt();

        Activity[] activities = new Activity[n];

        for (int i = 0; i < n; i++) {
            System.out.print("Enter start time of activity " + i + ": ");
            int start = scanner.nextInt();
            System.out.print("Enter finish time of activity " + i + ": ");
            int finish = scanner.nextInt();
            activities[i] = new Activity(start, finish, i);
        }

        selectActivities(activities);

        scanner.close();
    }
}
