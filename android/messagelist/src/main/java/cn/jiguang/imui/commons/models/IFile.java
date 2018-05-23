package cn.jiguang.imui.commons.models;

/**
 * Created by sky on 2018/5/17.
 */

public interface IFile extends IExtend {
    void setId(String id);

    String getDisplayName();
    String getExtension();
    String getFileName();
    String getPath();
    long getSize();
    String getThumbPath();
    String getUrl();
}
