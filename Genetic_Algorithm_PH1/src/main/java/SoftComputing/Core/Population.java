package SoftComputing.Core;

import SoftComputing.Chromosomes.BinaryChromosome;
import SoftComputing.Chromosomes.Chromosome;
import SoftComputing.Chromosomes.FloatChromosome;
import SoftComputing.Chromosomes.IntegerChromosome;

import java.util.ArrayList;
import java.util.List;
public class Population
{
    public List <Chromosome> chromosoms;
    private int size;

    public Population(int size)
    {
        this.size=size;
        this.chromosoms = new ArrayList<>(size);
    }

    public void intializeBinary(int chromosomeLength)
    {
        for(int i = 0; i<size; i++)
        {
            chromosoms.add(new BinaryChromosome(chromosomeLength));
        }
    }

    public void intializeInteger(int chromosomeLength,int minValue,int maxValue)
    {
        for(int i = 0; i<size; i++)
        {
            chromosoms.add(new IntegerChromosome(chromosomeLength, minValue, maxValue));
        }
    }

    public void intializeFloat(int chromosomeLength,double minValue,double maxValue)
    {
        for(int i = 0; i<size; i++)
        {
            chromosoms.add(new FloatChromosome(chromosomeLength, minValue, maxValue));
        }
    }

    public List<Chromosome> getChromosoms()
    {
        return chromosoms;
    }
}
