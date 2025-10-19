package SoftComputing.Chromosomes;

import java.util.Random;

public class FloatChromosome implements Chromosome
{
    private double[] genes;
    private double fitness;
    private double minValue;
    private double maxValue;

    public FloatChromosome(int length, double minValue, double maxValue)
    {
        this.minValue = minValue;
        this.maxValue = maxValue;
        this.genes = new double[length];
        randomize();
    }
    private void randomize()
    {
        Random rand=new Random();
        for(int i = 0; i<genes.length; i++)
        {
            genes[i]=minValue+(rand.nextDouble()*(maxValue-minValue));
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
        FloatChromosome clone = new FloatChromosome(genes.length, minValue, maxValue);
        System.arraycopy(genes, 0, clone.genes, 0, genes.length);
        clone.fitness = fitness;
        return clone;
    }
    public double[] getGenes()
    {
        return genes;
    }
    public void setGenes(int index, double value)
    {
        genes[index] = value;
    }

}
