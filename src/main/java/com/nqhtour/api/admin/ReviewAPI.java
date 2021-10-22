package com.nqhtour.api.admin;

import com.nqhtour.dto.ReviewDTO;
import com.nqhtour.service.IReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController(value = "ReviewAPIOfAdmin")
public class ReviewAPI {
    @Autowired
    IReviewService reviewService;

    @PostMapping("/api/review")
    public ReviewDTO createReview(@RequestBody ReviewDTO dto) {
        return reviewService.save(dto);
    }

}
