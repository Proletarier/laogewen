package com.app.mvc.acl.config;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by wenheng on 2017/8/7.
 */
public class utilConfig {

    public static Map<String, String> filmTypeMap= new HashMap<String, String>();

    public enum FilmType {

        YZQS("亚洲情色"),
        ZFSW("制服丝袜"),
        OMXA("欧美性爱"),
        WYZP("网友自拍"),
        JDSJ("经典三级"),
        LLND("乱伦虐待"),
        LLBT("另类变态"),
        CRDM("成人动漫"),
        BZRB("本周热播"),
        CNXH("猜您喜欢"),
        JRGX("今日更新"),
        GXSL("更新数量");

        private String value;
        private FilmType(String value){
            this.value=value;
        }
        public String getValue(){
            return this.value;
        }

    }

    public enum PictureType{
        TPZP("偷拍自拍"),
        YZST("亚洲色图"),
        SWMT("丝袜美腿"),
        OMXA("欧美性爱"),
        QJMX("激情明星"),
        QCWM("清纯唯美"),
        CRDM("成人动漫");

        private String value;
        private PictureType(String value){
            this.value=value;
        }
        public String getValue(){return this.value;}
    }

    public enum NovelType{

        JQWX("激情文学"),
        LLWX("乱伦文学"),
        MXXY("明星校园"),
        WXGD("武侠古典"),
        HSXH("黄色笑话"),
        XAJQ("性爱技巧");

        private String value;
        private NovelType(String value){
            this.value=value;
        }
        public String getValue(){
            return  this.value;
        }
    }
}
