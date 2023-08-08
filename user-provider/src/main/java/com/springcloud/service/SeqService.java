package com.springcloud.service;

import java.util.Date;

public interface SeqService {
    public String  genWaybillNo(String bigType, Date dtOrderDate);
}
