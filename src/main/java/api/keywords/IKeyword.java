package api.keywords;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

//ToDo in future this interface must contain common logic for all keywords,
// now it is just a placeholder with Logger logic
public interface IKeyword {

    Logger logger = LogManager.getRootLogger();
    String DEFAULT_LOGGER_MESSAGE = "step is executing";

}
