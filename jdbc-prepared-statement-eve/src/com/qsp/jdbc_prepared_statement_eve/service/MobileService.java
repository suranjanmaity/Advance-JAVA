package com.qsp.jdbc_prepared_statement_eve.service;

import com.qsp.jdbc_prepared_statement_eve.dao.MobileDao;
import com.qsp.jdbc_prepared_statement_eve.dto.Mobile;

public class MobileService {
    MobileDao mobileDao = new MobileDao();
    public void insertMobile(Mobile mobile) {
    
        mobileDao.insertMobile(mobile);
    }
    
}
