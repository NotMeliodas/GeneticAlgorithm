package SoftComputing.Core;

import SoftComputing.Chromosomes.Chromosome;
import SoftComputing.Chromosomes.IntegerChromosome;
import SoftComputing.interfaces.InfeasibilityHandler;

import java.util.*;


public class InfeasibilityHandlerImpl implements InfeasibilityHandler {

    @Override
    public boolean isFeasible(Chromosome individual) {
        if (individual instanceof IntegerChromosome) {
            IntegerChromosome ind = (IntegerChromosome) individual;
            int[] geneArray = ind.getGenes();
            List<Integer> genes = new ArrayList<>();
            for (int g : geneArray) {
                genes.add(g);
            }

            Set<Integer> unique = new HashSet<>(genes);
            return unique.size() == genes.size();
        }
        return true;
    }

    @Override
    public Chromosome repair(Chromosome individual) {
        if (individual instanceof IntegerChromosome) {
            IntegerChromosome ind = (IntegerChromosome) individual;
            int[] geneArray = ind.getGenes();
            List<Integer> genes = new ArrayList<>();
            for (int g : geneArray) {
                genes.add(g);
            }
            Set<Integer> seen = new HashSet<>();
            Random rand = new Random();

            int n = genes.size();


            Set<Integer> available = new HashSet<>();
            for (int i = 0; i < n; i++) {
                available.add(i);
            }


            for (int g : genes) {
                available.remove(g);
            }


            for (int i = 0; i < n; i++) {
                int gene = genes.get(i);
                if (seen.contains(gene)) {
                    // Replace with a missing value if available
                    if (!available.isEmpty()) {
                        int newGene = available.iterator().next();
                        available.remove(newGene);
                        genes.set(i, newGene);
                    } else {
                        int newGene;
                        do {
                            newGene = rand.nextInt(n);
                        } while (seen.contains(newGene));
                        genes.set(i, newGene);
                    }
                }
                seen.add(genes.get(i));
            }

            int[] repairedGenes = new int[genes.size()];
            for (int i = 0; i < genes.size(); i++) {
                repairedGenes[i] = genes.get(i);
            }

            IntegerChromosome repaired = new IntegerChromosome(repairedGenes.length, 0, repairedGenes.length - 1);
            for (int i = 0; i < repairedGenes.length; i++) {
                repaired.setGenes(i, repairedGenes[i]);
            }
            repaired.setFitness(ind.getFitness());
            return repaired;
        }

        return individual.copy();
    }
}
