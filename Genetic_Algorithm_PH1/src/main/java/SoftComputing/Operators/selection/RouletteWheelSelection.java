package SoftComputing.Operators.selection;

import SoftComputing.Chromosomes.Chromosome;
import SoftComputing.interfaces.SelectionStrategy;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RouletteWheelSelection implements SelectionStrategy {
    @Override
    public List<Chromosome> select(List<Chromosome> population, int numberToSelect) {
        List<Chromosome> selected = new ArrayList<>();
        Random random = new Random();

        if (population == null || population.isEmpty() || numberToSelect <= 0) {
            return selected;
        }

        double totalFitness = 0.0;
        for (Chromosome c : population) {
            totalFitness += Math.max(0.0, c.getFitness());
        }

        if (totalFitness <= 0.0) {
            for (int i = 0; i < numberToSelect; i++) {
                Chromosome r = population.get(random.nextInt(population.size())).copy();
                r.setFitness(population.get(random.nextInt(population.size())).getFitness());
                selected.add(r);
            }
            return selected;
        }

        for (int i = 0; i < numberToSelect; i++) {
            double spin = random.nextDouble() * totalFitness;
            double cumulative = 0.0;
            Chromosome chosen = null;

            for (Chromosome c : population) {
                cumulative += Math.max(0.0, c.getFitness());
                if (cumulative >= spin) {
                    chosen = c;
                    break;
                }
            }

            if (chosen == null) {
                for (int j = population.size() - 1; j >= 0; j--) {
                    if (population.get(j).getFitness() > 0.0) {
                        chosen = population.get(j);
                        break;
                    }
                }
                if (chosen == null) {
                    chosen = population.get(population.size() - 1);
                }
            }

            Chromosome copy = chosen.copy();
            copy.setFitness(chosen.getFitness());
            selected.add(copy);
        }

        return selected;
    }
}
