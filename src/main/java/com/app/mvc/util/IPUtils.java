package com.app.mvc.util;

import org.apache.http.HttpRequest;

import javax.servlet.http.HttpServletRequest;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.util.regex.Pattern;

/**
 * Created by Administrator on 2018/4/12.
 */
public class IPUtils {

    private final static  String ERROR_IP="127.0.0.1";

    private final static Pattern pattern=Pattern.compile("(2[5][0-5]|2[0-4]\\d|1\\d{2}|\\d{1,2})\\.(25[0-5]|2[0-4]\\d|1\\d{2}|\\d{1,2})\\.(25[0-5]|2[0-4]\\d|1\\d{2}|\\d{1,2})\\.(25[0-5]|2[0-4]\\d|1\\d{2}|\\d{1,2})");


    public  static  String getRemoteIp(HttpServletRequest request){
        String ip=request.getHeader("x-real-ip");
        if(ip==null){
           ip=request.getRemoteAddr();
        }
        String[] stemps=ip.split(",");

        if(stemps!=null && stemps.length>1){
            ip=stemps[0];
        }
        ip=ip.trim();
        if(ip.length()>23){
            ip=ip.substring(0,23);
        }

        return  ip;
    }


    /**
     * 获取用户真实IP
     * @param request
     * @return
     */
    public  static  String getUserIp(HttpServletRequest request){

        String ip=request.getHeader("X-Real-IP");

        if(ip==null || ip.trim().length()==0 || "unknown".equals(ip)){
            ip=request.getHeader("x-forwarded-for");
        }

        if(ip==null || ip.trim().length()==0 || "unknown".equals(ip)){
            ip=request.getRemoteAddr();
            if("0:0:0:0:0:0:0:1".equalsIgnoreCase(ip)){
                ip=ERROR_IP;
            }
        }
        if("unknown".equalsIgnoreCase(ip)){
            ip=ERROR_IP;
            return  ip;
        }

        int pos=ip.indexOf(",");
        if(pos>0){
            ip=ip.substring(0,pos);
        }
        return  ip;

    }


    public  static String getServiceIp(){
        InetAddress address;
        try{
            address=InetAddress.getLocalHost();
            return address.getHostAddress();
        }catch (Exception e){
            e.printStackTrace();
        }
        return  "127.0.0.1";
    }


    public static  String getMACAddress(String ip){
        String line="";
        String macAddress="";
        final  String MAC_ADDRESS_PREFIX="MAC";
        final  String LOOPBACK_ADDRESS="127.0.0.1";
        try{
             if(LOOPBACK_ADDRESS.equals(ip)){
                   InetAddress inetAddress=InetAddress.getLocalHost();
                 NetworkInterface networkInterface=NetworkInterface.getByInetAddress(inetAddress);
                 byte[] mac=networkInterface.getHardwareAddress();
                 if(networkInterface==null  || mac==null){
                     return  "127.0.0.1";
                 }

                 StringBuffer sb=new StringBuffer();
                 for (int i=0;i<mac.length;i++){
                     if(i!=0){
                         sb.append("-");
                     }
                     String s=Integer.toHexString(mac[i] & 0XFF);
                     sb.append(s.length()==1?0+s:s);
                 }
                  macAddress=sb.toString().trim().toUpperCase();
                 return  macAddress;
             }
             Process p=Runtime.getRuntime().exec("nbtstat -A "+ ip);
            InputStreamReader isr=new InputStreamReader(p.getInputStream());
            BufferedReader br=new BufferedReader(isr);
            while ((line=br.readLine()) !=null){
                if(line!=null){
                    int index=line.indexOf(MAC_ADDRESS_PREFIX);
                    if(index!=-1){
                        index=line.indexOf("-");
                        macAddress=line.substring(index+1).trim().toUpperCase();
                    }
                }
            }
            br.close();
        }catch (Exception e){
            e.printStackTrace();
            return  "";
        }
        return  macAddress;

    }































}
