package com.raxrot.school;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Students {
    private String firstName;
    private String lastName;
    private String email;
}
