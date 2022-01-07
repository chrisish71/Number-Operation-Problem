import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class OperationHelper {

    /**
     * Filter only nodes whose evaluation is equal to the desired result
     * @param numberList: list of operands
     * @param result: desired result
     * @return a list of node whose evaluation is equal to the desired result
     */
    public static List<Node> solve(List<Integer> numberList, Integer result) {
        return create(numberList.stream().map(Node::new).collect(Collectors.toList())).stream()
                .filter(node -> Objects.equals(node.evaluate(), result)).collect(Collectors.toList());
    }

    /**
     * create all possible combinations of nodes from the basic operators (+, -, *, /)
     * @param nodeList: a list of nodes' values
     * @return : a list of all possibilities
     */
    private static List<Node> create(List<Node> nodeList){
        if (nodeList.size() > 1) {
            List<Node> resultNodeList = new ArrayList<>();
            nodeList.forEach(node ->
                    create(nodeList.stream()
                            .filter(currentNode -> !currentNode.equals(node))
                            .collect(Collectors.toList()))
                            .forEach(currentNode -> {
                                Integer originalValue = node.evaluate();
                                Integer currentValue = currentNode.evaluate();
                                if (currentValue != 0 && originalValue % currentValue == 0) {
                                    resultNodeList.add(new Node(node, '/', currentNode));
                                }
                                if (originalValue != 0 && currentValue % originalValue == 0) {
                                    resultNodeList.add(new Node(currentNode, '/', node));
                                }
                                resultNodeList.add(new Node(node, '+', currentNode));
                                resultNodeList.add(new Node(node, '*', currentNode));
                                resultNodeList.add(new Node(node, '-', currentNode));
                                resultNodeList.add(new Node(currentNode, '-', node));
                            })
            );
            return resultNodeList;
        }
        return nodeList;
    }
}
