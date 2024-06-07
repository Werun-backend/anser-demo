package cc.anser.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RepoEntity {
    private Integer id;
    private Integer repoIndex;
    private String repoName;
    private String repoBranch;
    private String repoType;
}
