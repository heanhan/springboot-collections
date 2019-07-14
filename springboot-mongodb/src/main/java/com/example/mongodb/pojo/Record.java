/**
 * 
 */
package com.example.mongodb.pojo;

import java.io.Serializable;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * @author Thunisoft
 *
 */
@Document("mongo-record")
public class Record implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -3530140799440129217L;
	@Id
    private Long id;//id

    private String title;//标题

    private String description;//描述

    private String by;//来自于

    private String url;//地址

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getBy() {
        return by;
    }

    public void setBy(String by) {
        this.by = by;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

}
