package com.taofaqi.meipai.utils;

/**
 * Created by sunger on 2015/10/27.
 */
public class AppConstants {

    public final class RequestPath {
        public final static String BASE_URL = "https://newapi.meipai.com/";
        /**
         * 用户登录
         */
        public final static String OAUTH_URL = "oauth/access_token.json";
        /**
         * 热门  根据id和type字段  1表示热门
         * count
         * page
         */
        public final static String HOT_VIDEO_LIST_URL = "hot/feed_timeline.json";
        /**
         * 其他视频
         * id
         * type
         * page
         * count
         */
        public final static String VIDEO_LIST = "channels/feed_timeline.json";

        /**
         * 首页分类数据
         */
        public final static String CATEGOTY_URL = "channels/header_list.json?language=zh-Hans";
    }

    public final class ParamKey {

        public final static String CLIENT_SECRET_KEY = "client_secret";

        public final static String GRANT_TYPE_KEY = "grant_type";

        public final static String CLIENT_ID_KEY = "client_id";

        public final static String DEVICE_ID_KEY = "device_id";

        public final static String LANGUAGE_KEY = "language";

        public final static String MODEL_KEY = "model";

        public final static String ACCESS_TOKEN_KEY = "access-token";

        public final static String PHONE_KEY = "phone";

        public final static String PASSWORD_KEY = "password";

        public final static String ID_KEY = "id";

        public final static String TYPE_KEY = "type";

        public final static String PAGE_KEY = "page";

        public final static String COUNT_KEY = "count";

        public final static String VERIFY_CODE_KEY = "verify_code";

        public final static String AUTO_LOGIN_KEY = "auto_login";

        public final static String SCREEN_NAEM_KEY = "screen_name";
        public final static String GENDER_KEY = "gender";

        public final static String DESCRIPTION_KEY = "description";

        public final static String UID_KEY = "uid";

        public final static String WITH_CAPTION_KEY = "with_caption";

    }

    public final class ParamDefaultValue {
        //client_secret
        public final static String CLIENT_SECRET = "38e8c5aet76d5c012e32";
        //client_id
        public final static String CLIENT_ID = "1089857302";

        public final static String LANGUAGE = "zh-Hans";
        //grant_type
        public final static String GRANT_TYPE = "phone";

        public final static String TYPR_RESET_PASSWORD = "reset_password";
        public final static int AUTO_LOGIN = 1;
        public final static int WITH_CAPTION = 1;

    }

}
