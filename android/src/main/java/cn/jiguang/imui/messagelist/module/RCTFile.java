package cn.jiguang.imui.messagelist.module;

import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.WritableMap;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import cn.jiguang.imui.commons.models.IFile;
import cn.jiguang.imui.messagelist.MessageConstant;

/**
 * Created by sky on 2018/5/17.
 */

public class RCTFile extends RCTExtend implements IFile {
    private String id;
    private String fileName;
    private String extension;
    private String displayName;
    private String url;
    private String path;
    private long size;
    private String thumbPath;

    public RCTFile(String fileName, String extension, long size)
    {
        this.fileName = fileName;
        this.extension = extension;
        this.size = size;
    }

    @Override
    WritableMap toWritableMap(){
        WritableMap writableMap = Arguments.createMap();
        writableMap.putString(MessageConstant.File.FILE_NAME, fileName);
        writableMap.putString(MessageConstant.File.EXTENSION, extension);
        writableMap.putString(MessageConstant.File.DISPLAY_NAME, displayName);
        writableMap.putString(MessageConstant.File.PATH, path);
        writableMap.putString(MessageConstant.File.SIZE, Long.toString(size));
        writableMap.putString(MessageConstant.File.THUMB_PATH, thumbPath);
        writableMap.putString(MessageConstant.File.URL, url);
        return writableMap;
    }
    @Override
    public JsonElement toJSON() {
        JsonObject json = new JsonObject();
        json.addProperty(MessageConstant.File.FILE_NAME, fileName);
        json.addProperty(MessageConstant.File.EXTENSION, extension);
        json.addProperty(MessageConstant.File.DISPLAY_NAME, displayName);
        json.addProperty(MessageConstant.File.PATH, path);
        json.addProperty(MessageConstant.File.SIZE, Long.toString(size));
        json.addProperty(MessageConstant.File.THUMB_PATH, thumbPath);
        json.addProperty(MessageConstant.File.URL, url);
        return json;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public void setExtension(String extension) {
        this.extension = extension;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public void setSize(long size) {
        this.size = size;
    }

    public void setThumbPath(String thumbPath) {
        this.thumbPath = thumbPath;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public String getFileName() {
        return this.fileName;
    }

    @Override
    public String getExtension() {
        return this.extension;
    }

    @Override
    public String getDisplayName() {
        return this.displayName;
    }

    @Override
    public String getPath() {
        return this.path;
    }

    @Override
    public long getSize() {
        return this.size;
    }

    @Override
    public String getThumbPath() {
        return this.thumbPath;
    }

    @Override
    public String getUrl() {
        return this.url;
    }
}
