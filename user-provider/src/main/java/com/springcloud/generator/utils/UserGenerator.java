package com.springcloud.generator.utils;

import org.mybatis.generator.api.MyBatisGenerator;
import org.mybatis.generator.config.Configuration;
import org.mybatis.generator.config.xml.ConfigurationParser;
import org.mybatis.generator.internal.DefaultShellCallback;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
//https://blog.csdn.net/m0_53128394/article/details/117295056

public class UserGenerator {

    public void generator() throws Exception {


        boolean overwrite = true;
        //指定 逆向工程配置文件
        File configFile = new File("user-provider/genreatorConfig-user.xml");
        //warnings字符串集合用于存放生成过程中的警告信息，并非异常信息，可以按需输出
        List<String> warnings = new ArrayList<String>();
        ConfigurationParser cp = new ConfigurationParser(warnings);
        Configuration config = cp.parseConfiguration(configFile);
        //默认的shell命令回调，主要用于配置文件已存在时是否覆盖
        DefaultShellCallback callback = new DefaultShellCallback(overwrite);
        MyBatisGenerator myBatisGenerator = new MyBatisGenerator(config,
                callback, warnings);
        myBatisGenerator.generate(null);

        if (!warnings.isEmpty()) {
            String error = warnings.stream().collect(Collectors.joining(System.lineSeparator()));
            throw new IllegalArgumentException("代码生成警告：" + error);
        }

    }

    public static void main(String[] args) throws Exception {
        try {
            UserGenerator generatorSqlmap = new UserGenerator();
            generatorSqlmap.generator();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

