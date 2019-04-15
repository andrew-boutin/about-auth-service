package bakingbitsstudios.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@AllArgsConstructor
@Getter
@Setter
abstract class Resource {

    @NotBlank
    private final String id;

    @NotBlank
    private final String name;

    @NotBlank
    private final String version;

    @NotNull
    private final Long timeCreated;

    @NotNull
    private final Long timeUpdated;

    // We leave this field as not final so a setter will be generated and we can fill this in after instantiation.
    private String self;
}
