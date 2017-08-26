package cn.happy.dao;

import cn.happy.bean.Easybuy_slider;

import java.util.List;
import java.util.Map;

/**
 * Created by master on 17-8-26.
 */
public interface ISliderDAO {
    List<Easybuy_slider> getSliders() throws Exception;

    boolean addSlider(Map<String, String> param) throws Exception;

    boolean delSlider(String id) throws Exception;

    boolean updateSlider(Map<String, String> param) throws Exception;

    String getImageBySliderId(String es_id) throws Exception;
}
