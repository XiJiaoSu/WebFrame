package webframe.pojo;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;


@Entity
@Table(name="t_users")
public class User {

    @Id
    @GeneratedValue(generator ="uuid")
    @GenericGenerator(name = "uuid",strategy = "uuid")
    private String id;

    @Embedded
    @AttributeOverrides({@AttributeOverride(name="firstName",column = @Column(name = "first_name")),
            @AttributeOverride(name = "lastName",column = @Column(name = "last_name"))})
    private FullName fullName;

    private String password;

    public String getPassword() {
        return password;
    }



    public void setPassword(String password) {
        this.password = password;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public FullName getFullName() {
        return fullName;
    }

    public void setFullName(FullName fullName) {
        this.fullName = fullName;
    }
}
