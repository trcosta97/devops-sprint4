package br.com.hearMeOut.userCrud.domain.user;

import br.com.hearMeOut.userCrud.domain.address.Address;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;




import java.time.LocalDateTime;

@Entity(name = "User")
@Table(name = "tb_user")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(of = "id")
public class User{
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "user_seq")
    @SequenceGenerator(name = "user_seq", sequenceName = "user_seq", allocationSize = 1)
    private Long id;
    @Column(name = "name", nullable = false)
    private String name;
    @Column(name = "cpf", nullable = false, unique = true, updatable = false )
    private String cpf;
    @Column(name = "email", nullable = false, unique = true)
    private String email;
    @Column (name = "password", nullable = false)
    private String password;
    @JoinColumn(name = "address_id", nullable = false)
    @OneToOne(cascade = CascadeType.ALL)
    @JsonIgnore
    private Address address;
    @Column(name = "gender", nullable = false)
    @Enumerated(EnumType.STRING)
    private Gender gender;
    @Column(name = "sign_date")
    @Temporal(TemporalType.TIMESTAMP)
    private LocalDateTime signDate;
    @Column(name="status",columnDefinition = "NUMBER(1)")
    private Boolean status;

    public User(UserSignInData data) {
        this.name = data.name();
        this.cpf = data.cpf();
        this.email = data.email();
        this.password = data.password();
        this.address = new Address(data.address());
        this.gender = data.gender();

    }

    public User(UserUpdateData data) {
        this.email = data.email();
        this.password = data.password();
    }

    @PrePersist
    public void prePersist(){
        this.signDate = LocalDateTime.now();
        this.status = true;
    }

}


