package SoftComputing.Core;

import SoftComputing.Chromosomes.Chromosome;
import SoftComputing.interfaces.Replacement;
import java.util.*;

public class ReplacementHandler {

    public static class GenerationalReplacement implements Replacement {
        @Override
        public List<Chromosome> replace(List<Chromosome> oldPop, List<Chromosome> newPop) {
            return new ArrayList<>(newPop);
        }
    }

    public static class ElitismReplacement implements Replacement {
        private final int eliteCount;

        public ElitismReplacement(int eliteCount) {
            this.eliteCount = eliteCount;
        }

        @Override
        public List<Chromosome> replace(List<Chromosome> oldPop, List<Chromosome> newPop) {
            List<Chromosome> nextGen = new ArrayList<>(newPop);
            for (int i = 0; i < eliteCount && i < oldPop.size(); i++) {
                nextGen.set(i, oldPop.get(i));
            }
            return nextGen;
        }
    }

    public static class SteadyStateReplacement implements Replacement {
        private final int replaceCount;

        public SteadyStateReplacement(int replaceCount) {
            this.replaceCount = replaceCount;
        }

        @Override
        public List<Chromosome> replace(List<Chromosome> oldPop, List<Chromosome> newPop) {
            Random rand = new Random();
            List<Chromosome> nextGen = new ArrayList<>(oldPop);

            for (int i = 0; i < replaceCount && i < newPop.size(); i++) {
                int index = rand.nextInt(nextGen.size());
                nextGen.set(index, newPop.get(i));
            }
            return nextGen;
        }
    }
}
