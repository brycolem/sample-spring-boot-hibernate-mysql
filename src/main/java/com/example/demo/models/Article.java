package com.example.demo.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "article")
public class Article {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long id;

    @NotBlank
    @Column(name = "text", nullable = false)
    private String text;

    @Column(name = "timestamp")
    @JsonFormat(pattern = "MM/dd/yyyy, hh:mm:ss a z")
    private Date timestamp;

    @NotBlank
    @Column(name = "title", nullable = false)
    private String title;

}
