package cc.anser.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class AssertionEntity {
    private String var;
    private String match;
    private String result;

}
