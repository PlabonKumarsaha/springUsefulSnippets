
//https://medium.com/@aedemirsen/hibernate-prepersist-and-preupdate-4a3599d244ec
@Entity
@Table
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
@Getter
@Setter
public class Company extends BaseDatedEntity {
    private String name;
    private String email;
    private String phoneNumber;

    @OneToMany(fetch = FetchType.LAZY, 
               cascade = {CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH}
    )
    @JoinColumn(name = "company_id")
    private List<Address> addresses = new ArrayList<>();
}

@MappedSuperclass
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
@Getter
@Setter
public class BaseDatedEntity extends BaseEntity{
    @Column(name = "CREATE_DATE")
    private LocalDateTime createDate;

    @Column(name = "UPDATE_DATE")
    private LocalDateTime updateDate;

    @PrePersist
    public void onPrePersist() {
        this.setCreateDate(LocalDateTime.now());
        this.setUpdateDate(LocalDateTime.now());
    }

    @PreUpdate
    public void onPreUpdate() {
        this.setUpdateDate(LocalDateTime.now());
    }
}

@MappedSuperclass
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
@Getter
@Setter
@ToString
public abstract class BaseEntity implements Serializable {
      @Id
      @GeneratedValue(strategy = GenerationType.IDENTITY)
      private Long id;
}
