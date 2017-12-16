package com.johnny.store.entity;
import java.io.Serializable;
import java.sql.Timestamp;

public class ImageEntity implements Serializable {
	private int imageID;
	private String imageSrc;
	private int objectID;
	private String objectType;
	private String imageType;
	private String inUser;
	private Timestamp inDate;
	private String lastEditUser;
	private Timestamp lastEditDate;

	public ImageEntity(){
		super();
	}

	public ImageEntity(int imageID, String imageSrc, int objectID, String objectType, String imageType, String inUser, Timestamp inDate, String lastEditUser, Timestamp lastEditDate){
		super();
		this.imageID = imageID;
		this.imageSrc = imageSrc;
		this.objectID = objectID;
		this.objectType = objectType;
		this.imageType = imageType;
		this.inUser = inUser;
		this.inDate = inDate;
		this.lastEditUser = lastEditUser;
		this.lastEditDate = lastEditDate;
	}

	public int getImageID() {
		return this.imageID;
	}

	public void setImageID(int imageID) {
		this.imageID = imageID;
	}

	public String getImageSrc() {
		return this.imageSrc;
	}

	public void setImageSrc(String imageSrc) {
		this.imageSrc = imageSrc;
	}

	public int getObjectID() {
		return this.objectID;
	}

	public void setObjectID(int objectID) {
		this.objectID = objectID;
	}

	public String getObjectType() {
		return this.objectType;
	}

	public void setObjectType(String objectType) {
		this.objectType = objectType;
	}

	public String getImageType() {
		return this.imageType;
	}

	public void setImageType(String imageType) {
		this.imageType = imageType;
	}

	public String getInUser() {
		return this.inUser;
	}

	public void setInUser(String inUser) {
		this.inUser = inUser;
	}

	public Timestamp getInDate() {
		return this.inDate;
	}

	public void setInDate(Timestamp inDate) {
		this.inDate = inDate;
	}

	public String getLastEditUser() {
		return this.lastEditUser;
	}

	public void setLastEditUser(String lastEditUser) {
		this.lastEditUser = lastEditUser;
	}

	public Timestamp getLastEditDate() {
		return this.lastEditDate;
	}

	public void setLastEditDate(Timestamp lastEditDate) {
		this.lastEditDate = lastEditDate;
	}

}