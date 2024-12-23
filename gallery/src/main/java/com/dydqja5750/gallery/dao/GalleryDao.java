package com.dydqja5750.gallery.dao;

import com.dydqja5750.gallery.dto.GalleryDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface GalleryDao {
    int write(GalleryDto galleryDto);
    List<GalleryDto> getList();
}


