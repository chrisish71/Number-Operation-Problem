public class Node {

    private Integer value;
    private Node leftNode;
    private Node rightNode;
    private Character operator;

    public Node(Integer value) {
        this.value = value;
    }

    public Node(Node leftNode, Character operator, Node rightNode) {
        this.leftNode = leftNode;
        this.rightNode = rightNode;
        this.operator = operator;
    }

    public Integer evaluate() {
        if (this.operator != null) {
            Integer leftValue = this.leftNode.evaluate();
            Integer rightValue = this.rightNode.evaluate();
            switch (this.operator) {
                case '+': return leftValue + rightValue;
                case '-': return leftValue - rightValue;
                case '*': return leftValue * rightValue;
                case '/': return rightValue.equals(0) ? Integer.MAX_VALUE : leftValue / rightValue;
            }
        }
        return value;
    }

    @Override
    public String toString() {
        if (this.operator == null){
            return String.valueOf(value);
        }
        return "(" + this.leftNode.toString() + " " + this.operator + " " + this.rightNode.toString() + ")";
    }
}
