import javax.swing.plaf.synth.SynthOptionPaneUI;

public class Main {
    public static void main(String[] args) {
        Node node = new Node("node1");
        node.addNewNode("node2");
        node.addNewNode("node3");
        node.getChildren().get(1).addNewNode("node4");
        String wr = node.toHTMLTreeStructure(0);
        System.out.println(wr);
        System.out.println();
        System.out.println(node.makeHTMLFile());
    }
}
