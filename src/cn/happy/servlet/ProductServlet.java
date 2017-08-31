package cn.happy.servlet;

import cn.happy.bean.Easybuy_product;
import cn.happy.bean.Easybuy_slider;
import cn.happy.service.ICategoryService;
import cn.happy.service.IProductService;
import cn.happy.service.ISliderService;
import cn.happy.service.impl.CategoryServiceImpl;
import cn.happy.service.impl.ProductServiceImpl;
import cn.happy.service.impl.SliderServiceImpl;
import cn.happy.util.ParentUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 *
 * Created by master on 17-8-23.
 */
@WebServlet(name = "ProductServlet", urlPatterns = {"/UserServlet/ProductServlet"})
public class ProductServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //show category
        ICategoryService categoryService = new CategoryServiceImpl();
        List<ParentUtil> parentUtils = categoryService.getParentUtils();
        request.setAttribute("parentUtils", parentUtils);
        //show top10 and limit
        IProductService productService = new ProductServiceImpl();
        List<Easybuy_product> top10 = productService.getTop10();
        List<Easybuy_product> limit8 = productService.getLimit();
        request.setAttribute("top10", top10);
        request.setAttribute("limit8", limit8);
        //sliders
        ISliderService sliderService = new SliderServiceImpl();
        List<Easybuy_slider> sliders = sliderService.getSliders();
        request.setAttribute("sliders", sliders);
        //dispatch
        request.getRequestDispatcher("/index.jsp").forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
