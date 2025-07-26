package com.chovin.blog.mapper;
import com.chovin.blog.domain.dto.CategoryDto;
import com.chovin.blog.domain.entities.Category;
import com.chovin.blog.domain.entities.PostStatus;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.ReportingPolicy;
@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface CategoryMapper {


    @Mapping(target = "postCount", source = "posts", qualifiedByName = "calculatePostCount")
    CategoryDto toDto(Category category);
    @Named("calculatePostCount")
    default long calculatePostCount(java.util.Set<com.chovin.blog.domain.entities.Post> posts) {
        if (posts == null) {
            return 0;
        }
        return posts.stream()
                .filter(post-> PostStatus.PUBLISHED.equals(post.getStatus()))
                .count();
    }
}
