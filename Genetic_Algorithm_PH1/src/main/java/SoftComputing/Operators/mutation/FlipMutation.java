package SoftComputing.Operators.mutation;

import SoftComputing.Chromosomes.Chromosome;
import SoftComputing.interfaces.Mutation;

import java.util.Random;


public class FlipMutation implements Mutation {

    private final Random random = new Random();

    @Override
    public void mutate(Chromosome chromosome, double mutationRate) {
        int[] genes = chromosome.getGenesArray();
        int length = genes.length;

        for (int i = 0; i < length; i++) {
            if (random.nextDouble() < mutationRate) {
                // Flip 0 → 1 or 1 → 0
                genes[i] = (genes[i] == 0) ? 1 : 0;
            }
        }

        chromosome.setGenesArray(genes);
    }
}
