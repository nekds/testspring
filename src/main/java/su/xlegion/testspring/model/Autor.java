package su.xlegion.testspring.model;

import org.springframework.web.bind.annotation.ModelAttribute;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Autor {
    private String _Name;

    public String getName() {return _Name;}
    public void setName(String value) {_Name = value;}
}
