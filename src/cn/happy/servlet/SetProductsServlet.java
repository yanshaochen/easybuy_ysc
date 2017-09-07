package cn.happy.servlet;

import cn.happy.service.ICategoryService;
import cn.happy.service.IProductService;
import cn.happy.service.impl.CategoryServiceImpl;
import cn.happy.service.impl.ProductServiceImpl;
import cn.happy.util.ParentUtil;
import cn.happy.util.SomeConverts;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
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
 *
 * Created by master on 17-8-31.
 */
@WebServlet(name = "SetProductsServlet", urlPatterns = {"/AdminServlet/SetProductsServlet"})
public class SetProductsServlet extends HttpServlet {

    private Logger logger = Logger.getLogger(SliderServlet.class);

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        //show products
        if (action != null && action.equals("show")) {
            doShow(request, response);
            return;
        }
        //update product
        if (action != null && action.equals("update")) {
            doUpdate(request, response);
            return;
        }
        if (action != null && action.equals("add")) {
            doAdd(request, response);
            return;
        }
        if (action != null && action.equals("delete")) {
            doDel(request, response);
            return;
        }
        if (action != null && action.equals("failed")) {
            request.setAttribute("operate", "set product operation failed");
            request.getRequestDispatcher("/info.jsp").forward(request, response);
        }
    }

    private void doDel(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        IProductService service = new ProductServiceImpl();
        String ep_id = request.getParameter("ep_id");
        boolean flag = service.deleteProductById(ep_id);
        if (flag)
            response.sendRedirect("/easybuy/AdminServlet/SetProductsServlet?action=show");
        else
            request.getRequestDispatcher("/AdminServlet/SetProductsServlet?action=failed").forward(request, response);
    }

    private void doAdd(HttpServletRequest request, HttpServletResponse response) {
        IProductService service = new ProductServiceImpl();
        FileItemFactory factory = new DiskFileItemFactory();
        ServletFileUpload upload = new ServletFileUpload(factory);
        List<FileItem> items;
        try {
            items = upload.parseRequest(request);
            Map<String, String> param = new SomeConverts().fileItemToGenerics(items, getServletContext());
            boolean flag = service.addProduct(param);
            if (flag)
                response.sendRedirect("/easybuy/AdminServlet/SetProductsServlet?action=show");
            else
                request.getRequestDispatcher("/AdminServlet/SetProductsServlet?action=failed").forward(request, response);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void doUpdate(HttpServletRequest request, HttpServletResponse response) {
        IProductService service = new ProductServiceImpl();
        FileItemFactory factory = new DiskFileItemFactory();
        ServletFileUpload upload = new ServletFileUpload(factory);
        List<FileItem> items;
        try {
            items = upload.parseRequest(request);
            Map<String, String> param = new SomeConverts().fileItemToGenerics(items, getServletContext());
            if (param.get("ep_img") != null && !param.get("ep_img").equals("")) {
                deleteExpiredFile(service, param.get("ep_id"));
            }
            boolean flag = service.updateProduct(param);
            if (flag)
                response.sendRedirect("/easybuy/AdminServlet/SetProductsServlet?action=show");
            else
                request.getRequestDispatcher("/AdminServlet/SetProductsServlet?action=failed").forward(request, response);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void doShow(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        ICategoryService categoryService = new CategoryServiceImpl();
        List<ParentUtil> parentUtils = categoryService.getParentUtils();
        request.setAttribute("parentUtils", parentUtils);
        request.getRequestDispatcher("/background_jsp/list.jsp").forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    private void deleteExpiredFile(IProductService service, String id) {
        String fileName = service.getImageByProductId(id);
        String leftPath = getServletContext().getRealPath("/images/");
        if (fileName != null && !fileName.equals("")) {
            File file = new File(leftPath, fileName);
            if (file.exists() && file.isFile()) {
                if (!file.delete()) {
                    logger.error("Product img delete failed-->" + leftPath + "/" + fileName);
                }
            }
        }
    }
}
