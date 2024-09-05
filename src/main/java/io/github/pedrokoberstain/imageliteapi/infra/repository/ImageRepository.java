package io.github.pedrokoberstain.imageliteapi.infra.repository;

import io.github.pedrokoberstain.imageliteapi.domain.entity.Image;
import io.github.pedrokoberstain.imageliteapi.domain.enums.ImageExtension;
import io.github.pedrokoberstain.imageliteapi.infra.repository.specs.GenericSpecs;
import io.github.pedrokoberstain.imageliteapi.infra.repository.specs.ImageSpecs;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.util.StringUtils;

import java.util.List;

import static io.github.pedrokoberstain.imageliteapi.infra.repository.specs.ImageSpecs.nameLike;
import static io.github.pedrokoberstain.imageliteapi.infra.repository.specs.ImageSpecs.tagsLike;

public interface ImageRepository extends JpaRepository<Image, String>, JpaSpecificationExecutor<Image> {

    default List<Image> findByExtensionAndNameOrTagsLike(ImageExtension extension, String query) {
        Specification<Image> spec = Specification.where(GenericSpecs.conjunction());

        if (extension != null) {
            spec = spec.and(ImageSpecs.extensionEqual(extension));
        }

        if (StringUtils.hasText(query)) {
            spec = spec.and(Specification.where(nameLike(query)).or(tagsLike(query)));
        }

        return findAll(spec);
    }
}
