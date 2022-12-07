package com.qsp.jdbc_prepared_statement_eve.service;

import java.util.LinkedList;

import com.qsp.jdbc_prepared_statement_eve.dao.MobileDao;
import com.qsp.jdbc_prepared_statement_eve.dto.Mobile;

public class MobileService {
    MobileDao mobileDao = new MobileDao();
    public void insertMobile(Mobile mobile) {
    
        mobileDao.insertMobile(mobile);
    }
    public void updateMobile(Mobile mobile) {
    
        if (mobile.getId()==mobileDao.getById(mobile.getId())) {
            mobileDao.updateMobile(mobile);
        }
    }
    public void deleteMobile(Mobile mobile) {
        if (mobile.getId()==mobileDao.getById(mobile.getId())) {
            mobileDao.deleteMobile(mobile);
        }
    }
    public void deleteAllMobile() {
        mobileDao.deleteAllMobile();
    }
    public LinkedList<Mobile> displayMobile() {
        return mobileDao.displayMobile();
    }
}
