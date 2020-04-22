package su.xlegion.testspring.entity;

import org.hibernate.annotations.GenericGenerator;

import java.io.Serializable;
import java.util.*;
import javax.persistence.*;

@Entity
@Table(name = "Comment")
public class Comment implements Serializable {
    @Id
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid")
    @Column(name = "ID")
    private UUID _ID;

    @Column(name = "ArtifactID")
    private UUID _ArtifactID;

    @Column(name = "UserID")
    private String _UserID;

    @Column(name = "Content")
    private String _Content;

    public Comment() { }

    public UUID getID() { return _ID; }
    public void setID(UUID value) { _ID = value; }

    public UUID getArtifactID() { return _ArtifactID; }
    public void setArtifactID(UUID value) { _ArtifactID = value; }

    public String getUserID() { return _UserID; }
    public void setUserID(String value) { _UserID = value; }

    public String getContent() { return _Content; }
    public void setContent(String value) { _Content = value; }

    @Override
    public String toString() {
        return "Comment{" +
                "_ID=" + _ID +
                ", _ArtifactID=" + _ArtifactID +
                ", _UserID='" + _UserID + '\'' +
                ", _Content='" + _Content + '\'' +
                '}';
    }
}
