package su.xlegion.testspring.entity;


import org.hibernate.annotations.GenericGenerator;

import java.io.Serializable;
import java.util.*;
import javax.persistence.*;

@Entity
@Table(name = "Artifact")
public class Artifact implements Serializable {
    @Id
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid")
    @Column(name = "ID")
    private UUID _ID;

    @Column(name = "Created")
    private Date _Created;

    @Column(name = "UserID")
    private String _UserID;

    @Column(name = "Category")
    private String _Category;

    @Column(name = "Description")
    private String _Description;

    public UUID getID() { return _ID; }
    public void setID(UUID value) { _ID = value; }

    public Date getCreated() { return _Created; }
    public void setCreated(Date value) { _Created = value; }

    public String getUserID() { return _UserID; }
    public void setUserID(String value) { _UserID = value; }

    public String getCategory() { return _Category; }
    public void setCategory(String value) { _Category = value; }

    public String getDescription() { return _Description; }
    public void setDescription(String value) { _Description = _Description; }

    @Override
    public String toString() {
        return "Artifact{" +
                "_ID=" + _ID +
                ", _Created=" + _Created +
                ", _UserID='" + _UserID + '\'' +
                ", _Category='" + _Category + '\'' +
                ", _Description='" + _Description + '\'' +
                '}';
    }
}
