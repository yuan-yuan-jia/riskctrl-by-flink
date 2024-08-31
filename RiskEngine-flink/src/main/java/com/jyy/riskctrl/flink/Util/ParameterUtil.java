package com.jyy.riskctrl.flink.Util;

import org.apache.flink.api.java.utils.ParameterTool;

import java.io.IOException;
import java.io.InputStream;

/**
 * 配置信息读取类
 */

/* **
  FLink 内置读取参数的对象
  1. Commons-cli
  2. ParameterTool

  ParameterTool比Commons-cli使用上更简便
  ParameterTool能避免Jar包的依赖冲突
 */
public class ParameterUtil {


    private static final String FILE = "flink.properties";


    /**
     * 读取配置信息
     * @param file 配置文件名称
     * @return
     * @throws IOException
     */
    public static ParameterTool getParameters(String file) throws IOException {

        /**
         * Java读取资源的方式
         * 1. Class.getResourceAsStream(Path)
         *    : Path是一个绝对路径，必须以"/"，表示从ClassPath的根路径读取资源
         * 2. Class.getClassLoader().getResourceAsStream(Path)
         *    Path无须"/"，默认从ClassPath，默认从ClassPath的根路径读取资源
         */
        InputStream inputStream = ParameterUtil.class.getClassLoader().getResourceAsStream(file);

        return ParameterTool.fromPropertiesFile(inputStream);

    }


}
