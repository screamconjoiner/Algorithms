package sorting;

/**
 * ExchangeSort
 * @author Connor Rice
 */
public class ExchangeSort extends Sorter {
    
    /**
     * Constructor with arguments.
     * @param args console arguments.
     */
    public ExchangeSort(String[] args) {
        this.args = args;
        this.name = "ExchangeSort";
    }
    
    /**
     * Default constructor.
     */
    public ExchangeSort() {
        this.name = "ExchangeSort";
    }
    
    /**
     * sort() is the command called from outside of the program.
     * It's responsible for setting up and tearing down the run.
     * @param a Comparable array.
     */
    @Override
    public <E extends Comparable<? super E>> void sort(E[] a) {
        super.start();
        exchangeSort(a);
        super.end(a);
    }
    
    /**
     * This is the actual algorithm, keeping track of comparisons.
     * @param a Comparable array.
     */
    private <E extends Comparable<? super E>> void exchangeSort(E[] a) {        
        for (int i = 0; i < a.length-1; i++) {
            for (int j = i + 1; j < a.length; j++) {
                if (a[i].compareTo(a[j]) > 0) {
                    sendComparison();
                    swap(a,i,j);
                } else {
                    sendComparison();
                }
            }
        }
    }
    
}