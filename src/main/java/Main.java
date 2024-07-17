import javax.swing.plaf.synth.SynthOptionPaneUI;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        Node node = new Node("node1");
        node.addNewNode("node2");
        node.addNewNode("node3");
        node.getChildren().get(1).addNewNode("node4");
    }
}
