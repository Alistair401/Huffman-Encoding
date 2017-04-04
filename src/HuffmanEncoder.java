import java.util.ArrayList;
import java.util.HashMap;

public class HuffmanEncoder {
    private HashMap<Character, String> codes;
    public HuffmanEncoder(){
    }
    public String encode(String string){
        codes = new HashMap<>();
        ArrayList<Node> nodes = new ArrayList<>();
        HashMap<Character, Integer> frequency = new HashMap<>();
        for (int i = 0; i < string.length(); i++) {
            Character character = string.charAt(i);
            frequency.computeIfPresent(character,(key, val) -> val+1);
            frequency.putIfAbsent(character, 1);
        }
        frequency.forEach((character, integer) -> {
            Node n = new Node(character, integer);
            nodes.add(n);
        });
        ArrayList<Node> parentless = new ArrayList<>();
        parentless.addAll(nodes);
        while (parentless.size() > 1){
            Node lowestA = new Node(null,Integer.MAX_VALUE);
            Node lowestB = new Node(null,Integer.MAX_VALUE);

            for (Node node : parentless) {
                if (node.getWeight() < lowestA.getWeight()){
                    lowestB = lowestA;
                    lowestA = node;
                } else if (node.getWeight() < lowestB.getWeight()){
                    lowestB = node;
                }
            }

            Node n = new Node(null,lowestA.getWeight()+lowestB.getWeight());
            n.setLeftChild(lowestA);
            n.setRightChild(lowestB);
            lowestA.setParent(n);
            lowestB.setParent(n);
            parentless.remove(lowestA);
            parentless.remove(lowestB);
            parentless.add(n);
            nodes.add(n);
        }
        for (Node n : nodes) {
            if (n.getContent() != null){
                calculateCode(n);
            }
        }
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < string.length(); i++) {
            result.insert(0, codes.get(string.charAt(i)));
        }
        return result.toString();
    }
    public String getCode(Character c){
        return codes.getOrDefault(c,null);
    }
    public HashMap<Character,String> getCodes(){
        return codes;
    }
    private void calculateCode(Node node){
        Node current = node;
        StringBuilder code = new StringBuilder();
        while(current.getParent() != null){
            if (current.getParent().getLeftChild() == current) code.insert(0, '0');
            else code.insert(0,'1');
            current = current.getParent();
        }
        codes.put(node.getContent(),code.toString());
    }
}
