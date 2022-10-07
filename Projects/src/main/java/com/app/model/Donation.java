package com.app.model;

import java.time.LocalDateTime;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
@Table(name = "donation")
public class Donation {
	@Id
	@Column(name = "donation_id", updatable = false, nullable = false)
	@SequenceGenerator(name="pk_donation",sequenceName="seq_dns", allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="pk_donation")
	private Long id;

	@Column(name = "event_id", nullable = false)
	private String eventId;

	@Column(name = "donation_title",  nullable = false)
	private String title;

	@Column(name = "donation_target", nullable = false)
	private String target;

	@Column(name = "donation_deadline",  nullable = false)
	@Temporal(TemporalType.DATE)
	private Date deadline;

	@Column(name = "donation_status", nullable = false)
	private int status;

	@Column(name = "donation_file",  nullable = false)
	private String file;

	@Column(name = "donation_photo",  nullable = false)
	private String photo;
	
	@Column(name = "payment_id", nullable = false)
	private String payment;

	@CreationTimestamp
	@Column(name = "created_at",  updatable = false)
	private LocalDateTime createdAt;

	@UpdateTimestamp
	@Column(name = "updated_at", updatable = false)
	private LocalDateTime updatedAt;

}
