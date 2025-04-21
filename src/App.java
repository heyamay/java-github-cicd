import com.sun.net.httpserver.HttpServer;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpExchange;
import java.io.OutputStream;

public class App {
    public static void main(String[] args) throws Exception {
	HttpServer server = HttpServer.create(new java.net.InetSocketAddress("0.0.0.0", 8080), 0);
        server.createContext("/", new MyHandler());
        server.setExecutor(null);
        server.start();
        System.out.println("Server started on port 8080");
    }

    static class MyHandler implements HttpHandler {
        public void handle(HttpExchange t) throws java.io.IOException {
            String response = "🚀 Hello Amay Jaiswal from Java Bitbucket CI/CD Pipeline!";
            t.sendResponseHeaders(200, response.length());
            OutputStream os = t.getResponseBody();
            os.write(response.getBytes());
            os.close();
        }
    }
}
