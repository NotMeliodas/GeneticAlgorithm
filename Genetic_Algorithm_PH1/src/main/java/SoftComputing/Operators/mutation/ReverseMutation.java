package SoftComputing.Operators.mutation;

import SoftComputing.Chromosomes.Chromosome;
import SoftComputing.interfaces.Mutation;

import java.util.Random;

public class ReverseMutation implements Mutation {

    private final Random random = new Random();

    @Override
    public void mutate(Chromosome chromosome, double mutationRate) {
        if (random.nextDouble() > mutationRate) return;

        int[] genes = chromosome.getGenesArray();
        int length = genes.length;

        int start = random.nextInt(length);
        int end = random.nextInt(length);

        if (start > end) {
            int temp = start;
            start = end;
            end = temp;
        }

        while (start < end) {
            int temp = genes[start];
            genes[start] = genes[end];
            genes[end] = temp;
            start++;
            end--;
        }

        chromosome.setGenesArray(genes);
    }
}
