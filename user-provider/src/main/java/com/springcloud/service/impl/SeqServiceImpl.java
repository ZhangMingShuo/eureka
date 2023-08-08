package com.springcloud.service.impl;

import com.springcloud.service.SeqService;
import com.springcloud.user.mapper.ObOrderMapper;
import org.apache.commons.lang.time.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.locks.ReentrantLock;

@Service
public class SeqServiceImpl implements SeqService {

    private final ReentrantLock lock = new ReentrantLock();

    private static final Map<String, List<String>> waybillMap=new ConcurrentHashMap<>();

    @Autowired
    private ObOrderMapper orderMapper;

    public String  genWaybillNo(String bigType, Date dtOrderDate){
        lock.lock();
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("yyMM");
            List<String> list = waybillMap.get(bigType + sdf.format(dtOrderDate));
            if (list == null || list.isEmpty()) {
                if(list == null){
                    list=new ArrayList<>();
                }
                String waybillNo = orderMapper.genWaybillNo(bigType, dtOrderDate);
                String pre = ("集团外整车".equals(bigType) ? "J-"
                        : ("普货".equals(bigType) ? "P-" : "L-") )+ sdf.format(dtOrderDate);
                for (int i = 0; i < 9; i++) {
                    waybillNo = getLastWayBillNo(pre, waybillNo);
                    list.add(waybillNo);
                }
                return waybillNo;
            } else {
                String waybillNo = list.stream().findFirst().get();
                list.remove(waybillNo);
                SimpleDateFormat sdf1 = new SimpleDateFormat("yyMM");
                waybillMap.put(bigType + sdf1.format(dtOrderDate), list);
                return waybillNo;
            }
        }finally {
            System.out.println("generate seq unlock");
            lock.unlock();
        }

    }
    //生成下一个
    private static String getLastWayBillNo(String pre,String waybillNo){
//        String number = StrUtil.removePrefix(waybillNo, pre);
        String number = waybillNo.substring(6);
        if (number!=null && number.length()!=0) {
            int n = number.length(); //取出字符串的长度
            int num = Integer.parseInt(number) + 1; //将该数字加一
            String added = String.valueOf(num);
            n = Math.min(n, added.length());
            //拼接字符串
            return waybillNo.subSequence(0, waybillNo.length() - n) + added;
        } else {
            throw new NumberFormatException();
        }
    }

}
