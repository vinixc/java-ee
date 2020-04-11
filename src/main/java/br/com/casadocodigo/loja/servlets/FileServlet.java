package br.com.casadocodigo.loja.servlets;

import java.io.IOException;
import java.net.FileNameMap;
import java.net.URLConnection;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.casadocodigo.loja.infra.FileSaver;

@WebServlet("/file/*")
public class FileServlet extends HttpServlet{
	private static final long serialVersionUID = -2996287734967186731L;

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String path = req.getRequestURI().split("/file")[1];
		
		Path source = Paths.get(FileSaver.SERVER_PATH + "/" + path);
		FileNameMap fileNameMap = URLConnection.getFileNameMap();
		String contentType = fileNameMap.getContentTypeFor("file:"+source);
		
		resp.reset();
		resp.setContentType(contentType);
		resp.setHeader("Content-Length", String.valueOf(Files.size(source)));
		resp.setHeader("Content-Disposition", "filename=\""+source.getFileName().toString()+ "\"");
		
		FileSaver.trasfer(source,resp.getOutputStream());
	}
}
