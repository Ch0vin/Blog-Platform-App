package com.chovin.blog.repository;

import com.chovin.blog.domain.entities.Tag;
import org.mapstruct.control.MappingControl;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;
@Repository
public interface TagRepository extends JpaRepository<Tag, UUID> {
}
