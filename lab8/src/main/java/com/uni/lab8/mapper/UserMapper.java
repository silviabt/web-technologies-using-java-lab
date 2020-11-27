package com.uni.lab8.mapper;

import com.uni.lab8.domain.User;
import com.uni.lab8.dto.UserDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring")
public interface UserMapper {

    @Mappings(
            {
                    @Mapping(target = "cnp", source = "userDetails.cnp"),
                    @Mapping(target = "age", source = "userDetails.age"),
                    @Mapping(target = "otherInformation", source = "userDetails.otherInformation")
            }
    )
    UserDto mapToDto(User user);

    @Mappings(
            {
                    @Mapping(target = "userDetails.cnp", source = "cnp"),
                    @Mapping(target = "userDetails.age", source = "age"),
                    @Mapping(target = "userDetails.otherInformation", source = "otherInformation")
            }
    )
    User mapToEntity(UserDto userDto);

}
