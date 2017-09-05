package cn.happy.dao.impl;

import cn.happy.bean.Easybuy_news;
import cn.happy.dao.BaseDAO;
import cn.happy.dao.INewsDAO;
import cn.happy.util.PageUtil;
import cn.happy.util.SomeConverts;

import java.sql.ResultSet;
import java.util.List;

/**
 * Created by master on 17-9-4.
 */
public class NewsDAOImpl extends BaseDAO implements INewsDAO {
    @Override
    public List<Easybuy_news> getNewsByPage(PageUtil page, String searchKey) throws Exception {
        String sql = "select en_id,en_title,en_content,en_create_time,en_modify_time from easybuy_news where en_title like '%" + searchKey + "%' order by en_create_time desc limit ?,?;";
        ResultSet resultSet = executeQuery(sql, (page.getPageIndex() - 1) * page.getPageSize(), page.getPageSize());
        List<Easybuy_news> newsList = new SomeConverts().resultSetToGenerics(resultSet, Easybuy_news.class);
        resultSet.close();
        closeResources();
        return newsList;
    }

    @Override
    public int getNewsTotalRecords(String searchKey) throws Exception {
        int count = 0;
        String sql = "select count(1) as count from easybuy_news where en_title like '%" + searchKey + "%';";
        ResultSet resultSet = executeQuery(sql);
        if (resultSet.next()) {
            count = resultSet.getInt("count");
        }
        return count;
    }

    @Override
    public Easybuy_news getNewsById(String en_id) throws Exception {
        String sql = "select en_title,en_content from easybuy_news where en_id=?;";
        ResultSet resultSet = executeQuery(sql, en_id);
        List<Easybuy_news> newsList = new SomeConverts().resultSetToGenerics(resultSet, Easybuy_news.class);
        resultSet.close();
        closeResources();
        return newsList.get(0);
    }

    @Override
    public boolean deleteNews(String en_id) throws Exception {
        String sql = "delete from easybuy_news where en_id=?;";
        int count = executeUpdate(sql, en_id);
        return count > 0;
    }

    @Override
    public boolean updateNews(String en_id, String en_title, String en_content) throws Exception {
        String sql = "update easybuy_news set en_title=?,en_content=?,en_modify_time=now() where en_id=?;";
        int count = executeUpdate(sql, en_title, en_content, en_id);
        return count > 0;
    }

    @Override
    public boolean addNews(String en_title, String en_content) throws Exception {
        String sql = "insert into easybuy_news (en_title,en_content,en_create_time) values(?,?,now());";
        int count = executeUpdate(sql, en_title, en_content);
        return count > 0;
    }
}
