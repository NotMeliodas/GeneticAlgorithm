package SoftComputing.Core;
import SoftComputing.Chromosomes.Chromosome;
import SoftComputing.interfaces.InfeasibilityHandler;
import java.util.*;

public class InfeasibilityHandlerImpl implements InfeasibilityHandler {

    @Override
    public boolean isFeasible(Chromosome individual) {
        List<?> genes = individual.getGenes();
        Set<?> unique = new HashSet<>(genes);
        return unique.size() == genes.size();
    }

    @Override
    public Chromosome repair(Chromosome individual) {
        List<?> genes = new ArrayList<>(individual.getGenes());
        Set<Object> seen = new HashSet<>();
        Random rand = new Random();

        for (int i = 0; i < genes.size(); i++) {
            Object gene = genes.get(i);
            if (seen.contains(gene)) {
                Object newGene;
                do {
                    newGene = rand.nextInt(genes.size());
                } while (seen.contains(newGene));
                ((List<Object>) genes).set(i, newGene);
            }
            seen.add(genes.get(i));
        }

        Chromosome copy = individual.copy();
        for (int i = 0; i < genes.size(); i++) {
            copy.setGene(i, (double) genes.get(i));
        }

        return copy;
    }
}
