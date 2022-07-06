package com.pks.twilio.service;

import com.pks.twilio.configure.TwillioConfig;
import com.pks.twilio.dto.OtpStatus;
import com.pks.twilio.dto.PasswordResetRequestDto;
import com.pks.twilio.dto.PasswordResetResponseDto;
import com.twilio.rest.api.v2010.account.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;
import com.twilio.type.PhoneNumber;


import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
@Service
public class TwillioOTPService {

    @Autowired
    private TwillioConfig twilioConfig;

    Map<String, String> otpMap = new HashMap<>();


    public Mono<PasswordResetResponseDto> sendOTPForPasswordReset(PasswordResetRequestDto passwordResetRequestDto) {
        PasswordResetResponseDto passwordResetResponseDto = null;
        try {
            PhoneNumber to = new PhoneNumber(passwordResetRequestDto.getPhoneNumber());
            PhoneNumber from = new PhoneNumber(twilioConfig.getTrialNumber());
            String otp = generateOTP();
            String otpMessage = "Dear Customer , Your OTP is ## " + otp + " ##. Use this Passcode to complete your transaction. Thank You.";
            Message message = Message
                    .creator(to, from,
                            otpMessage)
                    .create();
            otpMap.put(passwordResetRequestDto.getUserName(), otp);
            passwordResetResponseDto = new PasswordResetResponseDto(OtpStatus.DELIVERED, otpMessage);
        } catch (Exception ex) {
            passwordResetResponseDto = new PasswordResetResponseDto(OtpStatus.FAILED, ex.getMessage());
        }
        return Mono.just(passwordResetResponseDto);
    }

    public Mono<String> validateOTP(String userInputOtp, String userName) {
        if (userInputOtp.equals(otpMap.get(userName))) {
            otpMap.remove(userName,userInputOtp);
            return Mono.just("Valid OTP please proceed with your transaction !");
        } else {
            return Mono.error(new IllegalArgumentException("Invalid otp please retry !"));
        }
    }


    //6 digit otp
    private String generateOTP() {
        return new DecimalFormat("000000")
                .format(new Random().nextInt(999999));
    }


}
