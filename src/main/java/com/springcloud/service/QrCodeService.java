package com.springcloud.service;

import com.springcloud.model.PageBase;
import com.springcloud.model.QrCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by wanghonglan on 2018/7/17.
 */
@Service
public class QrCodeService {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public PageBase<QrCode> queryQrCodeList(QrCode qrCode) {
        StringBuffer sql = new StringBuffer("select q.id,q.unique_symbol,q.qr_state," +
                "q.prize_grade,q.is_deleted,q.create_time,q.update_time from qr_code q where 1=1");
        List<QrCode> qrCodes = jdbcTemplate.query(sql.toString(),new BeanPropertyRowMapper<>(QrCode.class));

        return new PageBase<>(qrCodes);
    }

    public void addQrCode(QrCode qrCode) {
        String sql = "insert into qr_code (unique_symbol,activity_id,qr_state,prize_grade,is_deleted,user_id) values (?,?,?,?,?,?)";

        jdbcTemplate.update(sql,new Object[]{qrCode.getUniqueSymbol(),qrCode.getActivityId(),qrCode.getQrState(),qrCode.getPrizeGrade(),
        qrCode.getIsDeleted(),qrCode.getUserId()});
    }
}
