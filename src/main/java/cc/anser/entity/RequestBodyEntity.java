package cc.anser.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class RequestBodyEntity {
    private String key;
    private String value;
}
