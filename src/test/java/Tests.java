import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class Tests {
    @Test
    void createNewTree() {
        Node node = new Node("node1");
        assertEquals("node1", node.getName(), "Error");
    }

    @Test
    void addNewNode() {
        Node root = new Node("node1");
        root.addNewNode("node2");
        assertEquals(1, root.getChildren().size(), "Error");
    }

    @Test
    void findNodeDeepTrue() {
        Node node = new Node("node1");
        node.addNewNode("node2");
        node.getChildren().get(0).addNewNode("node3");
        node.getChildren().get(0).addNewNode("node4");
        node.getChildren().get(0).getChildren().get(0).addNewNode("node5");
        node.getChildren().get(0).getChildren().get(0).addNewNode("node6");
        assertEquals("node1", node.findNode("node1").getName(), "Error");
        assertEquals("node2", node.findNode("node2").getName(), "Error");
        assertEquals("node4", node.findNode("node4").getName(), "Error");
        assertEquals("node6", node.findNode("node6").getName(), "Error");
        assertNotNull(node.findNode("node1"), "Error");
        assertNotNull(node.findNode("node2"), "Error");
        assertNotNull(node.findNode("node3"), "Error");
        assertNotNull(node.findNode("node5"), "Error");
    }

    @Test
    void findNodeDeepFalse() {
        Node node = new Node("node1");
        node.addNewNode("node2");
        node.getChildren().get(0).addNewNode("node3");
        node.getChildren().get(0).addNewNode("node4");
        node.getChildren().get(0).getChildren().get(0).addNewNode("node5");
        node.getChildren().get(0).getChildren().get(0).addNewNode("node6");
        assertNull(node.findNode("node8"), "Error");
    }

    @Test
    void findNodeTrue() {
        Node node = new Node("node1");
        node.addNewNode("node2");
        node.getChildren().get(0).addNewNode( "node3");
        Node forTest = node.findNode("node3");
        assertEquals("node3", forTest.getName(), "Error");
    }

    @Test
    void findNodeFalse() {
        Node node = new Node("node1");
        node.addNewNode("node2");
        Node forTest = node.findNode("node3");
        assertNull(forTest, "Error");
    }

    @Test
    void deleteNodeForName() {
        Node node = new Node("node1");
        node.addNewNode("node2");
        node.addNewNode("node3");
        node.deleteNodeForName("node3");
        assertEquals(1, node.getChildren().size(), "Error");
        assertEquals("node2", node.getChildren().get(0).getName(), "Error");
    }

    @Test
    void deleteNodeForID() {
        Node node = new Node("node1");
        node.addNewNode("node2");
        node.getChildren().get(0).addNewNode("node3");
        node.getChildren().get(0).getChildren().get(0).addNewNode("node4");
        node.getChildren().get(0).getChildren().get(0).addNewNode("node5");
        node.deleteNodeForID(5);
        assertEquals("node4", node.getChildren().get(0).getChildren().get(0).getChildren().get(0).getName(), "Error");
    }

    @Test
    void deleteAllChildren () {
        Node node = new Node("node1");
        node.addNewNode("node2");
        node.addNewNode("node3");
        node.deleteAllChildren();
        assertEquals(0, node.getChildren().size(), "Error");
    }

    @Test
    void rename() {
        Node node = new Node("node1");
        node.rename("NODE");
        assertEquals("NODE", node.getName(), "Error");
    }
}
