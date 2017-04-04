public class Node {
    private Node[] children;
    private Character content;
    private int weight;
    private Node parent;
    public Node(Character content, int weight){
        this.content = content;
        this.weight = weight;
        children = new Node[2];
    }
    public Character getContent() {
        return content;
    }
    public int getWeight() {
        return weight;
    }
    public Node getLeftChild(){
        return children[0];
    }
    public Node getRightChild() {
        return children[1];
    }
    public void setLeftChild(Node node){
        children[0] = node;
    }
    public void setRightChild(Node node){
        children[1] = node;
    }
    public Node getParent() {
        return parent;
    }
    public void setParent(Node parent) {
        this.parent = parent;
    }
}
