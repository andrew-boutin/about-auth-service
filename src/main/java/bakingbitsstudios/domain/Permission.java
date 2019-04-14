package bakingbitsstudios.domain;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Permission {

    private final String id;
    private final String name;

    private String self;
}
