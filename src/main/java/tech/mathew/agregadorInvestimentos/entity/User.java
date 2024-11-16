package tech.mathew.agregadorInvestimentos.entity;

import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.Instant;
import java.util.UUID;

@Entity
@Table(name = "tb_users")
public class User{

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(name = "username")
    private String username;

    @Column(name = "email")
    private String email;

    @Column(name = "password")
    private String password;

    @CreationTimestamp
    private Instant creationTimesTamp;

    @UpdateTimestamp
    private Instant updateTimesTamp;

    public User() {
    }

    public User(UUID id, String username, String email, String password, Instant creationTimesTamp, Instant updateTimesTamp) {
        this.id = id;
        this.username = username;
        this.email = email;
        this.password = password;
        this.creationTimesTamp = creationTimesTamp;
        this.updateTimesTamp = updateTimesTamp;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Instant getCreationTimesTamp() {
        return creationTimesTamp;
    }

    public void setCreationTimesTamp(Instant creationTimesTamp) {
        this.creationTimesTamp = creationTimesTamp;
    }

    public Instant getUpdateTimesTamp() {
        return updateTimesTamp;
    }

    public void setUpdateTimesTamp(Instant updateTimesTamp) {
        this.updateTimesTamp = updateTimesTamp;
    }
}
