package SoftComputing.Operators.crossover;

import SoftComputing.Chromosomes.*;
import SoftComputing.interfaces.CrossoverStrategy;

import java.util.Random;

public class OnePointCrossover implements CrossoverStrategy {
    private final Random rand = new Random();

    @Override
    public Chromosome[] crossover(Chromosome parent1, Chromosome parent2) {
        int point;

        if (parent1 instanceof BinaryChromosome && parent2 instanceof BinaryChromosome) {
            BinaryChromosome p1 = (BinaryChromosome) parent1;
            BinaryChromosome p2 = (BinaryChromosome) parent2;

            boolean[] genes1 = p1.getGenes().clone();
            boolean[] genes2 = p2.getGenes().clone();
            point = rand.nextInt(genes1.length);

            for (int i = point; i < genes1.length; i++) {
                boolean temp = genes1[i];
                genes1[i] = genes2[i];
                genes2[i] = temp;
            }

            BinaryChromosome c1 = new BinaryChromosome(genes1.length);
            BinaryChromosome c2 = new BinaryChromosome(genes2.length);
            System.arraycopy(genes1, 0, c1.getGenes(), 0, genes1.length);
            System.arraycopy(genes2, 0, c2.getGenes(), 0, genes2.length);
            return new Chromosome[]{c1, c2};
        }

        else if (parent1 instanceof IntegerChromosome && parent2 instanceof IntegerChromosome) {
            IntegerChromosome p1 = (IntegerChromosome) parent1;
            IntegerChromosome p2 = (IntegerChromosome) parent2;

            int[] genes1 = p1.getGenes().clone();
            int[] genes2 = p2.getGenes().clone();
            point = rand.nextInt(genes1.length);

            for (int i = point; i < genes1.length; i++) {
                int temp = genes1[i];
                genes1[i] = genes2[i];
                genes2[i] = temp;
            }

            IntegerChromosome c1 = new IntegerChromosome(genes1.length, 0, 0);
            IntegerChromosome c2 = new IntegerChromosome(genes2.length, 0, 0);
            System.arraycopy(genes1, 0, c1.getGenes(), 0, genes1.length);
            System.arraycopy(genes2, 0, c2.getGenes(), 0, genes2.length);
            return new Chromosome[]{c1, c2};
        }

        else if (parent1 instanceof FloatChromosome && parent2 instanceof FloatChromosome) {
            FloatChromosome p1 = (FloatChromosome) parent1;
            FloatChromosome p2 = (FloatChromosome) parent2;

            double[] genes1 = p1.getGenes().clone();
            double[] genes2 = p2.getGenes().clone();
            point = rand.nextInt(genes1.length);

            for (int i = point; i < genes1.length; i++) {
                double temp = genes1[i];
                genes1[i] = genes2[i];
                genes2[i] = temp;
            }

            FloatChromosome c1 = new FloatChromosome(genes1.length, 0, 1);
            FloatChromosome c2 = new FloatChromosome(genes2.length, 0, 1);
            System.arraycopy(genes1, 0, c1.getGenes(), 0, genes1.length);
            System.arraycopy(genes2, 0, c2.getGenes(), 0, genes2.length);
            return new Chromosome[]{c1, c2};
        }

        return new Chromosome[]{parent1.copy(), parent2.copy()};
    }
}
