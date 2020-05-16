package org.kodejava.example.mybatis.domain;

import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

/**
 * @author Cesardl
 */
public class Record implements Serializable {

    private static final long serialVersionUID = 4697710587956239579L;
    private Integer id;
    private String title;
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    private Date releaseDate;
    private Integer artistId;
    private Integer labelId;
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    private Date created;
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    private Date modified;

    public Record() {
        releaseDate = new Date();
        created = new Date();
        modified = new Date();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Date getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(Date releaseDate) {
        this.releaseDate = releaseDate;
    }

    public Integer getArtistId() {
        return artistId;
    }

    public void setArtistId(Integer artistId) {
        this.artistId = artistId;
    }

    public Integer getLabelId() {
        return labelId;
    }

    public void setLabelId(Integer labelId) {
        this.labelId = labelId;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public Date getModified() {
        return modified;
    }

    public void setModified(Date modified) {
        this.modified = modified;
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
