package learning.springboot.models;

import lombok.Data;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.List;

@Data
@Entity (name = "speakers")
public class Speaker {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long speaker_id;
    private String first_name;
    private String last_name;
    private String title;
    private String company;
    private String speaker_bio;

    @Lob
    @Type(type = "org.hibernate.type.BinaryType")
    private byte[] speaker_photo;

    @ManyToMany (mappedBy = "speakers")
    private List<Session> sessions;

    public Speaker() {
    }
}
