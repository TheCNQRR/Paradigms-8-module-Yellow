package Solution;

import java.util.ArrayList;

public class SolutionsStorage {
    private static final ArrayList<Solution> solutions = new ArrayList<>();
    public static ArrayList<Solution> getSolution() { return solutions; }
    public static void addSolution(Solution solution) { solutions.add(solution); }
    public static void removeSolutionAtIndex(int index) { solutions.remove(index); }
    public static void removeSolutionObject(Solution solution) { solutions.remove(solution); }
}
