package com.simplilearn.course.servlet;

import com.simplilearn.course.dao.ParticipantDAO;
import com.simplilearn.course.model.Participant;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.List;

@WebServlet("/participant")
public class ParticipantServlet extends HttpServlet {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private ParticipantDAO dao;

    public void init() {
        dao = new ParticipantDAO();
    }

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");

        try {
            if ("edit".equals(action)) {
                int id = Integer.parseInt(req.getParameter("id"));
                Participant p = dao.getById(id);
                req.setAttribute("participant", p);
                req.getRequestDispatcher("edit-participant.jsp").forward(req, resp);
            } else if ("delete".equals(action)) {
                int id = Integer.parseInt(req.getParameter("id"));
                dao.deleteParticipant(id);
                resp.sendRedirect("participant");
            } else {
                List<Participant> list = dao.getAllParticipants();
                req.setAttribute("participants", list);
                req.getRequestDispatcher("view-participants.jsp").forward(req, resp);
            }
        } catch (Exception e) {
            throw new ServletException(e);
        }
    }

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            int id = req.getParameter("id") != null && !req.getParameter("id").isEmpty()
                    ? Integer.parseInt(req.getParameter("id")) : 0;
            String name = req.getParameter("name");
            int age = Integer.parseInt(req.getParameter("age"));
            String email = req.getParameter("email");
            int batchId = Integer.parseInt(req.getParameter("batchId"));

            Participant p = new Participant(id, name, age, email, batchId);
            if (id > 0) {
                dao.updateParticipant(p);
            } else {
                dao.addParticipant(p);
            }

            resp.sendRedirect("participant");
        } catch (Exception e) {
            throw new ServletException(e);
        }
    }
}
