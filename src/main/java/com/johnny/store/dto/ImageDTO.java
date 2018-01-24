package com.johnny.store.dto;

public class ImageDTO {
    private String imageSrc;
    private String parentImageSrc;
    private int objectID;
    private String objectType;
    private int groupID;
    private String imageType;
    private String loginUser;

    public String getImageSrc() {
        return imageSrc;
    }

    public void setImageSrc(String imageSrc) {
        this.imageSrc = imageSrc;
    }

    public String getParentImageSrc() {
        return parentImageSrc;
    }

    public void setParentImageSrc(String parentImageSrc) {
        this.parentImageSrc = parentImageSrc;
    }

    public int getObjectID() {
        return objectID;
    }

    public void setObjectID(int objectID) {
        this.objectID = objectID;
    }

    public String getObjectType() {
        return objectType;
    }

    public void setObjectType(String objectType) {
        this.objectType = objectType;
    }

    public String getImageType() {
        return imageType;
    }

    public void setImageType(String imageType) {
        this.imageType = imageType;
    }

    public String getLoginUser() {
        return loginUser;
    }

    public void setLoginUser(String loginUser) {
        this.loginUser = loginUser;
    }

    public int getGroupID() {
        return groupID;
    }

    public void setGroupID(int groupID) {
        this.groupID = groupID;
    }
}
