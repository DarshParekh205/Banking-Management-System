package web.app.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "accounts")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String accountId;

    @Column(nullable = false)
    private String currency;

    @Column(nullable = false, length = 5)
    private char symbol;

    @Column(nullable = false, length = 3)
    private String code;

    @Column(nullable = false)
    private String accountName;

    @Column(nullable = false, unique = true)
    private long accountNumber;

    @Column(nullable = false, precision = 19, scale = 2)
    private BigDecimal balance;

    private String label;

    @UpdateTimestamp
    @Column(nullable = false, updatable = false)
    private LocalDateTime createdAt;

    @ManyToOne
    @JoinColumn(name = "Owner_id")
    private User owner;

    @OneToMany(mappedBy = "account", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Transactions> transactions;
}