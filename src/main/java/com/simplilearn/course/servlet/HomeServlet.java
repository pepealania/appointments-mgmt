package com.simplilearn.course.servlet;

import com.simplilearn.course.dao.BatchDAO;
import com.simplilearn.course.model.Batch;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.List;

@WebServlet("/home")
public class HomeServlet extends HttpServlet {
    private BatchDAO dao;

    @Override
    public void init() {
        dao = new BatchDAO();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        List<Batch> batches;
		try {
			batches = dao.getAllBatches();
	        req.setAttribute("batches", batches);
	        req.getRequestDispatcher("menu.jsp").forward(req, resp);
        } catch (Exception e) {
            throw new ServletException(e);
        }
    }
}
