package cn.happy.servlet;

import cn.happy.bean.Easybuy_news;
import cn.happy.service.INewsService;
import cn.happy.service.impl.NewsServiceImpl;
import cn.happy.util.SomeConverts;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by master on 17-9-4.
 */
@WebServlet(name = "AjaxGetNewsByIdServlet", urlPatterns = {"/AdminServlet/AjaxGetNewsByIdServlet"})
public class AjaxGetNewsByIdServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String en_id = request.getParameter("en_id");
        INewsService service = new NewsServiceImpl();
        Easybuy_news news = service.getNewsById(en_id);
        new SomeConverts().ajaxWrite(news, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
