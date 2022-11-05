package com.haichao.annotations.idorcode;

import com.haichao.date.DateUtil;
import org.apache.commons.lang3.StringUtils;

import java.lang.management.ManagementFactory;
import java.lang.management.RuntimeMXBean;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.text.DecimalFormat;
import java.util.Date;
import java.util.Enumeration;
import java.util.HashSet;
import java.util.Set;

public class IdCode {
    private static DecimalFormat ranRomF = new DecimalFormat("00");
    private static String ip;
    private static String pid;
    private static  Param param;
    /**
     * @param prefix:前缀 nfc
     *                  param timeFormat: yyyyMMdd
     * @param places:位数 000000
     * @return
     */
    public static String code(String prefix, String timeFormat, String places, Long number) {
        Date date=new Date();
        String first = "";
        String middle = "";
        String last = "";
        if (StringUtils.isNotBlank(prefix)) {
            first = prefix + "-";
        } else {
            first = "XT-";
        }
        if (StringUtils.isNotBlank(timeFormat)) {
            middle = DateUtil.formatDate(date, timeFormat) + "-";
        } else {
            middle = DateUtil.formatDate(date, "yyyyMMddHHmm") + "-";
        }
        if (StringUtils.isNotBlank(places)) {
            DecimalFormat df1 = new DecimalFormat(places);
            if (null != number) {
                last = df1.format(number);
            }
        } else {

            if (number != null) {
                last = number + "";
            }
        }

        return first + middle + last;
    }
    public static synchronized String  id(){
      Param param=getParam();
        // 网址 年月 日时分秒 线程 累加数 随机数据
        StringBuilder sb=new StringBuilder();
        sb.append("");
        sb.append(numFormat(ip(),3))/*.append("-")*/;
        sb.append(numFormat(getPid(),5))/*.append("-")*/;
        sb.append(getRandom())/*.append("-")*/;
        sb.append(param.getKey())/*.append("-")*/;
       sb.append(numFormat(param.getValue()+"",4));
        return sb.toString();
    }










    private static String numFormat(String num_,Integer numFormat){
           long didf=numFormat-num_.length();
            StringBuilder num=new StringBuilder();
            if(didf>0){
                for (int i=0;i<didf;i++) {
                    num.append( "0");
                }
            }
           num.append(num_);
           return num.toString();
    }
    private static  Param  getParam() {
        if(null == param){
            param   =new Param();
        }
        long start=System.currentTimeMillis();
        if(param.getKey() != start){
            param.setKey(start);
            param.setValue(0);
        }else{
            param.setValue(param.getValue()+1);
        }
        return param;
    }
    private static String getPid(){
        RuntimeMXBean bean= ManagementFactory.getRuntimeMXBean();
        if(null==pid){
            pid=bean.getName().split("@")[0];
        }
        return pid;
    }
    private static String getRandom() {
        String random = ranRomF.format(Math.random() * 10);
        return random;
    }
    private static String ipSpilit(String ips){
        String[] ipNums=ips.split("\\.");

        return ipNums[ipNums.length-1];
    }
    private static String  ip(){
        try {
            if(null == ip ) {
                InetAddress candidateAddress = null;
                // 遍历所有的网络接口
                for (Enumeration ifaces = NetworkInterface.getNetworkInterfaces(); ifaces.hasMoreElements(); ) {
                    NetworkInterface iface = (NetworkInterface) ifaces.nextElement();
                    // 在所有的接口下再遍历IP
                    for (Enumeration inetAddrs = iface.getInetAddresses(); inetAddrs.hasMoreElements(); ) {
                        InetAddress inetAddr = (InetAddress) inetAddrs.nextElement();
                        if (!inetAddr.isLoopbackAddress()) {// 排除loopback类型地址
                            if (inetAddr.isSiteLocalAddress()) {
                                // 如果是site-local地址，就是它了
                                ip=ipSpilit(inetAddr.getHostAddress());

                                return ip;
                            } else if (candidateAddress == null) {
                                // site-local类型的地址未被发现，先记录候选地址
                                candidateAddress = inetAddr;
                            }
                        }
                    }
                }
                if (candidateAddress != null) {
                    ip=ipSpilit(candidateAddress.getHostAddress());
                    return ip;
                }
                // 如果没有发现 non-loopback地址.只能用最次选的方案
                InetAddress jdkSuppliedAddress = InetAddress.getLocalHost();
                ip= ipSpilit(jdkSuppliedAddress.getHostAddress());
                return ip;
            }else{
                return ip;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    public static void main(String[] args) throws Exception {

        //System.out.println(numFormat("45",10));
        long a=System.currentTimeMillis();
        Set set=new HashSet();
       /* for(int i=0;i<10000;i++){*/
            String id=id();
            set.add(id);
            //System.out.println(id);
      /*  }*/
        System.out.println("daxiao==>>"+id.length());
        long b=System.currentTimeMillis();
        System.out.println((b-a)/1000.0 +"----"+ set.size());;
        String ids=id();
        set.add(ids);
        //System.out.println(id);
        /*  }*/
        System.out.println("daxiao==>>"+ids.length());
        long c=System.currentTimeMillis();
        System.out.println((c-b)/1000.0 +"----"+ set.size());;
    }
    private static class Param {
        private long key=0;
        private long value=0;

        public long getKey() {
            return key;
        }

        public void setKey(long key) {
            this.key = key;
        }

        public long getValue() {
            return value;
        }

        public void setValue(long value) {
                this.value = value;
        }
    }
}

