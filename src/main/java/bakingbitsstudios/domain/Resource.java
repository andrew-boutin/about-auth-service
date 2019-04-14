package bakingbitsstudios.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
abstract class Resource {

    private final String id;
    private final String name;

    // We leave this field as not final so a setter will be generated and we can fill this in after instantiation.
    private String self;
}
