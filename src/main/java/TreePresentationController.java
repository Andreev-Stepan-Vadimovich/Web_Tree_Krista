import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

@Path("/")
public class TreePresentationController {
    private Node root;

    public TreePresentationController(Node root) {
        this.root = root;
    }

    //------------------------------------------------------------------------------------------------------------------
    @GET
    @Path("example")
    @Produces("text/plain")
    public String getSimpleText() {
        return "hello world";
    }

    //------------------------------------------------------------------------------------------------------------------
    @GET
    @Path("/")
    @Produces("text/html")
    public String getList() {
        String result =
                "<html>" +
                        "  <head>" +
                        "    <title>Tree presentation</title>" +
                        "  </head>" +
                        "  <body>" +
                        "    <h1>Tree</h1>";

        result += root.toHTMLTreeStructure(0);

        result +=  "      <br/>" +
                "      <form method=\"post\" action=\"add_random_item\">" +
                "        <input type=\"submit\" value=\"Add random item\"/>" +
                "      </form>" +
                "  </body>" +
                "</html>";
        return result;
    }

    //------------------------------------------------------------------------------------------------------------------
    @POST
    @Path("add_random_item")
    @Produces("text/html")
    public Response addRandomItem() {
        root.addNewNode("randomNode");
        try {
            return Response.seeOther(new URI("/")).build();
        } catch (URISyntaxException e) {
            throw new IllegalStateException("Ошибка построения URI для перенаправления");
        }
    }

    //------------------------------------------------------------------------------------------------------------------
    @GET
    @Path("/edit/{id}")
    @Produces("text/html")
    public String getEditPage(@PathParam("id") int itemId) {
        Node treeItem = root.findNode(itemId);
        String result =
                "<html>" +
                        "  <head>" +
                        "    <title>Редактирование элемента дерева</title>" +
                        "  </head>" +
                        "  <body>" +
                        "    <h1>Редактирование элемента дерева</h1>" +
                        "    <form method=\"post\" action=\"/edit/" + itemId + "\">" +
                        "      <p>Значение</p>" +
                        "      <input type=\"text\" name=\"value\" value=\"" + treeItem.getName() +"\"/>" +
                        "      <input type=\"submit\"/>" +
                        "    </form>";

        result +=       "    <form method=\"post\" action=\"/deleteForId/" + itemId + "\">" +
                        "      <p>ID для удаления</p>" +
                        "      <input type=\"text\" name=\"value\" value=\"" + null +"\"/>" +
                        "      <input type=\"submit\"/>" +
                        "     </form>";

        result +=       "<form method=\"post\" action=\"Delete_all_children\">" +
                        "        <input type=\"submit\" value=\"Delete all children\"/>" +
                        " </form>";

        result +=       "  </body>" +
                        "</html>";
        return result;
    }

    //------------------------------------------------------------------------------------------------------------------
    @POST
    @Path("/edit/{id}")
    @Produces("text/html")
    public Response editItem(@PathParam("id") int itemId, @FormParam("value") String itemValue) {
        Node wr = root.findNode(itemId);
        wr.rename(itemValue);
        try {
            return Response.seeOther(new URI("/")).build();
        } catch (URISyntaxException e) {
            throw new IllegalStateException("Ошибка построения URI для перенаправления");
        }
    }

    //------------------------------------------------------------------------------------------------------------------
    @POST
    @Path("/deleteForId/{id}")
    @Produces("text/html")
    public Response deleteForId(@PathParam("id") int itemId, @FormParam("value") int deleteID) {
        root.deleteNodeForID(deleteID);
        try {
            return Response.seeOther(new URI("/")).build();
        } catch (URISyntaxException e) {
            throw new IllegalStateException("Ошибка построения URI для перенаправления");
        }
    }

    //------------------------------------------------------------------------------------------------------------------
    @POST
    @Path("/edit/Delete_all_children")
    @Produces("text/html")
    public Response deleteAllChildren(@PathParam("id") int itemId) {
        root.deleteAllChildren();
        try {
            return Response.seeOther(new URI("/")).build();
        } catch (URISyntaxException e) {
            throw new IllegalStateException("Ошибка построения URI для перенаправления");
        }
    }
}
