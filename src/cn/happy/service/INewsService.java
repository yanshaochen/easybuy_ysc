package cn.happy.service;

import cn.happy.bean.Easybuy_news;
import cn.happy.util.PageUtil;

import java.util.List;

/**
 * Created by master on 17-9-4.
 */
public interface INewsService {
    List<Easybuy_news> getNewsByPage(PageUtil page, String searchKey);

    int getNewsTotalRecords(String searchKey);

    Easybuy_news getNewsById(String en_id);

    boolean deleteNews(String en_id);

    boolean updateNews(String en_id, String en_title, String en_content);

    boolean addNews(String en_title, String en_content);
}
