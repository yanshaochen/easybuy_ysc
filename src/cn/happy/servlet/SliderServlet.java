package cn.happy.servlet;

import cn.happy.bean.Easybuy_slider;
import cn.happy.service.ISliderService;
import cn.happy.service.impl.SliderServiceImpl;
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
 * Background function - Sliders
 * Created by master on 17-8-26.
 */
@WebServlet(name = "SliderServlet", urlPatterns = {"/AdminServlet/SliderServlet"})
public class SliderServlet extends HttpServlet {
    private Logger logger = Logger.getLogger(SliderServlet.class);

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        //show sliders
        if (action != null && action.equals("show")) {
            doShow(request, response);
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
        if (action != null && action.equals("update")) {
            doUpdate(request, response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    private void doUpdate(HttpServletRequest request, HttpServletResponse response) {
        ISliderService service = new SliderServiceImpl();
        FileItemFactory factory = new DiskFileItemFactory();
        ServletFileUpload upload = new ServletFileUpload(factory);
        List<FileItem> items;
        try {
            items = upload.parseRequest(request);
            Map<String, String> param = new SomeConverts().fileItemToGenerics(items, getServletContext());
            //delete expired file
            deleteExpiredFile(service, param.get("es_id"));
            //flush
            boolean flag = service.updateSlider(param);
            if (flag)
                response.sendRedirect("/easybuy/AdminServlet/SliderServlet?action=show");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void doDel(HttpServletRequest request, HttpServletResponse response) throws IOException {
        ISliderService service = new SliderServiceImpl();
        String id = request.getParameter("id");
        //delete expired file
        deleteExpiredFile(service, id);
        //flush
        if (service.delSlider(id)) {
            response.sendRedirect("/easybuy/AdminServlet/SliderServlet?action=show");
        }
    }

    private void doAdd(HttpServletRequest request, HttpServletResponse response) {
        ISliderService service = new SliderServiceImpl();
        FileItemFactory factory = new DiskFileItemFactory();
        ServletFileUpload upload = new ServletFileUpload(factory);
        List<FileItem> items;
        try {
            items = upload.parseRequest(request);
            Map<String, String> param = new SomeConverts().fileItemToGenerics(items, getServletContext());
            boolean flag = service.addSlider(param);
            if (flag)
                response.sendRedirect("/easybuy/AdminServlet/SliderServlet?action=show");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void doShow(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ISliderService service = new SliderServiceImpl();
        List<Easybuy_slider> sliders = service.getSliders();
        request.setAttribute("sliders", sliders);
        request.getRequestDispatcher("/background_jsp/adv.jsp").forward(request, response);
    }

    private void deleteExpiredFile(ISliderService service, String id) {
        String fileName = service.getImageBySliderId(id);
        String leftPath = getServletContext().getRealPath("/images/");
        if (fileName != null && !fileName.equals("")) {
            File file = new File(leftPath, fileName);
            if (file.exists() && file.isFile()) {
                if (!file.delete()) {
                    logger.error("Slider img delete failed-->" + leftPath + "/" + fileName);
                }
            }
        }
    }
}
