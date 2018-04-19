package com.app.mvc.captcha;


import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.geom.QuadCurve2D;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Random;

/**
 * Created by Administrator on 2018/4/13.
 */
public class Captcha {


    //宽
    private int width=160;
    //高
    private int height=40;
    //验证码字符个数
    private int codeCount=5;
    //干扰线数
    private int lineCount=3;

    private String code=null;

    private BufferedImage buffIme=null;

    private char[] codeSequence={'Q','W','E','R','T','Y','U','I','O','P','A','S','D','F','G','H','J','K','L','Z','X','C','V','B','N','M','1','2','3','4','5','6','7','8','9','0'};


    private final static String fontStr = "";


    public  Captcha(){
        createCode();
    }

    public Captcha(int width,int height){
        this.width=width;
        this.height=height;
        createCode();
    }

    public Captcha(int width,int height,int codeCount,int lineCount){
        this.width=width;
        this.height=height;
        this.codeCount=codeCount;
        this.lineCount=lineCount;
        createCode();
    }


    public void createCode(){
        int x=0,fontHeight=0,codeY=0;
        int red=0,green=0,blue=0;

        x=width/(codeCount+2);
        fontHeight=height-2;
        codeY=height-4;

        buffIme=new BufferedImage(width,height,BufferedImage.TYPE_3BYTE_BGR);
        Graphics2D g=buffIme.createGraphics();

        g.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_NEAREST_NEIGHBOR);
        // 图形抗锯齿
        g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        // 字体抗锯齿
        g.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);

        Random random=new Random();

        g.setColor(getRandColor(200,250));
        g.fillRect(0,0,width,height);

        Font font=getFont(fontHeight);
        g.setFont(font);

        for(int i=0;i<lineCount;i++){
            int xs=random.nextInt(width);
            int ys=random.nextInt(height);
            int xe=xs+random.nextInt(width/8);
            int ye=ys+random.nextInt(height/8);
            g.setColor(getRandColor(120,200));
            g.drawLine(xs,ys,xe,ye);
        }

        StringBuffer randomCode=new StringBuffer();
        for(int i=0;i<codeCount;i++){
            String strRand=String.valueOf(codeSequence[random.nextInt(codeSequence.length)]);
            g.setColor(getRandColor(20,130));
            g.drawString(strRand,(i+1)*x,codeY);
            randomCode.append(strRand);
        }
        QuadCurve2D.Double curve =
                new QuadCurve2D.Double(0d, random.nextInt(height - 8) + 4, width / 2, height / 2, width,
                        random.nextInt(height - 8) + 4);
        g.draw(curve);
        code=randomCode.toString();
    }


    public void  write(OutputStream sos) throws IOException{
        ImageIO.write(buffIme,"png",sos);
        sos.close();
    }

    public Font getFont(int fontHeight){
        try{
            Font baseFont=Font.createFont(Font.TRUETYPE_FONT,new ByteArrayInputStream(hex2byte(fontStr)));
            return baseFont.deriveFont(Font.PLAIN,fontHeight);
        }catch (Exception e){
            return  new Font("Arial",Font.PLAIN,fontHeight);
        }
    }


    private Color getRandColor(int fc, int bc) {
        Random random = new Random();
        if (fc > 255)
            fc = 255;
        if (bc > 255)
            bc = 255;
        int r = fc + random.nextInt(bc - fc);
        int g = fc + random.nextInt(bc - fc);
        int b = fc + random.nextInt(bc - fc);
        return new Color(r, g, b);
    }

    private byte[] hex2byte(String str) {
        if (str == null)
            return null;
        str = str.trim();
        int len = str.length();
        if (len == 0 || len % 2 == 1)
            return null;

        byte[] b = new byte[len / 2];
        try {
            for (int i = 0; i < str.length(); i += 2) {
                b[i / 2] = (byte) Integer.decode("0x" + str.substring(i, i + 2)).intValue();
            }
            return b;
        } catch (Exception e) {
            return null;
        }
    }


    public  String  getCode(){
        return  code;
    }


}
