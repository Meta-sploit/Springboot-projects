package com.learning.JPATutorial.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Embeddable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@AttributeOverrides({
        @AttributeOverride(
                name="name",
                column = @Column(name = "gaurdian_name")
        ),
        @AttributeOverride(
                name="mobile",
                column = @Column(name = "gaurdian_mobile")
        ),
        @AttributeOverride(
                name="emailId",
                column = @Column(name = "gaurdian_emailId")
        )
})
@Embeddable
public class Gaurdian {
    private String name;
    private String mobile;
    private String emailId;
}
