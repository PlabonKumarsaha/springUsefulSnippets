package com.pks.graphql.input;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class BookInput {

    String title;
    String description;
    String author;
    double price;
    Integer pages;
}
