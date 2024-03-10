package servlet;

import java.io.IOException;
import java.sql.Connection;

import beans.book;
import conn.connection;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import utils.utils;

public class bookCreate {
	private static final long serialVersionUID = 1L;
    
    /**
     * @see HttpServlet#HttpServlet()
     */
    public bookCreate() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher dispatcher  = request.getServletContext()
				.getRequestDispatcher("/WEB-INF/views/nguyennhatminh_BookCreate.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String errorString = null;
		
		//Lay du lieu tren from
		String bookId = (String) request.getParameter("bookId");
		String title = (String) request.getParameter("title");
		String author = (String) request.getParameter("author");
		String Release = (String) request.getParameter("Release");
		String Price = (String) request.getParameter("Price");
		String Picture = (String) request.getParameter("Picture");
		
		
		int soLuong = 0;
		try {
			soLuong = Integer.parseInt(Release);
		} catch (Exception e) {
			errorString = e.getMessage();
		}
		float donGia = 0;
		try {
			donGia = Float.parseFloat(Price);
		} catch (Exception e) {
			errorString = e.getMessage();
		}
		book book = new book(bookId,title,author,soLuong,donGia,Picture);
		//Kiem tra code it nhat 1 ky tu
		String regex = "\\w+";
		if(bookId == null || !bookId.matches(regex)) {
			errorString = "Product code invalid!";
		}
		
		if(errorString != null) {
			request.setAttribute("errorString", errorString);
			request.setAttribute("book", book);
			RequestDispatcher dispatcher = request.getServletContext()
					.getRequestDispatcher("/WEB-INF/views/nguyennhatminh_BookCreate.jsp");
			
			dispatcher.forward(request, response);
			return;
		}
		Connection conn = null;
		try {
			conn = connection.getMSSQLConnection();
			utils.insertBook(conn, book);
			response.sendRedirect(request.getContextPath()+"/bookList");
			
		} catch (Exception e) {
			e.printStackTrace();
			errorString = e.getMessage();
			request.setAttribute("errorString", errorString);
			RequestDispatcher dispatcher = request.getServletContext()
					.getRequestDispatcher("/WEB-INF/views/nguyennhatminh_BookCreate.jsp");
			dispatcher.forward(request, response);
		}
	}
}
