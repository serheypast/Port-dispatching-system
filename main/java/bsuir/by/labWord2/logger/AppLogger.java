package bsuir.by.labWord2.logger;


import org.apache.log4j.Logger;
/**
 * Created by Сергей on 20.03.2017.
 */
public class AppLogger {

    /** logger object from log4j library*/
    private static final Logger log = Logger.getLogger(AppLogger.class);

    /**
     * @return Logger object
     */
    public static Logger getLogger(){
        return log;
    }
}
