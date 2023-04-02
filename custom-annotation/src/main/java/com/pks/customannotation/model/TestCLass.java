package com.pks.customannotation.model;

import com.pks.customannotation.annotation.ValidateFieldType;
import lombok.Data;

@Data
public class TestCLass {

    @ValidateFieldType
    private String testField; // validate if the field is A or B or C.
}
