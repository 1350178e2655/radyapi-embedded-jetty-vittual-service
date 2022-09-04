package me.chrisanabo.jetty;

import me.chrisanabo.jetty.filter.MessageEncryptionFilter;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.FilterHolder;
import org.eclipse.jetty.servlet.ServletContextHandler;
import me.chrisanabo.jetty.servlet.MessageCallbackServlet;

import javax.servlet.DispatcherType;
import java.util.EnumSet;

public class PBankCallbackMain {

	static final int PORT = 8080;

	static Server server = null;

	public static void startServer(int port) throws Exception {

		String value = System.getProperty("read_from_minus_d");
		String log_dir = System.getenv("read_from_env_variable");
		String contextPath =  System.getenv("read_from_env_variable");


		Server server = new Server(PORT);
		ServletContextHandler context = new ServletContextHandler(server, "/bank");
		context.addServlet(MessageCallbackServlet.class, "/callback");

		final EnumSet<DispatcherType> REQUEST_SCOPE = EnumSet.of(DispatcherType.REQUEST);

		context.addFilter( MessageEncryptionFilter.class, "/*", REQUEST_SCOPE );
		server.start();

	}


	public static void main(String[] args) throws Exception {
		int port = PORT;
		System.out.println("Starting Jetty server on port " + port);
		startServer( port );
	}

	public static void stopServer() throws Exception {
		if (server != null && server.isRunning()) server.stop();
	}

}
