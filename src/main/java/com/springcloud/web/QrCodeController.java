package com.springcloud.web;

import com.springcloud.model.PageBase;
import com.springcloud.model.QrCode;
import com.springcloud.model.ResultBase;
import com.springcloud.service.QrCodeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by wanghonglan on 2018/7/17.
 */
@RestController
public class QrCodeController {

    @Autowired
    private QrCodeService qrCodeService;

    @RequestMapping("/queryQrCodeList")
    public PageBase<QrCode> queryQrCodeList() {
        QrCode qrCode = new QrCode();

        return qrCodeService.queryQrCodeList(qrCode);
    }

    @RequestMapping("/addQrCode")
    public ResultBase addQrCode(QrCode qrCode) {
        qrCodeService.addQrCode(qrCode);

        return new ResultBase(true);
    }
}
