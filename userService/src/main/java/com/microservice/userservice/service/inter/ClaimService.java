package com.microservice.userservice.service.inter;

import com.microservice.userservice.entity.Claim;

public interface ClaimService {
    Claim getClaimByClaimName(String claimName);
}
