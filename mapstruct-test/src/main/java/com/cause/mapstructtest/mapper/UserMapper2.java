package com.cause.mapstructtest.mapper;

import com.cause.mapstructtest.mapstruct.User;
import com.cause.mapstructtest.mapstruct.UserDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.mapstruct.ReportingPolicy;

/**
 * @author cause
 * @date 2022/3/24
 */
@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.ERROR,
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface UserMapper2 {

//  UserMapper2 INSTANCE = Mappers.getMapper(UserMapper2.class);

  @Mapping(target = "name", source = "name", defaultValue = "dasdadda000000")
  @Mapping(target = "age", ignore = true)
  UserDTO userMap(User user);

}
