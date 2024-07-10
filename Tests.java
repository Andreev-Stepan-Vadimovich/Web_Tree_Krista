import org.example.Node;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Tests {
    @Test
    void createNewTree() {
        Node node = new Node("node1");
        assertEquals("node1", node.getName(), "Error");
        assertEquals(1, node.getID(), "Error");
    }

    @Test
    void addNewNode() {
        Node root = new Node("node1");
        root.addNewNode(root.getID(),"node2");
        assertEquals(1, root.getChildren().size(), "Error");
    }

    @Test
    void findNodeTrue() {
        Node node = new Node("node1");
        node.addNewNode(node.getID(),"node2");
        node.addNewNode(node.getChildren().get(0).getID(), "node3");
        Node forTest = node.findNode("node3");
        assertEquals("node3", forTest.getName(), "Error");
    }

    @Test
    void findNodeFalse() {
        Node node = new Node("node1");
        node.addNewNode(node.getID(),"node2");
        Node forTest = node.findNode("node3");
        assertEquals(null, forTest, "Error");
    }

    @Test
    void deleteNodeForName() {
        Node node = new Node("node1");
        node.addNewNode(node.getID(),"node2");
        node.deleteNodeForName("node2");
        assertEquals(0, node.getChildren().size(), "Error");
    }

    @Test
    void deleteNodeForID() {
        Node node = new Node("node1");
        node.addNewNode(node.getID(),"node2");
        node.deleteNodeForID(2);
        assertEquals(0, node.getChildren().size(), "Error");
    }

    @Test
    void deleteAllChildrenForID () {
        Node node = new Node("node1");
        node.addNewNode(node.getID(),"node2");
        node.addNewNode(node.getID(),"node3");
        node.deleteAllChildrenForID(1);
        assertEquals(0, node.getChildren().size(), "Error");
    }

    @Test
    void deleteAllChildrenForName () {
        Node node = new Node("node1");
        node.addNewNode(node.getID(),"node2");
        node.addNewNode(node.getID(),"node3");
        node.deleteAllChildrenForName("node1");
        assertEquals(0, node.getChildren().size(), "Error");
    }

    @Test
    void Rename() {
        Node node = new Node("node1");
        node.Rename("NODE");
        assertEquals("NODE", node.getName(), "Error");
    }
}
