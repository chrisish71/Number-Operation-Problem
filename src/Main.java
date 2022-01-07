import java.util.Arrays;
import java.util.List;

/**
 * Main class to check the number operation problem
 */
public class Main {

    public static void main(String []args) {
        List<Node> nodeList = OperationHelper.solve(Arrays.asList(5, 10, 25, 7, 2), 503);
        nodeList.forEach(System.out::println);
    }
}
