package com.dalimao.mytaxi.splash.commom.http.api;

public class API {
    public static final String TEST_GET = "/get?uid=${uid}";
    public static final String TEST_POST = "/post";

    public static class config {
        private static final String TEST_DOMAIN = "http://httpbin.org";
        private static final String RELEASE_DOMAIN = "http://httpbin.org";

        public static void setDomain(String domain) {
            config.domain = domain;
        }

        public static String getDomain() {
            return domain;
        }

        private static String domain = TEST_DOMAIN;

        public static void setDebug(boolean debug) {
            domain = debug ? TEST_DOMAIN : RELEASE_DOMAIN;
        }
    }
}
