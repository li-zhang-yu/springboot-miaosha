package com.github.springbootmiaosha.web.form;

/**
 * 照片表单
 *
 * @author lizhangyu
 * @date 2019-08-16
 */
public class PhotoForm {

    private String path;

    private int width;

    private int height;

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }
}
