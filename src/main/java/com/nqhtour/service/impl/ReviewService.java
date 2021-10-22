package com.nqhtour.service.impl;

import com.nqhtour.converter.ReviewConverter;
import com.nqhtour.dto.ReviewDTO;
import com.nqhtour.entity.ClientEntity;
import com.nqhtour.entity.ReviewEntity;
import com.nqhtour.entity.TourEntity;
import com.nqhtour.repository.ClientRepository;
import com.nqhtour.repository.ReviewRepository;
import com.nqhtour.repository.TourRepository;
import com.nqhtour.service.IReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReviewService implements IReviewService {
    @Autowired
    ReviewRepository reviewRepository;

    @Autowired
    ReviewConverter reviewConverter;

    @Autowired
    ClientRepository clientRepository;

    @Autowired
    TourRepository tourRepository;

    @Override
    public ReviewDTO save(ReviewDTO dto) {
        ReviewEntity reviewEntity = reviewConverter.toEntity(dto);

        ClientEntity client = clientRepository.findOne(dto.getClientId());
        if (client != null) {
            reviewEntity.setClient(client);
        }

        TourEntity tour = tourRepository.findOne(dto.getTourId());
        if (tour != null) {
            reviewEntity.setTour(tour);

            // Update rating average of tour.
            Integer currentRatingsQuantity = tour.getRatingsQuantity() + 1;
            tour.setRatingsQuantity(currentRatingsQuantity);
            if (currentRatingsQuantity == 1) {
                tour.setRatingsAverage((float) (Math.round(dto.getRating() * 10) / 10));
            } else {
                Float currentRatingsAverage = (tour.getRatingsAverage() + dto.getRating()) / currentRatingsQuantity;
                double roundRatings = (Math.ceil(currentRatingsAverage * 10) / 10);
                tour.setRatingsAverage((float) roundRatings);
            }
            tourRepository.save(tour);
        }

        return reviewConverter.toDTO(reviewRepository.save(reviewEntity));
    }
}
