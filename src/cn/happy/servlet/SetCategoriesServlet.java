package cn.happy.servlet;

import cn.happy.bean.Easybuy_product_parent;
import cn.happy.service.ICategoryService;
import cn.happy.service.impl.CategoryServiceImpl;
import org.apache.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.util.List;

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
        if (action != null && action.equals("delete")) {
            doDel(request, response);
            return;
        }
    }

    private void doDel(HttpServletRequest request, HttpServletResponse response) throws IOException {
        ICategoryService service = new CategoryServiceImpl();
        String epp_id = request.getParameter("epp_id");
        deleteExpiredFile(service, epp_id);
        if (service.deleteCategoriesByid(epp_id)) {
            response.sendRedirect("/easybuy/AdminServlet/SetCategoriesServlet?action=show");
        }
    }

    private void doShow(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ICategoryService service = new CategoryServiceImpl();
        List<Easybuy_product_parent> parents = service.getParents();
        request.setAttribute("parents", parents);
        request.getRequestDispatcher("/background_jsp/category.jsp").forward(request, response);
    }

    private void deleteExpiredFile(ICategoryService service, String id) {
        String fileName = service.getImageByParentId(id);
        String leftPath = getServletContext().getRealPath("/images/");
        if (fileName != null && !fileName.equals("")) {
            File file = new File(leftPath, fileName);
            if (file.exists() && file.isFile()) {
                if (!file.delete()) {
                    logger.error("Parent img delete failed-->" + leftPath + "/" + fileName);
                }
            }
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
