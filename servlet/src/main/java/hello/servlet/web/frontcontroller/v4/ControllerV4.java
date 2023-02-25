package hello.servlet.web.frontcontroller.v4;

import java.util.HashMap;

public interface ControllerV4 {
    /**
     * @param paramMap
     * @param model
     * @return viewName
     */
    String process(HashMap<String, String> paramMap, HashMap<String, Object> model);
}
