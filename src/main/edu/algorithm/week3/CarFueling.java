package main.edu.algorithm.week3;

import java.util.*;
import java.io.*;

public class CarFueling {
    static int computeMinRefills(int dist, int tank, int[] stops) {
        int stopCount = 0;
        if (dist<= tank)
            return stopCount ;

        for (int i = 0; i <stops.length ; ) {
            int initial = i;
            // check reach to end station
            if (i== stops.length-1 ) {
                if (stops[i]+tank>=dist)
                    return stopCount;
                else
                    return -1;
            }
            int j = i+1;
            //loop until maximum station to fuel refill found from current station
            while (j<stops.length && stops[j]-stops[i]<=tank){
                j++;
            }
            //if distance from current station next station is larger than
            // capacity of the tank return -1
            if (j== initial+1)
                return -1;
            //after refill from current station if we can go to destination without
            //refill again return number of stop stations cpunt
            if (stops[i]+tank>=dist)
                return stopCount;
            //set i to current station
            i=j-1;
            stopCount++;
        }
        return stopCount;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int dist = scanner.nextInt();
        int tank = scanner.nextInt();
        int n = scanner.nextInt();
        int[] stops = new int[n+1];
        stops[0] = 0;
        for (int i = 1; i < n+1; i++) {
            stops[i] = scanner.nextInt();
        }

        System.out.println(computeMinRefills(dist, tank, stops));
    }
}
