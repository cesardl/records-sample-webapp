/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.kodejava.example.mybatis.domain;

import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author pdiaz
 */
public class Record implements Serializable {

    private static final long serialVersionUID = 1L;
    private Integer id;
    private String title;
    private Date releaseDate;
    private Integer artistId;
    private Integer labelId;
    private Date created;
    private Date modified;

    public Record() {
        releaseDate = new Date();
        created = new Date();
        modified = new Date();
    }

    public Integer getArtistId() {
        return artistId;
    }

    public void setArtistId(Integer artistId) {
        this.artistId = artistId;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getLabelId() {
        return labelId;
    }

    public void setLabelId(Integer labelId) {
        this.labelId = labelId;
    }

    public Date getModified() {
        return modified;
    }

    public void setModified(Date modified) {
        this.modified = modified;
    }

    public Date getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(Date releaseDate) {
        this.releaseDate = releaseDate;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return "Record{"
                + "id=" + id
                + ", title='" + title + "'"
                + ", releaseDate=" + releaseDate
                + ", artistId=" + artistId
                + ", labelId=" + labelId
                + "}";
    }
}
