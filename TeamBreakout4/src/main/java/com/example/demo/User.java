package com.example.demo;

import lombok.*;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;

@ToString
@RequiredArgsConstructor
public class User{

    @Id
    private ObjectId userId;
    @Getter @Setter @NonNull private String username, password, fullname;

}