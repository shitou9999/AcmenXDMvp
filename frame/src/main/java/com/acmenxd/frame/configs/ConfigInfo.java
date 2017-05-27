package com.acmenxd.frame.configs;

import android.os.Environment;
import android.util.Log;

import com.acmenxd.logger.LogType;
import com.acmenxd.toaster.ToastD;
import com.acmenxd.toaster.ToastNW;

import java.util.HashMap;
import java.util.Map;

/**
 * @author AcmenXD
 * @version v1.0
 * @github https://github.com/AcmenXD
 * @date 2017/5/25 10:02
 * @detail 配置详细参数类
 */
public class ConfigInfo {

    /**
     * 初始化
     */
    public void init(boolean isDebug) {
        DEBUG = isDebug;
        LOG_OPEN = DEBUG;
        TOAST_DEBUG_OPEN = DEBUG;
        NET_LOG_OPEN = DEBUG;
        initSpData();
        initNetURL();
        initNetParams();
    }

    /**
     * 调试模式开关
     * * 由build.gradle -> debug | release版本控制
     */
    public boolean DEBUG = false;

    /**
     * 数据库 配置
     */
    // 数据库名称
    public String DB_NAME = "acmen_db";

    /**
     * File 存储配置
     * BASE_DIR 路径下的自定义文件夹会自动创建
     * * 详情参考FileUtils.init();
     */
    public String SDCARD_DIR = Environment.getExternalStorageDirectory().getAbsolutePath();
    public String BASE_DIR = SDCARD_DIR + "/AcmenXD/";

    /**
     * Log 配置
     */
    // Log开关
    public boolean LOG_OPEN = DEBUG;
    // Log显示等级, >= LOG_LEVEL的log显示
    public LogType LOG_LEVEL = LogType.V;
    // Log日志默认保存路径
    public String LOG_DIR = BASE_DIR + "Logger/";

    /**
     * Toast 配置
     * * Toast 有Debug模式,正式上线版本将不会显示debug模式下的Toast
     */
    // Toast调试开关
    public boolean TOAST_DEBUG_OPEN = DEBUG;
    // Toast默认显示时长
    public ToastD TOAST_DURATION = ToastD.SHORT;
    // Toast显示方式 : Toast需要等待,并逐个显示 | Toast无需等待,直接显示
    public ToastNW TOAST_NEED_WAIT = ToastNW.NEED_WAIT;

    /**
     * SharedPreferences 配置
     */
    public String SP_Device = "spDevice";
    public String[] spAll;

    // 配置sp初始个数
    protected void initSpData() {
        spAll = new String[]{SP_Device};
    }

    /**
     * Net 配置
     */
    // 请求地址配置 -1:正式版  0->预发布  1->测试1
    public byte URL_Type = -1;
    // 基础url配置
    public String BASE_URL;

    // 配置连接地址
    protected void initNetURL() {
        switch (URL_Type) {
            case -1:
                //正式版
                BASE_URL = "http://www.baidu.com";
                break;
            case 0:
                //预发布
                BASE_URL = "http://www.baidu.com";
                break;
            case 1:
                //测试1
                BASE_URL = "http://www.baidu.com";
                break;
            default:
                BASE_URL = "http://www.baidu.com";
                break;
        }
    }

    // Net Log 的开关
    public boolean NET_LOG_OPEN = DEBUG;
    // Net Log 的日志级别
    public int NET_LOG_LEVEL = Log.WARN;
    // Net Log 的日志Tag
    public String NET_LOG_TAG = "NetLog";
    // Net Log 的日志显示形式 -> 是否显示 "请求头 请求体 响应头 错误日志" 等详情
    public boolean NET_LOG_DETAILS = true;
    // Net Log 的日志显示形式 -> 是否显示请求过程中的日志,包含详细的请求头日志
    public boolean NET_LOG_DETAILS_All = false;
    // 网络缓存策略: 0->不启用缓存  1->遵从服务器缓存配置
    public int NET_CACHE_TYPE = 1;
    // 网络缓存大小(MB)
    public int NET_CACHE_SIZE = 10;
    // 网络连接超时时间(秒)
    public int CONNECT_TIMEOUT = 30;
    // 读取超时时间(秒)
    public int READ_TIMEOUT = 30;
    // 写入超时时间(秒)
    public int WRITE_TIMEOUT = 30;
    // 非Form表单形式的请求体,是否加入公共Body
    public boolean NOFORMBODY_CANADDBODY = false;
    // 公共请求参数
    public Map<String, String> ParameterMaps = new HashMap<>();
    // 公共Header(不允许相同Key值存在)
    public Map<String, String> HeaderMaps = new HashMap<>();
    // 公共Header(允许相同Key值存在)
    public Map<String, String> HeaderMaps2 = new HashMap<>();
    // 公共Body
    public Map<String, String> BodyMaps = new HashMap<>();

    // 配置请求公共需求
    protected void initNetParams() {
        ParameterMaps.clear();
        HeaderMaps.clear();
        HeaderMaps2.clear();
        BodyMaps.clear();
        ParameterMaps.put("parameter_key_1", "parameter_value_1");
        ParameterMaps.put("parameter_key_2", "parameter_value_2");
        HeaderMaps.put("header_key_1", "header_value_1");
        HeaderMaps.put("header_key_2", "header_value_2");
        HeaderMaps2.put("header_key_2", "header_value_2");
        HeaderMaps2.put("header_key_3", "header_value_3");
        BodyMaps.put("body_key_1", "body_value_1");
        BodyMaps.put("body_key_2", "body_value_2");
    }
}
