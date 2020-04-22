package su.xlegion.testspring.controllers;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.*;
//import su.xlegion.testspring.entity.Artifact;
//import su.xlegion.testspring.model.Autor;
//import su.xlegion.testspring.model.Book;
//import su.xlegion.testspring.repository.ArtifactRepository;
//import su.xlegion.testspring.repository.CommentRepository;
//
//import java.util.List;
//
//@RestController
//@RequestMapping("first")
//public class FirstController {
//
//    @GetMapping(value = "", produces = "application/json")
//    public Book first() {
//        return new Book();
//    }
//    @PostMapping(value = "byAutor", produces = "application/json")
//    public Book first1(@ModelAttribute("Autor") Autor autor) {
//        return new Book(){{setAutor(autor);}};
//    }
//
//    @Autowired
//    private ArtifactRepository _ArtifactRepository;
//    @Autowired
//    private CommentRepository _CommentRepository;
//
//    public FirstController () {
//        //Repositories r = Repositories.getInstance();
//    }
//    @GetMapping(value = "all", produces = "application/json")
//    public List<Artifact> all() {
//        return _ArtifactRepository.findAll();
//    }
////    @Autowired
////    public FirstController(ArtifactRepository artifactRepository) {
////        this.artifactRepository = artifactRepository;
////    }
//}
