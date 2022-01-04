import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String []args) {
        List<Node> nodeList = OperationHelper.solve(Arrays.asList(5, 10, 25, 7, 2, 5), 503);
        nodeList.forEach(System.out::println);
    }
}
