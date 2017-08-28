package cn.happy.servlet;

import cn.happy.bean.Easybuy_product;
import cn.happy.bean.Easybuy_product_parent;
import cn.happy.bean.Easybuy_slider;
import cn.happy.service.ICategoryService;
import cn.happy.service.ISliderService;
import cn.happy.service.ITop10Service;
import cn.happy.service.impl.CategoryServiceImpl;
import cn.happy.service.impl.SliderServiceImpl;
import cn.happy.service.impl.Top10ServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * Created by master on 17-8-23.
 */
@WebServlet(name = "ProductServlet", urlPatterns = {"/UserServlet/ProductServlet"})
public class ProductServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //show category
        ICategoryService categoryService = new CategoryServiceImpl();
        List<Easybuy_product_parent> parents = categoryService.getParents();
        request.setAttribute("parents", parents);
        //show top10
        ITop10Service tops = new Top10ServiceImpl();
        List<Easybuy_product> top10 = tops.getTop10();
        request.setAttribute("top10", top10);
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
