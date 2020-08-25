package com.jeesite.modules.test.service;

import com.jeesite.common.io.IOUtils;
import com.jeesite.common.service.CrudService;
import com.jeesite.modules.test.dao.ImportExcelDao;
import com.jeesite.modules.test.dao.ParseExcelDao;
import com.jeesite.modules.test.entity.ImportExcelData;
import com.jeesite.modules.test.entity.ParseExcel;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import java.io.*;
import java.nio.file.Files;
import java.util.List;


@Service
@Transactional(readOnly=true)
public class ImportExcelService extends CrudService<ImportExcelDao, ImportExcelData> {

    @Autowired
    private ParseExcelDao parseExcelDao;


    /**
     * file转换为multipartFile
     * @param file
     * @return
     * @throws IOException
     */
    public MultipartFile FmConversion(File file) throws IOException {

        FileItem fileItem = new DiskFileItem("mainFile", Files.probeContentType(file.toPath()), false, file.getName(), (int) file.length(), file.getParentFile());
        try {
            InputStream input = new FileInputStream(file);
            OutputStream os = fileItem.getOutputStream();
            IOUtils.copy(input, os);
            // Or faster..
            // IOUtils.copy(new FileInputStream(file), fileItem.getOutputStream());
        } catch (IOException ex) {
            // do something.
        }
        MultipartFile multipartFile = new CommonsMultipartFile(fileItem);
        System.out.println(multipartFile.getOriginalFilename());
        return multipartFile;
    }


    /**
     * 保存到数据库
     * @param parseExcelList
     */
    @Transactional(readOnly=false)
    public void save( List<ParseExcel> parseExcelList){
        System.out.println(parseExcelList);
        parseExcelDao.insertBatch(parseExcelList);

    }


}
