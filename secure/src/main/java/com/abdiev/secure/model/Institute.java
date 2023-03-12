package com.abdiev.secure.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;
import java.util.List;


@Data
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "institutes")
public class Institute {
    @Id
    @GeneratedValue(generator = "institute_seq")
    @GenericGenerator(
            name = "institute_seq",
            strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator",
            parameters = {
                    @org.hibernate.annotations.Parameter(name = "sequence_name", value = "institute_seq"),
                    @org.hibernate.annotations.Parameter(name = "initial_value", value = "0"),
                    @org.hibernate.annotations.Parameter(name = "increment_size", value = "1")
            }
    )
    private Long id;
    private String name;
    @Column(length = 1000)
    private String imageUrl;
    @Column(length = 1000)
    private String webUrl;
    @Column(length = 3000)
    private String description;
    @Column(length = 3000)
    private String frameUrl;
    @Enumerated(EnumType.STRING)
    private BiasType biasType;
    @Enumerated(EnumType.STRING)
    private InstituteType instituteType;
    @OneToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    @JoinTable(name = "institute_comments",
            joinColumns = @JoinColumn(name = "place_id"),
            inverseJoinColumns = @JoinColumn(name = "comment_id")
    )
    private List<Comment> comments;

}
