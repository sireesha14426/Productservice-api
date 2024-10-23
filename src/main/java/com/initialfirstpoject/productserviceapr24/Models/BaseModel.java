package com.initialfirstpoject.productserviceapr24.Models;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.autoconfigure.web.WebProperties;

import java.util.Date;

@Data
@NoArgsConstructor
@MappedSuperclass
public class BaseModel {
        @Id
        @GeneratedValue(strategy=GenerationType.IDENTITY)
        private Integer id;
        private Date createdat;
        private Date updatedat;
}
