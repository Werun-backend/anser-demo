package cc.anser.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class VariableEntity {
    private String name;
    private String value;
}
