package SoftComputing.Operators.mutation;

import SoftComputing.Chromosomes.Chromosome;
import SoftComputing.Chromosomes.IntegerChromosome;
import SoftComputing.Chromosomes.FloatChromosome;
import SoftComputing.Chromosomes.BinaryChromosome;
import SoftComputing.interfaces.Mutation;

import java.util.Random;

public class SwapMutation implements Mutation {

    private final Random random = new Random();

    @Override
    public void mutate(Chromosome chromosome, double mutationRate) {
        // Apply mutation only with given probability
        if (random.nextDouble() > mutationRate) {
            return;
        }

        // Handle IntegerChromosome
        if (chromosome instanceof IntegerChromosome) {
            IntegerChromosome intChrom = (IntegerChromosome) chromosome;
            int[] genes = intChrom.getGenes();
            if (genes.length < 2) return;

            int i = random.nextInt(genes.length);
            int j = random.nextInt(genes.length);
            while (i == j) j = random.nextInt(genes.length);

            // Swap
            int temp = genes[i];
            genes[i] = genes[j];
            genes[j] = temp;

            // Update genes
            intChrom.setGenes(i, genes[i]);
            intChrom.setGenes(j, genes[j]);
        }

        // Handle FloatChromosome
        else if (chromosome instanceof FloatChromosome) {
            FloatChromosome floatChrom = (FloatChromosome) chromosome;
            double[] genes = floatChrom.getGenes();
            if (genes.length < 2) return;

            int i = random.nextInt(genes.length);
            int j = random.nextInt(genes.length);
            while (i == j) j = random.nextInt(genes.length);

            double temp = genes[i];
            genes[i] = genes[j];
            genes[j] = temp;

            floatChrom.setGenes(i, genes[i]);
            floatChrom.setGenes(j, genes[j]);
        }

        // Handle BinaryChromosome
        else if (chromosome instanceof BinaryChromosome) {
            BinaryChromosome binChrom = (BinaryChromosome) chromosome;
            boolean[] genes = binChrom.getGenes();
            if (genes.length < 2) return;

            int i = random.nextInt(genes.length);
            int j = random.nextInt(genes.length);
            while (i == j) j = random.nextInt(genes.length);

            boolean temp = genes[i];
            genes[i] = genes[j];
            genes[j] = temp;

            binChrom.setGenes(i, genes[i]);
            binChrom.setGenes(j, genes[j]);
        }
    }
}
