package com.johnny.store.config;

//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.boot.context.properties.ConfigurationProperties;
//import org.springframework.stereotype.Component;

//@ConfigurationProperties(prefix = "alipay")
public class AliPayConfig {
    private final String serviceUrl = "https://openapi.alipaydev.com/gateway.do";
    private final String appId = "2016091700535433";
    private final String privateKey = "MIIEvgIBADANBgkqhkiG9w0BAQEFAASCBKgwggSkAgEAAoIBAQCxI3NlkYNUuziySI9ZFNi4m1m/5gRGC1UK/O7YfY1M8eHz6/JBCvemL7MfqwT5/y65OD+uNmltyb4ysTDyIHlCLNJP/bG/BoW6zhWvDi6wzo1PA4sZsQy2u9nz0lZdN40CGl7GVgjn1gy7cP7/0ov7YlNugEh2uRj2q8XU1SvXN3+44GkgMbsQvFnfGPDKD+QLcEZ9dRYmUkL9eGB0+O2PWkahcYo70TyUd+bMgO+pt+cK+KgFvyhtAiAGhzJc+3pFpvdtJ8+L+jlcuvDsJM071nq1xlRqehP2hHT3BDAtgYLECNiq1nY3LDIXWpYAIHL/w3FM+Y8ilPhqL5Lq3jQ1AgMBAAECggEAS23gHrkG5pbOvsQ9Hl7NJlcosZl96mG69fHctx1HhSNe5yJqxx2ndQHM0cheVyI9wCtemo2a+WA1+JoRUJlZaT9y0xMhlElvuqs0+pUcdreN3r6QhgEpe8qkNbo0gn88MVAPWX+bTTWNuGeWflMmvoYRJvXDZaLOKYPduxKHF55Z583BWkH4o2yx1EekYXzDp9pi203htQbDk6h1hiteMt1IVqBNAKJZ/MvwlC50jRF2+cTcGCQo3HEAUJL0m+j0CXOM314SZxml7OwgLbyWC4zHI62BxuNrEY1+nHPCuoGCOJk7rkCVxoxAUMZoY4wGgsNrQdRDRVBF82EEFu+dYQKBgQDdwKve1Aodi5UJSiLK2mgZP2HGTbOCzZP73RvYsFhgsTDysSzxEQb2ZrcloouLXRWi3CRCVITy5/MnzO5KyO7/WDXLhBKLiieHe6ozTR8bmRW2TqMS2nwWkajVyc9x2rycf4TVZNc7MeJTxy5S8wt3TCfcVm0401UOtf1hRH4bHQKBgQDMfuQgG2CQdCSm9UlKBdgpbGfvJAj4scQdn1aaStyFp8u/udiO68/fkt8F6F500ytxoBzSZ8Y0AoOesCRF9GjND88j3cEoVGHq8PGmwNsKOKfrZP6RW4vkc7RQBTwEKEtiCH2NXT1hK9pb1OBzuaWSmHbqeXvE6o7pQfFOhNAZ+QKBgDqYH5H4i1e1O0NCIKFjRqBtPAOvImDMu26QxTvjlOavy1RFdq+YJTPUfk5mfeLsTLxE2Rvhw2N/4KNCpjCCmYxFHanSEyhl7/3/skBt/2tGbxNGAhcIPkOkZ21eLv9RogbkNxA/3hNZIgmrFtV6PSxfpiS1fZTHWrFRa0tZUs0NAoGBAKABnV/d7AW7Sr50aH8J6aQn1X8RdA+bkHcZKLsbXkcaDtuaf+78Zi9qjSTjN50zaefDPyoG1tf1K6Vr70XpQmNJPmuy5KM4u1EIbBxtBDaQNBuEb4eu2NvNCMYgAmDCYpF3UT3eOduhY369J06FcR8uOsWmfoiKe33aAgTM+MOJAoGBAKHUs3uEXM6GTqOVkfDisnYKdAnSS9HwFZdjRl9p7Ob6gujcjkOw4QQyz/Q3QRReJowyGxb7Yy/1YuIAtSnq0OwQynSGLRkYw6dPj+IqIh/mnz3D3jTlGohvSOpgBuLwxaxUWksKDu0dS8rS96+uD02J2cCXKaO+EWSujKFfAGfZ";
    private final String format = "json";
    private final String charset = "utf-8";
    private final String publicKey = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAsSNzZZGDVLs4skiPWRTYuJtZv+YERgtVCvzu2H2NTPHh8+vyQQr3pi+zH6sE+f8uuTg/rjZpbcm+MrEw8iB5QizST/2xvwaFus4Vrw4usM6NTwOLGbEMtrvZ89JWXTeNAhpexlYI59YMu3D+/9KL+2JTboBIdrkY9qvF1NUr1zd/uOBpIDG7ELxZ3xjwyg/kC3BGfXUWJlJC/XhgdPjtj1pGoXGKO9E8lHfmzIDvqbfnCvioBb8obQIgBocyXPt6Rab3bSfPi/o5XLrw7CTNO9Z6tcZUanoT9oR09wQwLYGCxAjYqtZ2NywyF1qWACBy/8NxTPmPIpT4ai+S6t40NQIDAQAB";
    private final String signType = "RSA2";
    private final String notifyUrl = "http://localhost:8081/api/payment/notify/aliPay";
    private final String returnUrl = "http://www.baidu.com";


    public String getServiceUrl() {
        return serviceUrl;
    }

    public String getAppId() {
        return appId;
    }

    public String getPrivateKey() {
        return privateKey;
    }

    public String getFormat() {
        return format;
    }

    public String getCharset() {
        return charset;
    }

    public String getPublicKey() {
        return publicKey;
    }

    public String getSignType() {
        return signType;
    }

    public String getNotifyUrl() {
        return notifyUrl;
    }

    public String getReturnUrl() {
        return returnUrl;
    }
}
