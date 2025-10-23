package SoftComputing.Operators.selection;

import SoftComputing.Chromosomes.Chromosome;
import SoftComputing.interfaces.SelectionStrategy;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class TournamentSelection implements SelectionStrategy {
    private final int tournamentSize;
    private final Random random;

    public TournamentSelection(int tournamentSize) {
        this.tournamentSize = Math.max(2, tournamentSize);
        this.random = new Random();
    }

    @Override
    public List<Chromosome> select(List<Chromosome> population, int numberToSelect) {
        List<Chromosome> selected = new ArrayList<>();
        if (population == null || population.isEmpty() || numberToSelect <= 0) {
            return selected;
        }
        numberToSelect = Math.min(numberToSelect, population.size());

        for (int i = 0; i < numberToSelect; i++) {
            // build tournament
            Chromosome best = null;
            for (int j = 0; j < tournamentSize; j++) {
                Chromosome candidate = population.get(random.nextInt(population.size()));
                if (best == null || candidate.getFitness() > best.getFitness()) {
                    best = candidate;
                }
            }

            Chromosome copy = best.copy();
            copy.setFitness(best.getFitness());
            selected.add(copy);
        }

        return selected;
    }
}
