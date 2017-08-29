package cn.happy.dao.impl;

import cn.happy.bean.Easybuy_slider;
import cn.happy.dao.BaseDAO;
import cn.happy.dao.ISliderDAO;
import cn.happy.util.SomeConverts;

import java.sql.ResultSet;
import java.util.List;
import java.util.Map;

/**
 * Slider Manager
 * Created by master on 17-8-26.
 */
public class SliderDAOImpl extends BaseDAO implements ISliderDAO {
    @Override
    public List<Easybuy_slider> getSliders() throws Exception {
        String sql = "select * from easybuy_slider order by es_sort asc;";
        ResultSet resultSet = executeQuery(sql);
        List<Easybuy_slider> sliders = new SomeConverts().ResultSetToGenerics(resultSet, Easybuy_slider.class);
        resultSet.close();
        closeResources();
        return sliders;
    }

    @Override
    public boolean addSlider(Map<String, String> param) throws Exception {
        String sql = "insert into easybuy_slider values(default,?,?,?,?);";
        int count = executeUpdate(sql, param.get("es_img"), param.get("es_servleturl"), param.get("es_title"), param.get("es_sort"));
        closeResources();
        return count > 0;
    }

    @Override
    public boolean delSlider(String id) throws Exception {
        String sql = "delete from easybuy_slider where es_id=?;";
        int count = executeUpdate(sql, id);
        closeResources();
        return count > 0;
    }

    @Override
    public boolean updateSlider(Map<String, String> param) throws Exception {
        String sql = "update easybuy_slider set es_img=?,es_servleturl=?,es_title=?,es_sort=? where es_id=?;";
        int count = executeUpdate(sql, param.get("es_img"), param.get("es_servleturl"), param.get("es_title"), param.get("es_sort"), param.get("es_id"));
        closeResources();
        return count > 0;
    }

    @Override
    public String getImageBySliderId(String es_id) throws Exception {
        String sql = "select es_img from easybuy_slider where es_id=?;";
        ResultSet resultSet = executeQuery(sql, es_id);
        String es_img = null;
        if (resultSet.next()) {
            es_img = resultSet.getString("es_img");
        }
        resultSet.close();
        closeResources();
        return es_img;
    }
}
