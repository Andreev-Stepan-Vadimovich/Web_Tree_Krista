
import javax.ws.rs.core.Application;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Web-приложение в котором регистрируются все ресурсы.
 */
public class RestApplication extends Application {

    private List<String> list = new ArrayList<>();
    Node node = new Node("root");

    public RestApplication() {
        list.add("aaa");
        list.add("bbb");
        list.add("ccc");
        list.add("ddd");

        node.addNewNode("node2");
        node.addNewNode("node3");
        node.getChildren().get(1).addNewNode("node4");
    }

    /**
     * Возвращает список всех ресурсов web-приложения.
     * @return список всех ресурсов web-приложения.
     */
    @Override
    public Set<Object> getSingletons() {
        Set<Object> resources = new HashSet<>();
        resources.add(new ListPresentationController(list));
        resources.add(new TreePresentationController(node));
        resources.add(new LoginController());
        return resources;
    }
}
