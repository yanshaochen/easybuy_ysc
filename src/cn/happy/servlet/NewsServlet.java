package cn.happy.servlet;

import cn.happy.service.INewsService;
import cn.happy.service.impl.NewsServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by master on 17-9-4.
 */
@WebServlet(name = "NewsServlet", urlPatterns = {"/AdminServlet/NewsServlet"})
public class NewsServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action != null && action.equals("show")) {
            doShow(request, response);
            return;
        }
        if (action != null && action.equals("add")) {
            doAdd(request, response);
            return;
        }
        if (action != null && action.equals("update")) {
            doUpdate(request, response);
            return;
        }
        if (action != null && action.equals("delete")) {
            doDel(request, response);
            return;
        }
        if (action != null && action.equals("failed")) {
            request.setAttribute("operate", "set news operation failed");
            request.getRequestDispatcher("/info.jsp").forward(request, response);
        }
    }

    private void doDel(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String en_id = request.getParameter("en_id");
        INewsService service = new NewsServiceImpl();
        boolean flag = service.deleteNews(en_id);
        if (flag)
            response.sendRedirect("/easybuy/AdminServlet/NewsServlet?action=show");
        else
            request.getRequestDispatcher("/AdminServlet/NewsServlet?action=failed").forward(request, response);
    }

    private void doUpdate(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String en_title = request.getParameter("en_title");
        String en_content = request.getParameter("en_content");
        String en_id = request.getParameter("en_id");
        INewsService service = new NewsServiceImpl();
        boolean flag = service.updateNews(en_id, en_title, en_content);
        if (flag)
            response.sendRedirect("/easybuy/AdminServlet/NewsServlet?action=show");
        else
            request.getRequestDispatcher("/AdminServlet/NewsServlet?action=failed").forward(request, response);
    }

    private void doAdd(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String en_title = request.getParameter("en_title");
        String en_content = request.getParameter("en_content");
        INewsService service = new NewsServiceImpl();
        boolean flag = service.addNews(en_title, en_content);
        if (flag)
            response.sendRedirect("/easybuy/AdminServlet/NewsServlet?action=show");
        else
            request.getRequestDispatcher("/AdminServlet/NewsServlet?action=failed").forward(request, response);
    }

    private void doShow(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/background_jsp/news.jsp").forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
