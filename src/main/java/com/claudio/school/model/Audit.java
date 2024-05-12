package com.claudio.school.model;

import jakarta.persistence.*;
import lombok.Data;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.util.Date;

@Data
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public abstract class Audit {

    @CreatedDate
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "ts_inclusao", updatable = false)
    private Date dataInclusao;

    @LastModifiedDate
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "ts_alteracao")
    private Date dataAlteracao;

}
