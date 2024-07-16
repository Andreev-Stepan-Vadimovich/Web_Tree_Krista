import java.util.ArrayList;

public class Node {
    //Fields
    static int ID_FOR_NEW_NODE = 1;
    String name;
    int ID;
    ArrayList<Node> children = new ArrayList<Node>();

    //Constructors
    public Node(String name) {
        this.name = name;
        this.ID = ID_FOR_NEW_NODE;
        ++ID_FOR_NEW_NODE;
    }

    //Getters
    public String getName() {
        return name;
    }
    public int getID() {
        return ID;
    }
    public ArrayList<Node> getChildren() { return children; }

    //Methods
    public void showNode() {
        System.out.println("Name: " + name);
        System.out.println("ID: " + ID);
        System.out.print("Children: ");
        if (children.size() == 0) System.out.println("NULL");
        for (int i = 0; i < children.size(); ++i) System.out.print(children.get(i).getName() + ' ');
        System.out.println('\n');
    }
    public void showTree() {
        showNode();
        for (int i = 0; i < children.size(); ++i) {
            children.get(i).showTree();
        }
    }

    public void addNewNode(String name) {
        Node newNode = new Node(name);
        this.children.add(newNode);
    }

    public Node findNode(String name) {
        Node ans = null;
        if (this.name.equals(name)) return this;
        for (int i = 0; i < children.size(); ++i) {
            if (ans != null) break;
            ans = children.get(i).findNode(name);
        }
        return ans;
    }

    public void deleteNodeForName(String name) {
        for (int i = 0; i < children.size(); ++i) {
            if (children.get(i).getName().equals(name)) {
                children.remove(i);
                return;
            }
            children.get(i).deleteNodeForName(name);
        }
    }

    public void deleteNodeForID(int ID) {
        for (int i = 0; i < children.size(); ++i) {
            if (children.get(i).getID() == ID) {
                children.remove(i);
                return;
            }
            children.get(i).deleteNodeForID(ID);
        }
    }

    public void deleteAllChildren() {
        for (int i = 0; i < children.size(); ++i) {
            this.children.get(i).deleteAllChildren();
        }
        children.clear();
    }

    public void rename(String newName) {
        this.name = newName;
    }

    public void copyOfNode(Node other) {
        this.name = other.name;
    }

    public String toString(int lvl) {
        String ans = "";
        for (int i = 0; i < lvl; ++i) ans += '\t';
        ans += this.name + '\n';
        for (int i = 0; i < children.size(); ++i) ans += children.get(i).toString(lvl + 1);
        return ans;
    }

    public String toHTMLTreeStructure(int lvl) {
        String ans = "";
        if (lvl == 0) ans += "<ul>\n";

        for (int i = 0; i < lvl; ++i) ans += '\t';

        ans += "<li>" + this.name + "</li>" + '\n';

        if(children.size() > 0) {
            for (int i = 0; i < lvl; ++i) ans += '\t';
            ans += "<ul>\n";
        }
        for (int i = 0; i < children.size(); ++i) ans += children.get(i).toHTMLTreeStructure(lvl + 1);
        if(children.size() > 0) {
            for (int i = 0; i < lvl; ++i) ans += '\t';
            ans += "</ul>\n";
        }

        if (lvl == 0) ans += "</ul>\n";
        return ans;
    }

    public String makeHTMLFile() {
        String ans = "";
        ans += "<!DOCTYPE html>\n<head>\n";
        ans += toHTMLTreeStructure(0);
        ans += "</head>";
        return ans;
    }

    public void printAsText(int lvl) {
        for (int i = 0; i < lvl; ++i) System.out.print('\t');
        System.out.println(this.name);
        for (int i = 0; i < children.size(); ++i) children.get(i).printAsText(lvl + 1);
    }
}

