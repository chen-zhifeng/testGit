package com.juric.portal.http;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: EricChen
 * Date: 8/12/15
 * Time: 10:16 PM
 * To change this template use File | Settings | File Templates.
 */
@Controller
public class JspController {

    @RequestMapping("/article/{articleId}")
    String article(@PathVariable("id") long articleId, Map<String, Object> model) {
        model.put("message", "Hello World!");
        return "index";
    }
}
