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
        int n = random.nextInt(10000);
        int [] numbers = new int[n];
        System.out.println("N = "+n);
        for (int i = 0; i < n ; i++) {
            int val = random.nextInt(100000);
            System.out.print(val + ", ");
            numbers[i] = val;
        }
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

