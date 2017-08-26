package cn.happy.service.impl;

import cn.happy.bean.Easybuy_slider;
import cn.happy.dao.ISliderDAO;
import cn.happy.dao.impl.SliderDAOImpl;
import cn.happy.service.ISliderService;

import java.util.List;
import java.util.Map;

/**
 * Created by master on 17-8-26.
 */
public class SliderServiceImpl implements ISliderService {
    @Override
    public List<Easybuy_slider> getSliders() {
        ISliderDAO dao = new SliderDAOImpl();
        try {
            return dao.getSliders();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public boolean addSlider(Map<String, String> param) {
        ISliderDAO dao = new SliderDAOImpl();
        try {
            return dao.addSlider(param);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean delSlider(String id) {
        ISliderDAO dao = new SliderDAOImpl();
        try {
            return dao.delSlider(id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean updateSlider(Map<String, String> param) {
        ISliderDAO dao = new SliderDAOImpl();
        try {
            return dao.updateSlider(param);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public String getImageBySliderId(String es_id) {
        ISliderDAO dao = new SliderDAOImpl();
        try {
            return dao.getImageBySliderId(es_id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
