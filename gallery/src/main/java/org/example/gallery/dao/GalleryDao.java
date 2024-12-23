package org.example.gallery.dao;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.example.gallery.dto.GalleryDto;

@Mapper
public interface GalleryDao {
    @Insert("insert into gallery values " +
            "(seq_gallery.nextval , #{title} , #{description} , " +
            "#{point}, #{category}, #{originalFileName}, #{renameFileName}, sysdate)")
    int write(GalleryDto galleryDto);
}
