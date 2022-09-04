package me.chrisanabo.jetty.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.eclipse.jetty.http.HttpStatus;


@WebServlet(name = "bank-callback", urlPatterns = {"bank-callback"}, loadOnStartup = 1)
public class MessageCallbackServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

		resp.setStatus(HttpStatus.OK_200);
		resp.getWriter().println("EmbeddedJetty");
	}
}
