package com.example.HealthBridge.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "approval_status")
public class ApprovalStatus {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    private Status status;

    @ManyToOne
    @JoinColumn(name = "approved_by", nullable = true)
    private Users approvedBy;

    private boolean isDeleted;

    @ManyToOne
    @JoinColumn(name = "rejected_by", nullable = true)
    private Users rejectedBy;

    private LocalDateTime approvalTimestamp;

    private LocalDateTime rejectionTimestamp;

    @OneToOne
    @JoinColumn(name = "facility_id", nullable = false)
    private Facility facility;

}
