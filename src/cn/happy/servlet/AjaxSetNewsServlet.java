package cn.happy.servlet;

import cn.happy.bean.Easybuy_news;
import cn.happy.service.INewsService;
import cn.happy.service.impl.NewsServiceImpl;
import cn.happy.util.PageUtil;
import cn.happy.util.SomeConverts;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * Created by master on 17-9-4.
 */
@WebServlet(name = "AjaxSetNewsServlet", urlPatterns = {"/AdminServlet/AjaxSetNewsServlet"})
public class AjaxSetNewsServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String pageIndex = request.getParameter("pageIndex");
        PageUtil page = new PageUtil();
        if (pageIndex != null && !pageIndex.equals("")) {
            page.setPageIndex(Integer.parseInt(pageIndex));
        } else {
            page.setPageIndex(1);
        }
        String searchKey = request.getParameter("searchKey");
        if (searchKey == null) {
            searchKey = "";
        } else {
            if (searchKey.equals(new String(searchKey.getBytes("ISO-8859-1"), "ISO-8859-1")))
                searchKey = new String(searchKey.getBytes("ISO-8859-1"), "utf-8");
        }
        INewsService service = new NewsServiceImpl();
        page.setTotalCount(service.getNewsTotalRecords(searchKey));
        List<Easybuy_news> newsList = service.getNewsByPage(page, searchKey);
        if (newsList.size() != 0) {
            newsList.get(0).setPageUtil(page);
        }
        new SomeConverts().ajaxWrite(newsList, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
