package twitter;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.hibernate.validator.constraints.Email;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class Twitter {

    private Long id;
    @NotNull
    @Size(min = 5, max = 16, message = "{username.size}")
    private String username;
    @NotNull
    @Size(min = 5, max = 25, message = "{password.size}")
    private String password;
    @NotNull
    @Size(min = 2, max = 30, message = "{firstname.size}")
    private String firstName;
    @NotNull
    @Size(min = 2, max = 30, message = "{lastname.size}")
    private String lastName;
    @NotNull
    @Email(message = "{email.valid}")
    private String email;

    public Twitter(String username, String password, String firstName, String lastName, String email) {
        this(null, username, password, firstName, lastName, email);

    }

    public Twitter(Long id, String username, String password, String firstName, String lastName, String email) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }
    public Twitter() {
    }

    public Long getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    @Override
    public boolean equals(Object that) {
        return EqualsBuilder.reflectionEquals(this, that, new String[]{"firstName", "lastName", "username", "password", "email"});
    }

    @Override
    public int hashCode() {
        return HashCodeBuilder.reflectionHashCode(this, new String[]{"firstName", "lastName", "username", "password", "email"});
    }
}
