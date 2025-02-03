package com.microservice.userservice.service.impl;

import com.microservice.userservice.dao.ClaimDao;
import com.microservice.userservice.entity.Claim;
import com.microservice.userservice.service.inter.ClaimService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ClaimServiceImpl implements ClaimService {
    private ClaimDao claimDao;

    @Override
    public Claim getClaimByClaimName(String claimName) {
        return claimDao.getClaimByClaimName(claimName);
    }
}
