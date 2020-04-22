package su.xlegion.testspring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import  su.xlegion.testspring.entity.Artifact;

import java.util.UUID;

@Component
@Repository
public interface ArtifactRepository extends JpaRepository<Artifact, UUID> { }
