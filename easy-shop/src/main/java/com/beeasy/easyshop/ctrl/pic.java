package com.beeasy.easyshop.ctrl;

import cn.hutool.core.date.DateUtil;
import cn.hutool.core.io.FileUtil;
import cn.hutool.core.util.StrUtil;
import com.beeasy.easyshop.U;
import com.beeasy.web.core.MultipartFile;
import com.beeasy.web.core.R;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import static com.beeasy.web.core.Config.config;

public class pic {

    public R upload(
        MultipartFile file
    ) throws IOException {
        var date = DateUtil.format(new Date(), "yyyy-MM-dd");
        var fileName = StrUtil.uuid() + U.getExt(file.fileName());
        var dir = new File(config.uploadDir, date);
        dir.mkdirs();
        File target = new File(dir, fileName);
        file.transferTo(target);
        return R.ok("/" + date + "/" + fileName);
    }
}
