package su.xlegion.testspring.model;

import org.springframework.web.bind.annotation.ModelAttribute;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Book {
    private Autor _Autor = null;

    public String getName() {return "Pascal";}

    public Autor getAutor() { return _Autor;}
    public void setAutor(Autor value) {_Autor = value;}
}
