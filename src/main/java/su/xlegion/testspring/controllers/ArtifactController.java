package su.xlegion.testspring.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.web.bind.annotation.*;
import su.xlegion.testspring.entity.Artifact;
import su.xlegion.testspring.model.Autor;
import su.xlegion.testspring.model.Book;
import su.xlegion.testspring.repository.ArtifactRepository;
import su.xlegion.testspring.repository.CommentRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("Artifact")
public class ArtifactController {

    @Autowired
    private ArtifactRepository _ArtifactRepository;
    //CrudRepository

    @GetMapping(value = "findAll", produces = "application/json")
    public List<Artifact> findAll() {
        return _ArtifactRepository.findAll();
    }

    @GetMapping(value = "count", produces = "application/json")
    public long count() {
        return _ArtifactRepository.count();
    }

    @GetMapping(value = "findById/{id}", produces = "application/json")
    public Optional<Artifact> findById(@PathVariable UUID id) { return _ArtifactRepository.findById(id); }

    @GetMapping(value = "add", produces = "application/json")
    public Artifact findById(@ModelAttribute("Artifact") Artifact artifact) { return _ArtifactRepository.save(artifact); }


}
