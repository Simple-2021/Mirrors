package com.example.mirrors.exception.enumerate;

public class WebExceptionEnumerate {

    //Unknown's Exception
    //请求了未定义的HTTP版本
    public static int UnknownHttpVersion = 505;
    //请求了未定义的网关
    public static int UnknownGateway = 502;
    //请求了未定义的范围
    public static int UnknownRange = 416;
    //请求了未定义的资源
    public static int UnknownResource = 404;
    //请求了未定义的新资源
    public static int UnknownNewResource = 410;
    //请求了未定义的语法
    public static int UnknownSyntax = 400;
    //请求了未定义的功能
    public static int UnknownFunction = 501;
    //请求了未定义的先决条件
    public static int UnknownPreload = 412;
    //请求了未定义媒体格式
    public static int UnknownMIME = 415;
    //请求了未定义数据格式
    public static int UnknownContent = 406;


    //Never's Exception
    //请求要求用户的身份认证
    public static int NeverAuthorize = 401;
    //请求要求代理的身份认证
    public static int NeverProxyAuthorize = 407;

    //Refuse's Exception
    //服务器拒绝执行此请求
    public static int RefuseExecute = 403;
    //客户端请求中的方法被禁止
    public static int RefuseMethod = 405;

    //服务器等待客户端发送的请求时间过长
    public static int Timeout = 408;
    //由网关发送的请求超时
    public static int GatewayTimeOut = 504;

    //服务器无法处理客户端发送的不带Content-Length的请求信息
    public static int MustHasLength = 411;

    //请求的实体过大
    public static int BodyTooLarge = 413;
    //请求的URI过长
    public static int UriTooLong = 414;


    //服务器内部错误
    public static int InnerFail = 500;
    //服务器系统维护
    public static int InnerMaintain = 503;


}
