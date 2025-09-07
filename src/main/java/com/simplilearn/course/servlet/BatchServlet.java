package com.simplilearn.course.servlet;

import com.simplilearn.course.dao.BatchDAO;
import com.simplilearn.course.model.Batch;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.List;

@WebServlet("/batch")
public class BatchServlet extends HttpServlet {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private BatchDAO dao;

    @Override
    public void init() {
        dao = new BatchDAO();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");

        try {
            if ("edit".equals(action)) {
                int id = Integer.parseInt(req.getParameter("id"));
                Batch batch = dao.getById(id);
                req.setAttribute("batch", batch);
                req.getRequestDispatcher("edit-batch.jsp").forward(req, resp);

            } else if ("delete".equals(action)) {
                int id = Integer.parseInt(req.getParameter("id"));
                dao.deleteBatch(id);
                resp.sendRedirect("batch");

            } else {
                List<Batch> list = dao.getAllBatches();
                req.setAttribute("batches", list);
                req.getRequestDispatcher("view-batches.jsp").forward(req, resp);
            }

        } catch (Exception e) {
            throw new ServletException(e);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            int id = req.getParameter("id") != null && !req.getParameter("id").isEmpty()
                    ? Integer.parseInt(req.getParameter("id")) : 0;

            String name = req.getParameter("name");
            String timeSlot = req.getParameter("timeSlot");

            Batch batch = new Batch(id, name, timeSlot);

            if (id > 0) {
                dao.updateBatch(batch);
            } else {
                dao.addBatch(batch);
            }

            resp.sendRedirect("batch");

        } catch (Exception e) {
            throw new ServletException(e);
        }
    }
}
