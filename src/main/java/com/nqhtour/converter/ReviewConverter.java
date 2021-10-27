package com.nqhtour.converter;

import com.nqhtour.dto.ReviewDTO;
import com.nqhtour.entity.ReviewEntity;
import org.springframework.stereotype.Component;

@Component
public class ReviewConverter {
    public ReviewDTO toDTO(ReviewEntity entity) {
        ReviewDTO result = new ReviewDTO();
        result.setId(entity.getId());
        result.setReview(entity.getReview());
        result.setRating(entity.getRating());
        result.setClientId(entity.getClient().getId());
        result.setClientName(entity.getClient().getName());
        result.setTourId(entity.getTour().getId());
        result.setCreatedDate(entity.getCreatedDate());

        return result;
    }

    public ReviewEntity toEntity(ReviewDTO dto) {
        ReviewEntity result = new ReviewEntity();
        result.setReview(dto.getReview());
        result.setRating(dto.getRating());

        return result;
    }
}
