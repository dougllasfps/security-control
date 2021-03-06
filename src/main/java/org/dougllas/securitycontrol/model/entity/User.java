package org.dougllas.securitycontrol.model.entity;

import lombok.*;

import org.springframework.data.jpa.convert.threeten.Jsr310JpaConverters;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;

import java.time.LocalDate;
import java.util.Collection;

/**
 * Criado por dougllas.sousa em 14/03/2018.
 */

@Entity
@Table(name = "users")
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class User implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter@Setter
    private Long id;

    @Column
    @Getter@Setter
    private String username;

    @Column
    @Getter@Setter
    private String password;

    @Column
    @Getter@Setter
    private String name;

    @Column
    @Getter@Setter
	private String email;
    
    @Column
    @Getter@Setter
    @Convert(converter = Jsr310JpaConverters.LocalDateConverter.class)
    private LocalDate since;

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return null;
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}

}