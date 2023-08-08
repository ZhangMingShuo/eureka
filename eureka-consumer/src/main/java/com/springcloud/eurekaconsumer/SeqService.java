//package com.springcloud.eurekaconsumer;
//
//import org.apache.commons.lang.StringUtils;
//import org.apache.commons.lang.time.DateUtils;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import java.util.ArrayList;
//import java.util.Date;
//import java.util.List;
//import java.util.Map;
//import java.util.concurrent.ConcurrentHashMap;
//import java.util.concurrent.locks.ReentrantLock;
//
//@Service
//public class SeqService {
//
//    private final ReentrantLock lock = new ReentrantLock();
//
//    private static final Map<String, List<String>> waybillMap=new ConcurrentHashMap<>();
//
//    @Autowired
//    private OrderMapper orderMapper;
//
//    public String  genWaybillNo(String bigType, Date dtOrderDate){
//        lock.lock();
//        try {
//            List<String> list = waybillMap.get(bigType + DateUtils.format(dtOrderDate, "yyMM"));
//            if (CollectionUtil.isEmpty(list)) {
//                if(list==null){
//                    list=new ArrayList<>();
//                }
//                String waybillNo = orderMapper.genWaybillNo(bigType, dtOrderDate);
//                String pre = ("集团外整车".equals(bigType) ? "J-"
//                        : ("普货".equals(bigType) ? "P-" : "L-") )+ DateUtils.format(dtOrderDate, "yyMM");
//                for (int i = 0; i < 9; i++) {
//                    waybillNo = getLastWayBillNo(pre, waybillNo);
//                    list.add(waybillNo);
//                }
//                return waybillNo;
//            } else {
//                String waybillNo = list.stream().findFirst().get();
//                list.remove(waybillNo);
//                waybillMap.put(bigType + DateUtils.format(dtOrderDate, "yyMM"), list);
//                return waybillNo;
//            }
//        }finally {
//            System.out.println("generate seq unlock");
//            lock.unlock();
//        }
//
//    }
//    //生成下一个
//    private static String getLastWayBillNo(String pre,String waybillNo){
//        String number = StrUtil.removePrefix(waybillNo, pre);
//        if (!StringUtils.isEmpty(number)) {
//            int n = number.length(); //取出字符串的长度
//            int num = Integer.parseInt(number) + 1; //将该数字加一
//            String added = String.valueOf(num);
//            n = Math.min(n, added.length());
//            //拼接字符串
//            return waybillNo.subSequence(0, waybillNo.length() - n) + added;
//        } else {
//            throw new NumberFormatException();
//        }
//    }
//
//}
