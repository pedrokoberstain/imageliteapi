package io.github.pedrokoberstain.imageliteapi.domain.service;

import io.github.pedrokoberstain.imageliteapi.domain.entity.Image;
import jakarta.transaction.Transactional;

public interface ImageService {
    Image save(Image image);
}
