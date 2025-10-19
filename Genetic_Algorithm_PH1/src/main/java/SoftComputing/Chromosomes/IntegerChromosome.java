package SoftComputing.Chromosomes;

import java.util.Random;

public class IntegerChromosome implements Chromosome
{
    private int[] genes;
    private double fitness;
    private int minValue;
    private int maxValue;

    public IntegerChromosome(int length, int minValue, int maxValue)
    {
        this.minValue = minValue;
        this.maxValue = maxValue;
        this.genes = new int[length];
        randomize();
    }
    private void randomize()
    {
    Random rand=new Random();
    for(int i = 0; i<genes.length; i++)
    {
        genes[i]=rand.nextInt((maxValue-minValue)+1)+minValue;
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
        IntegerChromosome clone = new IntegerChromosome(genes.length, minValue, maxValue);
        System.arraycopy(genes, 0, clone.genes, 0, genes.length);
        clone.fitness = fitness;
        return clone;
    }
    public int [] getGenes()
    {
        return genes;
    }
    public void setGenes(int index, int value)
    {
        genes[index] = value;
    }

}
