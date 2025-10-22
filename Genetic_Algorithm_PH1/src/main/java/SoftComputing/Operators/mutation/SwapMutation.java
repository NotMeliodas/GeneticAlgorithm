package SoftComputing.Operators.mutation;

import SoftComputing.Chromosomes.Chromosome;
import SoftComputing.interfaces.Mutation;

import java.util.List;
import java.util.Random;


public class SwapMutation implements Mutation {

    private final Random random = new Random();

    @Override
    public void mutate(Chromosome chromosome, double mutationRate) {

        if (random.nextDouble() > mutationRate) {
            return;
        }

        List<Integer> genes = chromosome.getGenes();
        int size = genes.size();

        if (size < 2) return; // No mutation possible

        // Pick two different gene positions to swap
        int index1 = random.nextInt(size);
        int index2 = random.nextInt(size);

        while (index2 == index1) {
            index2 = random.nextInt(size);
        }

        // Manual swap using simple Java logic
        int temp = genes.get(index1);
        genes.set(index1, genes.get(index2));
        genes.set(index2, temp);

        // Update chromosome with modified genes
        chromosome.setGenes(genes);
    }
}
