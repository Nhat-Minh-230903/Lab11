package servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import beans.book;
import conn.connection;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import utils.utils;

public class bookList {
	private static final long serialVersionUID = 1L;
    
    /**
     * @see HttpServlet#HttpServlet()
     */
    public bookList() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Connection conn = null;
		String errorString = null;
		String successString = "Ok";
		List<book> list = null;
		try {
			conn = connection.getMSSQLConnection();
			try {
				list = utils.queryBooks(conn);
			} catch (Exception e) {
				e.printStackTrace();
				errorString = e.getMessage();
			}
			
			request.setAttribute("errorString", errorString);
			for (book book : list) {
				successString = book.getBookId();
			}
			request.setAttribute("successString", successString);
			request.setAttribute("bookList", list);
			
			RequestDispatcher dispatcher = request.getServletContext()
					.getRequestDispatcher("/src/main/webapp/WEB-INF/views/nguyennhatminh_BookList.jsp");
			dispatcher.forward(request, response);
		} catch (ClassNotFoundException| SQLException e1) {
			e1.printStackTrace();
			errorString = e1.getMessage();
			
			RequestDispatcher dispatcher = request.getServletContext()
					.getRequestDispatcher("/src/main/webapp/WEB-INF/views/nguyennhatminh_BookList.jsp");
			request.setAttribute("errorString", errorString);
			dispatcher.forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
