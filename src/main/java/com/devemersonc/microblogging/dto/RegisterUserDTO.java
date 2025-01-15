package com.devemersonc.microblogging.dto;

import com.devemersonc.microblogging.model.Role;
import jakarta.persistence.Column;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
import java.util.List;

public class RegisterUserDTO {
    @NotNull(message = "Nombre de usuario no puede ser null.")
    @NotBlank(message = "El nombre de usuario es obligatorio.")
    @Size(min = 3, max = 30, message = "El nombre de usuario debe contener entre 3 a 30 caracteres")
    private String username;
    @NotNull(message = "La contraseña no puede ser null.")
    @NotBlank(message = "La contraseña es obligatoria.")
    private String password;
    @Email(message = "Ingresa un email válido.")
    @NotNull(message = "El email no puede ser null.")
    @NotBlank(message = "El email es obligatorio.")
    private String email;
    @Column(updatable = false)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date createdAt;
    private Date updatedAt;
    private List<Role> roles;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

    public List<Role> getRoles() {
        return roles;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }

    @PrePersist
    protected void onCreate() {
        this.createdAt = new Date();
    }

    @PreUpdate
    protected void onUpdate() {
        this.updatedAt = new Date();
    }
}
