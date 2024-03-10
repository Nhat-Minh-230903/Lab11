package servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import conn.connection;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import utils.utils;

public class bookDelete {
	private static final long serialVersionUID = 1L;
    
    /**
     * @see HttpServlet#HttpServlet()
     */
    public bookDelete() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//Lay du lieu tren from
		String maSach = (String) request.getParameter("maSach");
		Connection conn = null;
        String errorString = null;

        try {
            conn = connection.getMSSQLConnection();
            utils.deleteBook(conn, maSach);
        } catch (ClassNotFoundException | SQLException  e) {
            e.printStackTrace();
            errorString = e.getMessage();
        }

        if (errorString != null) {
        } else {
            response.sendRedirect(request.getContextPath()+"/bookList");
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
