package SoftComputing.Operators.crossover;

import SoftComputing.Chromosomes.*;
import SoftComputing.interfaces.CrossoverStrategy;

import java.util.Random;
import java.util.Arrays;

public class OrderOneCrossover implements CrossoverStrategy {
    private final Random rand = new Random();

    @Override
    public Chromosome[] crossover(Chromosome parent1, Chromosome parent2) {
        if (!(parent1 instanceof IntegerChromosome) || !(parent2 instanceof IntegerChromosome)) {
            return new Chromosome[]{parent1.copy(), parent2.copy()};
        }

        IntegerChromosome p1 = (IntegerChromosome) parent1;
        IntegerChromosome p2 = (IntegerChromosome) parent2;

        int length = p1.getGenes().length;
        int[] child1 = new int[length];
        int[] child2 = new int[length];
        Arrays.fill(child1, -1);
        Arrays.fill(child2, -1);

        int start = rand.nextInt(length - 1);
        int end = rand.nextInt(start + 1, length);

        for (int i = start; i <= end; i++) {
            child1[i] = p1.getGenes()[i];
            child2[i] = p2.getGenes()[i];
        }

        fillOrder(child1, p2.getGenes(), end);
        fillOrder(child2, p1.getGenes(), end);

        IntegerChromosome c1 = new IntegerChromosome(length, 0, 0);
        IntegerChromosome c2 = new IntegerChromosome(length, 0, 0);
        System.arraycopy(child1, 0, c1.getGenes(), 0, length);
        System.arraycopy(child2, 0, c2.getGenes(), 0, length);

        return new Chromosome[]{c1, c2};
    }

    private void fillOrder(int[] child, int[] parent, int end) {
        int index = (end + 1) % child.length;
        for (int gene : parent) {
            if (!contains(child, gene)) {
                child[index] = gene;
                index = (index + 1) % child.length;
            }
        }
    }

    private boolean contains(int[] arr, int val) {
        for (int a : arr) if (a == val) return true;
        return false;
    }
}
