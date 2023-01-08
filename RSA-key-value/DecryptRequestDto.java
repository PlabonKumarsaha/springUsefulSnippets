package com.bracits.fingerprint.dto;

import javax.validation.constraints.NotNull;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class DecryptRequestDto {

  @NotNull
  private String encryptedMessage;

}
