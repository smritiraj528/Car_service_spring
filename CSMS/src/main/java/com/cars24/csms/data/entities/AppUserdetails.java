package com.cars24.csms.data.entities;

import jakarta.persistence.*;
import lombok.Data;
@Entity
@Table(name="userdetails")
@Data
public class AppUserdetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String username;
    private String password;
    private boolean isEnabled;

    public boolean isEnabled() {
        return isEnabled;
    }

    public void setEnabled(boolean enabled) {
        isEnabled = enabled;
    }
}
