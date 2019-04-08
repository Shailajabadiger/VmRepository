package com.mindtree.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="mindtreeminds")
public class MindtreeMinds {
	@Id
private String mid;
private String name;
private String track;

public MindtreeMinds() {
	super();
}

public MindtreeMinds(String mid, String name, String track) {
	super();
	this.mid = mid;
	this.name = name;
	this.track = track;
}

public String getMid() {
	return mid;
}

public void setMid(String mid) {
	this.mid = mid;
}

public String getName() {
	return name;
}

public void setName(String name) {
	this.name = name;
}

public String getTrack() {
	return track;
}

public void setTrack(String track) {
	this.track = track;
}

@Override
public String toString() {
	return "MindtreeMinds [getMid()=" + getMid() + ", getName()=" + getName() + ", getTrack()=" + getTrack() + "]";
}


}
