package io.github.pedrokoberstain.imageliteapi.application.images;

import io.github.pedrokoberstain.imageliteapi.domain.entity.Image;
import io.github.pedrokoberstain.imageliteapi.domain.service.ImageService;
import io.github.pedrokoberstain.imageliteapi.infra.repository.ImageRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ImageServiceImpl implements ImageService {

    private final ImageRepository repository;

    @Override
    @Transactional
    public Image save(Image image) {
        return repository.save(image);
    }

    @Override
    public Optional<Image> getById(String id) {
        return repository.findById(id);
    }
}
