package cn.happy.servlet;

import cn.happy.bean.Easybuy_product_parent;
import cn.happy.service.ICategoryService;
import cn.happy.service.impl.CategoryServiceImpl;
import cn.happy.util.SomeConverts;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Map;

/**
 * Background function - Classification management
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
        if (action != null && action.equals("add")) {
            doAdd(request, response);
            return;
        }
        if (action != null && action.equals("add")) {
            doAdd(request, response);
            return;
        }
        if (action != null && action.equals("failed")) {
            request.setAttribute("operate", "classification operation is failed");
            request.getRequestDispatcher("/info.jsp").forward(request, response);
        }
    }

    private void doAdd(HttpServletRequest request, HttpServletResponse response) throws IOException {
        ICategoryService service = new CategoryServiceImpl();
        String epc_id = request.getParameter("epc_id");
        String epp_id = request.getParameter("epp_id");
        /*add child required epc_id and epch_name
        * add category required epp_id and epc_name
        * add parent required file field - param
        * */
        if (epc_id != null && !epc_id.equals("")) {
            if (service.addChild(epc_id, request.getParameter("epch_name"))) {
                response.sendRedirect("/easybuy/AdminServlet/SetCategoriesServlet?action=show");
            } else {
                request.getRequestDispatcher("/AdminServlet/SetCategoriesServlet?action=failed");
            }
        } else if (epp_id != null && !epp_id.equals("")) {
            if (service.addCategory(epp_id, request.getParameter("epc_name"))) {
                response.sendRedirect("/easybuy/AdminServlet/SetCategoriesServlet?action=show");
            } else {
                request.getRequestDispatcher("/AdminServlet/SetCategoriesServlet?action=failed");
            }
        } else {
            FileItemFactory factory = new DiskFileItemFactory();
            ServletFileUpload upload = new ServletFileUpload(factory);
            List<FileItem> items;
            try {
                items = upload.parseRequest(request);
                Map<String, String> param = new SomeConverts().FileItemToGenerics(items, getServletContext());
                if (service.addParent(param)) {
                    response.sendRedirect("/easybuy/AdminServlet/SetCategoriesServlet?action=show");
                } else {
                    request.getRequestDispatcher("/AdminServlet/SetCategoriesServlet?action=failed");
                }
            } catch (FileUploadException e) {
                e.printStackTrace();
            }
        }
    }

    private void doDel(HttpServletRequest request, HttpServletResponse response) throws IOException {
        ICategoryService service = new CategoryServiceImpl();
        String epp_id = request.getParameter("epp_id");
        String epc_id = request.getParameter("epc_id");
        String epch_id = request.getParameter("epch_id");
        if (epp_id != null && !epp_id.equals("")) {
            deleteExpiredFile(service, epp_id);
            if (service.deleteCategoriesByParentId(epp_id)) {
                response.sendRedirect("/easybuy/AdminServlet/SetCategoriesServlet?action=show");
            } else {
                request.getRequestDispatcher("/AdminServlet/SetCategoriesServlet?action=failed");
            }
        } else if (epc_id != null && !epc_id.equals("")) {
            if (service.deleteCategoriesByCategoryId(epc_id)) {
                response.sendRedirect("/easybuy/AdminServlet/SetCategoriesServlet?action=show");
            } else {
                request.getRequestDispatcher("/AdminServlet/SetCategoriesServlet?action=failed");
            }
        } else if (epch_id != null && !epch_id.equals("")) {
            if (service.deleteCategoriesByChildId(epch_id)) {
                response.sendRedirect("/easybuy/AdminServlet/SetCategoriesServlet?action=show");
            } else {
                request.getRequestDispatcher("/AdminServlet/SetCategoriesServlet?action=failed");
            }
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
