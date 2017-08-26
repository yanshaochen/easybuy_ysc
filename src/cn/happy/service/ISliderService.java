package cn.happy.service;

import cn.happy.bean.Easybuy_slider;

import java.util.List;
import java.util.Map;

/**
 * Created by master on 17-8-26.
 */
public interface ISliderService {
    List<Easybuy_slider> getSliders();

    boolean addSlider(Map<String, String> param);

    boolean delSlider(String id);

    boolean updateSlider(Map<String, String> param);

    String getImageBySliderId(String es_id);
}
