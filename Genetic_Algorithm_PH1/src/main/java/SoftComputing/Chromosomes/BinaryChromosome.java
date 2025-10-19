package SoftComputing.Chromosomes;

import java.util.Random;

public class BinaryChromosome implements Chromosome
{
    public boolean[] genes;
    public double fitness;
    public BinaryChromosome(int length)
    {
        genes = new boolean[length];
        randomize();
    }
    public void randomize()
    {
        Random rand = new Random();
        for (int i = 0; i < genes.length; i++)
        {
            genes[i] = rand.nextBoolean();
        }

    }

    @Override
    public double getFitness()
    {
        return fitness;
    }

    @Override
    public void setFitness(double fitness)
    {
        this.fitness = fitness;
    }

    @Override
    public Chromosome copy()
    {
        BinaryChromosome clone = new BinaryChromosome(genes.length);
        System.arraycopy(genes, 0, clone.genes, 0, genes.length);
        clone.fitness = fitness;
        return clone;
    }

    public boolean[] getGenes()
    {
        return genes;
    }

    public void setGenes(int index, boolean value)
    {
        genes[index] = value;
    }
}
