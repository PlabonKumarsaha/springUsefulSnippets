package com.pks.bucket4j.bucket4j.Servce;

import com.pks.bucket4j.bucket4j.Packages;
import io.github.bucket4j.Bandwidth;
import io.github.bucket4j.Bucket;
import io.github.bucket4j.Refill;
import java.time.Duration;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class RateLimitPriceService {

  private String free = "FREE";
  private String basic ="BASIC";
  private String premium = "PREMIUM";

  public Bucket getPlanServiceBucket(String clientToken){
    return Bucket.builder().addLimit(getClientBandWidth(clientToken))
        .build();
  }

  private Bandwidth getClientBandWidth(String clientToken){
    if(clientToken.equals(basic)){
    return Bandwidth.classic(5, Refill.of(5, Duration.ofMinutes(1)));
    }else if(clientToken.equals(premium)){
      return Bandwidth.classic(10,Refill.of(10, Duration.ofMinutes(1)));
    }else {
      return Bandwidth.classic(1,Refill.of(1, Duration.ofMinutes(1)));
    }
  }
}
