package SoftComputing.Operators.crossover;

import SoftComputing.Chromosomes.*;
import SoftComputing.interfaces.CrossoverStrategy;

import java.util.Random;
import java.util.TreeSet;

public class NPointCrossover implements CrossoverStrategy {
    private final int nPoints;
    private final Random rand = new Random();

    public NPointCrossover(int nPoints) {
        this.nPoints = nPoints;
    }

    @Override
    public Chromosome[] crossover(Chromosome parent1, Chromosome parent2) {
        if (parent1 instanceof BinaryChromosome && parent2 instanceof BinaryChromosome) {
            return crossoverBinary((BinaryChromosome) parent1, (BinaryChromosome) parent2);
        } else if (parent1 instanceof IntegerChromosome && parent2 instanceof IntegerChromosome) {
            return crossoverInteger((IntegerChromosome) parent1, (IntegerChromosome) parent2);
        } else if (parent1 instanceof FloatChromosome && parent2 instanceof FloatChromosome) {
            return crossoverFloat((FloatChromosome) parent1, (FloatChromosome) parent2);
        }
        return new Chromosome[]{parent1.copy(), parent2.copy()};
    }

    private Chromosome[] crossoverBinary(BinaryChromosome p1, BinaryChromosome p2) {
        boolean[] genes1 = p1.getGenes().clone();
        boolean[] genes2 = p2.getGenes().clone();
        applyNPoint(genes1, genes2);
        BinaryChromosome c1 = new BinaryChromosome(genes1.length);
        BinaryChromosome c2 = new BinaryChromosome(genes2.length);
        System.arraycopy(genes1, 0, c1.getGenes(), 0, genes1.length);
        System.arraycopy(genes2, 0, c2.getGenes(), 0, genes2.length);
        return new Chromosome[]{c1, c2};
    }

    private Chromosome[] crossoverInteger(IntegerChromosome p1, IntegerChromosome p2) {
        int[] genes1 = p1.getGenes().clone();
        int[] genes2 = p2.getGenes().clone();
        applyNPoint(genes1, genes2);
        IntegerChromosome c1 = new IntegerChromosome(genes1.length, 0, 0);
        IntegerChromosome c2 = new IntegerChromosome(genes2.length, 0, 0);
        System.arraycopy(genes1, 0, c1.getGenes(), 0, genes1.length);
        System.arraycopy(genes2, 0, c2.getGenes(), 0, genes2.length);
        return new Chromosome[]{c1, c2};
    }

    private Chromosome[] crossoverFloat(FloatChromosome p1, FloatChromosome p2) {
        double[] genes1 = p1.getGenes().clone();
        double[] genes2 = p2.getGenes().clone();
        applyNPoint(genes1, genes2);
        FloatChromosome c1 = new FloatChromosome(genes1.length, 0, 1);
        FloatChromosome c2 = new FloatChromosome(genes2.length, 0, 1);
        System.arraycopy(genes1, 0, c1.getGenes(), 0, genes1.length);
        System.arraycopy(genes2, 0, c2.getGenes(), 0, genes2.length);
        return new Chromosome[]{c1, c2};
    }

    private void applyNPoint(Object genes1Arr, Object genes2Arr) {
        int length = java.lang.reflect.Array.getLength(genes1Arr);
        TreeSet<Integer> points = new TreeSet<>();
        while (points.size() < nPoints) {
            points.add(rand.nextInt(length));
        }

        boolean swap = false;
        int prev = 0;
        for (int point : points) {
            if (swap) {
                for (int i = prev; i < point; i++) {
                    Object temp = java.lang.reflect.Array.get(genes1Arr, i);
                    java.lang.reflect.Array.set(genes1Arr, i, java.lang.reflect.Array.get(genes2Arr, i));
                    java.lang.reflect.Array.set(genes2Arr, i, temp);
                }
            }
            swap = !swap;
            prev = point;
        }

        if (swap) {
            for (int i = prev; i < length; i++) {
                Object temp = java.lang.reflect.Array.get(genes1Arr, i);
                java.lang.reflect.Array.set(genes1Arr, i, java.lang.reflect.Array.get(genes2Arr, i));
                java.lang.reflect.Array.set(genes2Arr, i, temp);
            }
        }
    }
}
