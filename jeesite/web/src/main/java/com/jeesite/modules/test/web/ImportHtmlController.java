package com.jeesite.modules.test.web;


import com.jeesite.common.web.BaseController;
import com.jeesite.modules.test.entity.TestData;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value =  "${adminPath}/html/importHtml")
public class ImportHtmlController extends BaseController {


    @RequiresPermissions("test:testData:view")
    @RequestMapping(value = "form")
    public String form(TestData testData, Model model) {
        model.addAttribute("testData", testData);
        return "modules/test/importHtmlForm";
    }


}
