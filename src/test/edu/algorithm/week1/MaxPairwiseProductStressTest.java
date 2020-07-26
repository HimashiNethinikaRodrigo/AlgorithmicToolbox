package test.edu.algorithm.week1;

import main.edu.algorithm.week1.MaxPairwiseProduct;
import main.edu.algorithm.week1.MaxPairwiseProductWithLessTime;
import org.junit.Assert;
import org.junit.Test;

import java.time.Duration;
import java.time.Instant;
import java.util.Random;

public class MaxPairwiseProductStressTest {

    @Test
    public void getMaxPairwiseProduct() {
        Random random = new Random();
        int n = random.nextInt(10000)+2; //make sure at least two numbers are present
        int [] numbers = new int[n];
        System.out.println("N = "+n);
        for (int i = 0; i < n ; i++) {
            int val = random.nextInt(100000);
            System.out.print(val + ", ");
            numbers[i] = val;
        }
        /*
             Test for some edge cases
         */
//        int [] numbers = new int[] {68165, 30342, 87637, 74297, 2904, 32873, 86010, 87637, 66131, 82858, 82935};
//        int [] numbers = new int[] {2, 9, 3, 1, 9};
        System.out.println();
        //slow algorithm
        Instant start1 = Instant.now();
        Long maxPairwiseProduct = MaxPairwiseProduct.getMaxPairwiseProduct(numbers);
        Instant end1 = Instant.now();

        // fast algorithm
        Instant start2 = Instant.now();
        Long maxPairwiseProductEfficient = MaxPairwiseProductWithLessTime.getMaxPairwiseProduct(numbers);
        Instant end2 = Instant.now();

        System.out.println("Less efficient algorithm product : " + maxPairwiseProduct);
        System.out.println("Less efficient algorithm time : " + Duration.between(start1, end1));

        System.out.println("Efficient algorithm product : " + maxPairwiseProductEfficient);
        System.out.println("Efficient algorithm time : " + Duration.between(start2, end2));

        Assert.assertEquals(maxPairwiseProduct, maxPairwiseProductEfficient);
    }


}

