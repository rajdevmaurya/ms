package com.nseed.product.entity;

import java.time.LocalDateTime;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Builder
@Table(name = "PRODUCT")
public class Product  {

	@Id
	@SequenceGenerator(name="product_seq", sequenceName = "PRODUCT_SQ", allocationSize = 1, initialValue = 10)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "product_seq")
	@Column(name = "PRODUCT_ID")
	private Long productId;

    @NotNull(message = "Product name is required.")
    @Basic(optional = false)
    @Size(min=2, message="Name should have at least 2 characters")
    private String name;

    @NotEmpty
    @Pattern(regexp="^[a-zA-Z0-9_]*$")
    @Column(name = "SKU")
    private String sku;

    @ManyToOne
    private Category category;

    private Boolean featured;

    @Column(name="is_active")
    private Boolean active;

    @Positive
    private Long price;

    private String description;

    @Column(name="image_path")
    private String imageUrl;

    private Integer availableQuantities;
 

    @CreationTimestamp
    private LocalDateTime createdAt;

    @UpdateTimestamp
    private LocalDateTime updatedAt;

}
