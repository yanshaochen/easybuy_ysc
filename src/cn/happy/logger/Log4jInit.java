package cn.happy.logger;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * Created by master on 17-8-23.
 */
public class Log4jInit extends HttpServlet {
    static Logger logger = Logger.getLogger(Log4jInit.class);

    public Log4jInit() {

    }

    public void init(ServletConfig config) throws ServletException {
        //get the real path until / -> RealPath/
        String prefix = config.getServletContext().getRealPath("/");
        //file="WEB-INF/log4j.properties"
        String file = config.getInitParameter("log4j");
        //the path is RealPath/WEB-INF/log4j.properties
        String filePath = prefix + file;
        Properties props = new Properties();
        try {
            FileInputStream istream = new FileInputStream(filePath);
            props.load(istream);
            istream.close();
            String DebugLogFile = prefix + props.getProperty("log4j.appender.D.File");
            props.setProperty("log4j.appender.D.File", DebugLogFile);
            String ErrorLogFile = prefix + props.getProperty("log4j.appender.E.File");
            props.setProperty("log4j.appender.E.File", ErrorLogFile);
            PropertyConfigurator.configure(props);
        } catch (IOException e) {
            System.out.println("Could not read configuration file [" + filePath + "].");
            System.out.println("Ignoring configuration file [" + filePath + "].");
            return;
        }
    }
}
