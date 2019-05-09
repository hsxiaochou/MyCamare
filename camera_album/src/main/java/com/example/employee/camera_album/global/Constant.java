package com.example.employee.camera_album.global;


import com.example.employee.camera_album.utils.FileUtils;

import java.io.File;


public class Constant {
    public static final String APP_NAME = "camera_album";//app名称
    public static final String BASE_DIR = APP_NAME + File.separator;//WildmaIDCardCamera/
    public static final String DIR_ROOT = FileUtils.getRootPath() + File.separator + Constant.BASE_DIR;//文件夹根目录 /storage/emulated/0/WildmaIDCardCamera/
}