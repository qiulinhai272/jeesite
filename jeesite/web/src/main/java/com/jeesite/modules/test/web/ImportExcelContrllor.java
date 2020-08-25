package com.jeesite.modules.test.web;

import com.jeesite.common.config.Global;
import com.jeesite.common.web.BaseController;
import com.jeesite.modules.file.entity.FileUpload;
import com.jeesite.modules.file.service.FileEntityService;
import com.jeesite.modules.file.service.FileUploadService;
import com.jeesite.modules.test.entity.ImportExcelData;
import com.jeesite.modules.test.entity.ParseExcel;
import com.jeesite.modules.test.entity.TestData;
import com.jeesite.modules.test.service.ImportExcelService;
import com.jeesite.modules.test.utils.ReadExcel;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import java.io.*;
import java.util.List;


@Controller
@RequestMapping(value = "${adminPath}/excel/importExcel")
public class ImportExcelContrllor extends BaseController {

    @Autowired
    private FileEntityService fileEntityService;
    @Autowired
    private ImportExcelService importExcelService;
    @Autowired
    private FileUploadService fileUploadService;







    /**
     * 获取数据
     * @return
     */
    @ModelAttribute
    public ImportExcelData get(String id, boolean isNewRecord) {
        return importExcelService.get(id, isNewRecord);
    }



    /**
     * 跳转至importExcel页面
     */

    @RequiresPermissions("test:testData:view")
    @RequestMapping(value = {"Import", ""})
    public String list(TestData testData, Model model) {
        model.addAttribute("testData", testData);
        return "modules/test/importExcel";
    }



    /**
     *跳转至importExcelForm页面
     * @param testData
     * @param model
     * @return
     */
    @RequiresPermissions("test:testData:view")
    @RequestMapping(value = "form")
    public String form(TestData testData, Model model) {
        model.addAttribute("testData", testData);
        return "modules/test/importExcelForm";
    }



    /**
     * 保存数据
     * @param importExcelData
     */
    @RequiresPermissions("test:testData:edit")
    @PostMapping(value = "save")
    @ResponseBody
    public String save(@Validated ImportExcelData importExcelData,String testData_file) throws IOException {
        System.out.println("controller....");

        //获取文件地址
        FileUpload fileUpload = fileUploadService.get(testData_file);
        String path = "D:\\jeesite"+fileUpload.getFileUrl();

       //file转换为multipartFile
        File file = new File(path);
        MultipartFile multipartFile = importExcelService.FmConversion(file);

        //解析excel
        ReadExcel readExcel = new ReadExcel();
        List<ParseExcel> parseExcelList = readExcel.getExcelInfo(multipartFile);
//        System.out.println(parseExcelList);

        //导入数据库
        importExcelService.save(parseExcelList);

        return renderResult(Global.TRUE, text("保存数据成功！"));
    }
}
