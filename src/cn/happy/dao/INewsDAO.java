package cn.happy.dao;

import cn.happy.bean.Easybuy_news;
import cn.happy.util.PageUtil;

import java.util.List;

/**
 * Created by master on 17-9-4.
 */
public interface INewsDAO {
    List<Easybuy_news> getNewsByPage(PageUtil page, String searchKey) throws Exception;

    int getNewsTotalRecords(String searchKey) throws Exception;

    Easybuy_news getNewsById(String en_id) throws Exception;

    boolean deleteNews(String en_id) throws Exception;

    boolean updateNews(String en_id, String en_title, String en_content) throws Exception;

    boolean addNews(String en_title, String en_content) throws Exception;
}
