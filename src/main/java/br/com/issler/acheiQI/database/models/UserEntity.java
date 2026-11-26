package br.com.issler.acheiQI.database.models;

import br.com.issler.acheiQI.enums.qiAffiliationEnum;
import br.com.issler.acheiQI.enums.qiUnitEnum;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "users")
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserEntity implements UserDetails {
    @GeneratedValue(strategy = GenerationType.UUID)
    @Id
    private UUID id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false, unique = true, length = 11)
    private String phone;

    @Enumerated(EnumType.STRING)
    @Column(name = "qi_affiliation", nullable = false)
    private qiAffiliationEnum affiliation;

    @Enumerated(EnumType.STRING)
    @Column(name = "qi_unit", nullable = false)
    private qiUnitEnum unit;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of();
    }

    @Override
    public String getUsername() { return email; }
}
