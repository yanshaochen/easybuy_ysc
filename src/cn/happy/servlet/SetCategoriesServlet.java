package cn.happy.servlet;

import cn.happy.service.ICategoryService;
import cn.happy.service.ISliderService;
import cn.happy.service.impl.CategoryServiceImpl;
import org.apache.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;

/**
 * Created by master on 17-8-27.
 */
@WebServlet(name = "SetCategoriesServlet", urlPatterns = {"/AdminServlet/SetCategoriesServlet"})
public class SetCategoriesServlet extends HttpServlet {

    private Logger logger = Logger.getLogger(SliderServlet.class);

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        //show categories
        if (action != null && action.equals("show")) {
            doShow(request, response);
            return;
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    private void doShow(HttpServletRequest request, HttpServletResponse response) {
        ICategoryService service = new CategoryServiceImpl();


    }

    private void deleteExpiredFile(ISliderService service, String id) {
        String fileName = service.getImageBySliderId(id);
        String leftPath = getServletContext().getRealPath("/images/");
        File file = new File(leftPath, fileName);
        if (file.exists() && file.isFile()) {
            if (!file.delete()) {
                logger.error("file delete failed-->" + leftPath + "/" + fileName);
            }
        }
    }
}
