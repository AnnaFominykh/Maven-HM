package hm.conn_bd.Users;

public class User {
    import jakarta.persistence.*;

import javax.annotation.processing.Generated;

    @Entity
    @Table(name = "users")
    public class User {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Integer id;
        @Column(nullable = false, unique = true, length = 45)
        private String email;
        @Column(length = 15, nullable = false)
        private String password;
        @Column( length = 45, nullable = false, name = "name")
        private String name;
        private boolean enabled;

        public Integer getId() {
            return id;
        }

        public void setId(Integer id) {
            this.id = id;
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

        public String getName() {
            return name;
        }

        public void setName(String Name) {
            this.name = name;
        }


        @Override
        public String toString() {
            return "User{" +
                    "id=" + id +
                    ", email='" + email + '\'' +
                    ", password='" + password + '\'' +
                    ", firstName='" + name + '\'' +
                    '}';
        }

        public boolean isEnabled() {
            return enabled;
        }

        public void setEnabled(boolean enabled) {
            this.enabled = enabled;
        }
    }

}
