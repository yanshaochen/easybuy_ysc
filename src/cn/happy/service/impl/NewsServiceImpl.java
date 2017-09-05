package cn.happy.service.impl;

import cn.happy.bean.Easybuy_news;
import cn.happy.dao.INewsDAO;
import cn.happy.dao.impl.NewsDAOImpl;
import cn.happy.service.INewsService;
import cn.happy.util.PageUtil;
import org.apache.log4j.Logger;

import java.util.List;

/**
 * Created by master on 17-9-4.
 */
public class NewsServiceImpl implements INewsService {
    Logger logger = Logger.getLogger(NewsServiceImpl.class);

    @Override
    public List<Easybuy_news> getNewsByPage(PageUtil page, String searchKey) {
        INewsDAO dao = new NewsDAOImpl();
        try {
            return dao.getNewsByPage(page, searchKey);
        } catch (Exception e) {
            logger.error(e);
        }
        return null;
    }

    @Override
    public int getNewsTotalRecords(String searchKey) {
        INewsDAO dao = new NewsDAOImpl();
        try {
            return dao.getNewsTotalRecords(searchKey);
        } catch (Exception e) {
            logger.error(e);
        }
        return -1;
    }

    @Override
    public Easybuy_news getNewsById(String en_id) {
        INewsDAO dao = new NewsDAOImpl();
        try {
            return dao.getNewsById(en_id);
        } catch (Exception e) {
            logger.error(e);
        }
        return null;
    }

    @Override
    public boolean deleteNews(String en_id) {
        INewsDAO dao = new NewsDAOImpl();
        try {
            return dao.deleteNews(en_id);
        } catch (Exception e) {
            logger.error(e);
        }
        return false;
    }

    @Override
    public boolean updateNews(String en_id, String en_title, String en_content) {
        INewsDAO dao = new NewsDAOImpl();
        try {
            return dao.updateNews(en_id, en_title, en_content);
        } catch (Exception e) {
            logger.error(e);
        }
        return false;
    }

    @Override
    public boolean addNews(String en_title, String en_content) {
        INewsDAO dao = new NewsDAOImpl();
        try {
            return dao.addNews(en_title, en_content);
        } catch (Exception e) {
            logger.error(e);
        }
        return false;
    }
}
