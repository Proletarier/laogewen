package test;

import com.google.common.hash.BloomFilter;
import com.google.common.hash.Funnels;

import java.nio.charset.Charset;
import java.util.TimeZone;

/**
 * Created by wenheng on 2018/4/7.
 */
public class boom {

    public static void main(String[] args) {
//        BloomFilter<CharSequence> bloomFilter = BloomFilter.create(Funnels.stringFunnel(Charset.forName("utf-8")), 10000, 0.0001);
//        bloomFilter.put("90877d52909485f4d39563701ab31aba");
//        System.out.println(bloomFilter.mightContain("90877d52909485f4d39563701ab31aba"));



        System.out.println(TimeZone.getDefault());

        byte[] bytes=new byte[]{(byte)1100,0100};

        System.out.println(1100&0100);
    }

}
